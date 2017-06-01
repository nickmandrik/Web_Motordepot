package motordepot.servlet.commands;

import motordepot.entities.Car;
import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.entities.exceptions.DaoException;
import motordepot.servlet.MotorDepotServlet;
import motordepot.servlet.actions.ActionCommandMD;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Class provide method execute that executes command GET_CARS
 * Created by Nick Mandrik on 21.04.2017.
 */
public class CommandGetCars implements ActionCommandMD {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp,
                          MotorDepotEjbDao motorDepot) {
        List<Car> cars = null;
        try {
            cars = motorDepot.getCars();
        } catch (DaoException e) {
            req.getSession().setAttribute("getCarsError", "Can't load cars");
            MotorDepotServlet.logger.error(e.getMessage());
        }
        req.setAttribute("cars", cars);
        req.setAttribute("isDefectives", new Boolean(false));
        return "static/pages/cars.jsp";
    }

}
