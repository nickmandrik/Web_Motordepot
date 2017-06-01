package motordepot.servlet.commands;

import motordepot.entities.Driver;
import motordepot.entities.Passage;
import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.entities.exceptions.DaoException;
import motordepot.entities.exceptions.DaoResourceException;
import motordepot.servlet.actions.ActionCommandMD;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Class provide method execute that executes command GET_PASSAGES_BY_DRIVER
 * Created by Nick Mandrik on 22.04.2017.
 */
public class CommandGetPassagesByDriver implements ActionCommandMD {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp,
                          MotorDepotEjbDao motorDepot) {
        int driverId = Integer.parseInt(req.getParameter("driver_id"));
        Collection<Passage> passages = null;
        try {
            Driver driver = motorDepot.getDriverById(driverId);
            passages = motorDepot.getPassagesByDriver(driver);
        } catch (DaoException e) {
            req.getSession().setAttribute("getPassagesError", "Can't load passages");
        } catch (DaoResourceException e) {

        }
        req.setAttribute("passages", passages);
        req.setAttribute("isByDriver", new Boolean(true));
        req.setAttribute("driver_id", driverId);

        return "static/pages/passages.jsp";
    }
}
