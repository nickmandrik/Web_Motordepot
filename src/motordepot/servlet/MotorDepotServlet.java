package motordepot.servlet;

import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.servlet.actions.ActionCommandFactory;
import motordepot.servlet.actions.ActionCommandMD;
import motordepot.servlet.actions.EnumCommands;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static motordepot.entities.constants.DaoStaticContent.PERSISTENCE_UNIT_NAME;

/**
 * MotorDepotServlet provide HttpServlet to execute requests from user
 * Created by Nick Mandrik on 22.04.2017.
 */
public class MotorDepotServlet extends HttpServlet {

    /**
     * Variable to process count of requests
     */
    private static int counter = 0;

    /**
     * Logger
     */
    public static final Logger logger =
            LogManager.getLogger(MotorDepotServlet.class);

    /**
     * Provide EJB container
     */
    @EJB(mappedName = "ejbMotorDepot")
    private MotorDepotEjbDao motorDepot;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String page = process(req, resp);
        if(page.equals(EnumCommands.getStringCommand(EnumCommands.ADD_PASSAGE))) {
            try {
                resp.sendRedirect("serv?command=get_passages");
            } catch (IOException e) {
                MotorDepotServlet.logger.error(e.getMessage());
            }
        } else if(page.equals(EnumCommands.getStringCommand(EnumCommands.SET_DEFECTIVE_ON_CAR))) {
            try {
                resp.sendRedirect("serv?command=get_cars");
            } catch (IOException e) {
                MotorDepotServlet.logger.error(e.getMessage());
            }
        } else {
            req.getRequestDispatcher(page).forward(req, resp);
        }
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String method = req.getParameter("_method");

        if (method != null && method.equals("delete")) {
            doDelete(req, resp);
            return;
        } else if (method != null && method.equals("put")) {
            doPut(req, resp);
            return;
        }
        String page = process(req, resp);

        if (page.equals("login")) {
            resp.sendRedirect("index.jsp");
        } else {
            //resp.sendRedirect(page);
            req.getRequestDispatcher(page).forward(req, resp);
        }
        //super.doPost(req, resp);
    }

    /**
     * process request req and response resp
     * Also add 2 Cookies of last date and counter every user
     * @param req request
     * @param resp response
     * @return String with page or redirect url
     * @throws ServletException exp
     * @throws IOException exp1
     */
    private String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Cache-Control", "no-cache, no-store, " +
                "must-revalidate");
        ActionCommandFactory factory = new ActionCommandFactory();
        ActionCommandMD currentCommand = factory.defineCommand(req);

        Date date = new Date();
        counter += 1;

        Cookie lastDateCookie = new Cookie("lastDate", date.toString());
        Cookie counterCookie = new Cookie("counter", String.valueOf(counter));

        lastDateCookie.setMaxAge(60);
        counterCookie.setMaxAge(60);
        resp.addCookie(lastDateCookie);
        resp.addCookie(counterCookie);

        String page = null;
        page = currentCommand.execute(req, resp, motorDepot);
        if (page == null) {
            logger.error("Page is null");
            page = "index.jsp";
        }
        return page;
    }
}
