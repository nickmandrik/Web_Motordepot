package motordepot.servlet.commands.user.admin;

import motordepot.entities.Passage;
import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.entities.exceptions.DaoException;
import motordepot.entities.exceptions.DaoResourceException;
import motordepot.servlet.MotorDepotServlet;
import motordepot.servlet.actions.ActionCommandMD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Class provide method execute that executes command UPDATE_PASSAGE
 * Created by Nick Mandrik on 15.05.2017.
 */
public class UpdatePassageCommand implements ActionCommandMD {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp,
                          MotorDepotEjbDao motorDepot) {
        int driverId = Integer.parseInt(req.getParameter("driver_id"));
        String strIsMade = req.getParameter("made_is");
        int id = Integer.parseInt(req.getParameter("passage_id"));

        boolean isError = false;
        try {
            boolean isMade = false;
            if(strIsMade.equals("Yes")) {
                isMade = true;
            }
            Passage passage = new Passage();
            passage.setId(id);
            passage.setIsMade(isMade);
            passage.setDriver(motorDepot.getDriverById(driverId));
            motorDepot.updatePassage(passage);
        } catch (DaoException | DaoResourceException e) {
            req.setAttribute("editPassage",
                    "Ошибка во время изменения рейса. " +
                            "Неверно определен идентификатор водителя");
            req.setAttribute("isError", true);
            isError = true;
            MotorDepotServlet.logger.error(e.getMessage());
        }

        List<Passage> passages = null;
        try {
            passages = motorDepot.getPassages();
        } catch (DaoException e) {
            MotorDepotServlet.logger.error(e);
        }

        req.setAttribute("passages", passages);
        req.setAttribute("isByDriver", new Boolean(false));
        if(!isError) {
            req.setAttribute("editPassage",
                    "Изменение рейса успешно произведено");
        }
        req.setAttribute("isError", isError);

        return "static/pages/passages.jsp";
    }
}

