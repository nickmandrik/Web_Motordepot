package motordepot.servlet.commands;

import motordepot.entities.Passage;
import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.entities.exceptions.DaoException;
import motordepot.servlet.MotorDepotServlet;
import motordepot.servlet.actions.ActionCommandMD;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Class provide method execute that executes command GET_PASSAGES
 * Created by Nick Mandrik on 21.04.2017.
 */
public class CommandGetPassages implements ActionCommandMD {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp,
                          MotorDepotEjbDao motorDepot) {

        List<Passage> passages = null;
        try {
            passages = motorDepot.getPassages();
        } catch (DaoException e) {
            req.getSession().setAttribute("getPassagesError",
                    "Can't load passages");
            MotorDepotServlet.logger.error(e);
        }
        req.setAttribute("passages", passages);
        req.setAttribute("isByDriver", new Boolean(false));

        return "static/pages/passages.jsp";
    }
}

