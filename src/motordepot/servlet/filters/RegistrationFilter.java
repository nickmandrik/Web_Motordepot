package motordepot.servlet.filters;


import motordepot.entities.User;
import motordepot.entities.bean.MotorDepotEjbDao;

import javax.ejb.EJB;
import javax.persistence.Persistence;
import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class-filter to provide correct data to input in registration form
 * Created by Nick Mandrik on 15.05.2017.
 */
public class RegistrationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String command = servletRequest.getParameter("command");
        if (command == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (command.equals("add_user")) {
            registrFilter(servletRequest, servletResponse, filterChain);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    private void registrFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        Map<String, List<String>> errors = new HashMap<>();

        String login = servletRequest.getParameter("login");
        String pass = servletRequest.getParameter("pass");
        String role = servletRequest.getParameter("role");

        List<String> loginEr = new ArrayList<>();
        List<String> passEr = new ArrayList<>();

        User user = new User();
        user.setLogin(login);
        user.setPassword(pass);
        user.setRole(role);

        boolean check = true;
        if (pass.isEmpty()) {
            passEr.add("Введите пароль");
            check = false;
        } else if (pass.trim().length() < 5 || pass.trim().length() > 128) {
            passEr.add("Минимум 5 символов. Максимум - 128");
            check = false;
        }

        if (login.isEmpty()) {
            loginEr.add("Введите логин.");
            check = false;
        } else if (login.trim().length() < 5 || login.trim().length() > 30) {
            loginEr.add("Минимум 5 символов. Максимум - 128");
            check = false;
        }

        if (!check) {
            servletRequest.setAttribute("err", 1);
            errors.put("login", loginEr);
            errors.put("pass", passEr);
            servletRequest.setAttribute("errors", errors);
            servletRequest.getRequestDispatcher("static/pages/registration.jsp")
                    .forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
