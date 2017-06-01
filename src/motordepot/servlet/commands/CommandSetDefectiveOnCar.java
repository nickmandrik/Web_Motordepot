package motordepot.servlet.commands;

import motordepot.entities.Car;
import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.entities.exceptions.DaoException;
import motordepot.entities.exceptions.DaoResourceException;
import motordepot.servlet.MotorDepotServlet;
import motordepot.servlet.actions.ActionCommandMD;
import motordepot.servlet.actions.EnumCommands;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Class provide method execute that executes command SET_DEFECTIVE_ON_CAR
 * Created by Nick Mandrik on 22.04.2017.
 */
public class CommandSetDefectiveOnCar implements ActionCommandMD {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp,
                          MotorDepotEjbDao motorDepot) {

        int carId = Integer.parseInt(req.getParameter("car_id"));
        List<Car> cars = null;
        try {
            motorDepot.setDefectiveOnCar(carId);
        } catch (DaoException e) {
            req.getSession().setAttribute("setDefectiveOnCarError",
                    "Can't set defective on car");
            MotorDepotServlet.logger.error(e.getMessage());
        }

        try {
            cars = motorDepot.getCars();
        } catch (DaoException e) {
            req.getSession().setAttribute("getCarsError",
                    "Can't get cars.");
            MotorDepotServlet.logger.error(e.getMessage());
        }

        req.setAttribute("cars", cars);
        req.setAttribute("isDefectives", new Boolean(false));
        return EnumCommands.getStringCommand(EnumCommands.SET_DEFECTIVE_ON_CAR);
    }
}
