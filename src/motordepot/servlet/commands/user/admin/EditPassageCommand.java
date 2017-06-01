package motordepot.servlet.commands.user.admin;


import motordepot.entities.Passage;
import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.entities.exceptions.DaoException;
import motordepot.entities.exceptions.DaoResourceException;
import motordepot.servlet.MotorDepotServlet;
import motordepot.servlet.actions.ActionCommandMD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class provide method execute that executes command EDIT_PASSAGE
 * Created by Nick Mandrik on 15.05.2017.
 */
public class EditPassageCommand implements ActionCommandMD {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp,
                          MotorDepotEjbDao motorDepot) {
        int passageId = Integer.parseInt(req.getParameter("passage_id"));
        try {
            Passage passage = motorDepot.getPassageById(passageId);
            req.setAttribute("passage", passage);
        } catch (DaoException e) {
            MotorDepotServlet.logger.error(e.getMessage());
        } catch (DaoResourceException e) {
            MotorDepotServlet.logger.error(e.getMessage());
        }

        return "static/pages/edit_passage.jsp";
    }
}
