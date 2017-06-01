package motordepot.servlet.commands;

import motordepot.entities.Passage;
import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.entities.exceptions.DaoException;
import motordepot.entities.exceptions.DaoResourceException;
import motordepot.servlet.MotorDepotServlet;
import motordepot.servlet.actions.ActionCommandMD;
import motordepot.servlet.actions.EnumCommands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Class provide method execute that executes command ADD_PASSAGE
 * Created by Nick Mandrik on 22.04.2017.
 */
public class CommandAddPassage implements ActionCommandMD {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp,
                          MotorDepotEjbDao motorDepot) {

        int driverId = Integer.parseInt(req.getParameter("driver_id"));
        String strIsMade = req.getParameter("made_is");

        List<Passage> passages = null;
        try {
            boolean isMade = false;
            if(strIsMade.equals("Yes")) {
                isMade = true;
            }
            Passage passage = new Passage();
            passage.setIsMade(isMade);
            passage.setDriver(motorDepot.getDriverById(driverId));
            motorDepot.insertPassage(passage);
            passages = motorDepot.getPassages();
        } catch (DaoException e) {
            req.getSession().setAttribute("addPassageError",
                    "Can't add new passage");
            MotorDepotServlet.logger.error(e.getMessage());
        } catch (DaoResourceException e) {
        }

        req.setAttribute("passages", passages);
        req.setAttribute("isByDriver", new Boolean(false));

        return EnumCommands.getStringCommand(EnumCommands.ADD_PASSAGE);
    }
}