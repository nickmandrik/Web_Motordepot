package motordepot.servlet.commands.user;



import motordepot.entities.User;
import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.entities.exceptions.DaoException;
import motordepot.servlet.MotorDepotServlet;
import motordepot.servlet.actions.ActionCommandMD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class provide method execute that executes command ADD_USER
 * Created by Nick Mandrik on 15.05.2017.
 */
public class AddUserCommand implements ActionCommandMD {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp,
                          MotorDepotEjbDao motorDepot) {

        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        String role = req.getParameter("role");

        Object er = req.getAttribute("err");
        int afterCheck = 0;
        if (er != null) {
            afterCheck = Integer.parseInt(String.valueOf(er));
        }

        if (afterCheck != 1) {
            User newUser = new User();
            newUser.setLogin(login);
            newUser.setPassword(pass);
            newUser.setRole(role);

            try {
                if(!motorDepot.addUser(newUser)) {
                    req.getSession().setAttribute("errok",
                            "Пользователь с логином " + login +" уже существует");
                    return "static/pages/registration.jsp";
                }
            } catch (DaoException e) {
                req.getSession().setAttribute("errors",
                        newUser);
                MotorDepotServlet.logger.error(e.getMessage());
                return "static/pages/registration.jsp";
            }
        } else {
            return "static/pages/registration.jsp";
        }
        return "static/pages/login.jsp";
    }
}
