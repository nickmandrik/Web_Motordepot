package motordepot.servlet.commands.user;

import motordepot.entities.User;
import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.servlet.actions.ActionCommandMD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class provide method execute that executes command DELETE_USER
 * Created by Nick Mandrik on 15.05.2017.
 */
public class DeleteUserCommand implements ActionCommandMD {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp,
                          MotorDepotEjbDao motorDepot) {
        int userId = Integer.parseInt(req.getParameter("user_id"));

        User user = (User) req.getSession().getAttribute("user");
        if (user.getId() == userId) {
            req.getSession().invalidate();
            return "index.jsp";
        }

        return "/serv?command=get_drivers";
    }
}
