package motordepot.servlet.commands.user;

import motordepot.entities.bean.MotorDepotEjbDao;
import motordepot.servlet.actions.ActionCommandMD;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class provide method execute that executes command LOGOUT
 * Created by Nick Mandrik on 15.05.2017.
 */
public class LogoutCommand implements ActionCommandMD{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp, MotorDepotEjbDao motorDepot) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }

		/*
		 * Second step : Invalidate all cookies by, for each cookie received,
		 * overwriting value and instructing browser to deletes it
		 */
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                cookie.setValue("-");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        return "index.jsp";
    }
}
