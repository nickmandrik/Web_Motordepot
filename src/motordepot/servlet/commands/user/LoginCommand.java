package motordepot.servlet.commands.user;


import motordepot.entities.User;
import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.entities.exceptions.DaoException;
import motordepot.entities.exceptions.DaoResourceException;
import motordepot.servlet.MotorDepotServlet;
import motordepot.servlet.actions.ActionCommandMD;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class provide method execute that executes command LOGIN
 * Created by Nick Mandrik on 15.05.2017.
 */
public class LoginCommand implements ActionCommandMD {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp,
                          MotorDepotEjbDao motorDepot) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login == null || password == null) {
            return "static/pages/login.jsp";
        }

        User user = null;
        try {
            user = motorDepot.getUser(login, password);
        } catch (DaoException e) {
            req.getSession().setAttribute("get user error",
                    "Can't login because of DaoException");
            MotorDepotServlet.logger.error(e.getMessage());
        }


        if (user == null) {
            req.setAttribute("error", "Неверный логин или пароль");
            return "static/pages/login.jsp";
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            return "login";
        }
    }
}
