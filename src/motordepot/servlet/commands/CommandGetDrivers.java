package motordepot.servlet.commands;

import motordepot.entities.Driver;
import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.entities.exceptions.DaoException;
import motordepot.servlet.MotorDepotServlet;
import motordepot.servlet.actions.ActionCommandMD;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Class provide method execute that executes command GET_DRIVERS
 * Created by Nick Mandrik on 21.04.2017.
 */
public class CommandGetDrivers implements ActionCommandMD{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp,
                          MotorDepotEjbDao motorDepot) {

        List<Driver> drivers = null;
        try {
            drivers = motorDepot.getDrivers();
        } catch (DaoException e) {
            req.getSession().setAttribute("getDriversError",
                    "Can't load drivers");
            MotorDepotServlet.logger.error(e.getMessage());
        }
        req.setAttribute("drivers", drivers);
        return "static/pages/drivers.jsp";
    }
}
