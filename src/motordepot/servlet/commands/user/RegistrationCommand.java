package motordepot.servlet.commands.user;

import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.servlet.actions.ActionCommandMD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class provide method execute that executes command REGISTRATION
 * Created by Nick Mandrik on 15.05.2017.
 */
public class RegistrationCommand implements ActionCommandMD {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp, MotorDepotEjbDao motorDepot) {
        return "static/pages/registration.jsp";
    }
}
