package motordepot.servlet.filters;

import motordepot.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class-filter to secure the most important actions by guests
 * Created by Nick Mandrik on 15.05.2017.
 */
public class AccessFilter implements Filter {
    private HttpSession session;

    /**
     * Roles that have suggest to manipulate with data
     */
    private enum Role {
        ADMIN("admin"),
        USER("user");

        private String role;

        Role(String role) {
            this.role = role;
        }

        public String getRole() {
            return role;
        }
    }

    /**
     * Command that should be secure
     */
    private enum Command {
        GET_PASSAGES("get_passages"),
        GET_CARS("get_cars"),
        GET_DRIVERS("get_drivers"),
        GET_PASSAGES_BY_DRIVER("get_passages_by_driver"),
        ADD_PASSAGE("add_passage"),
        GET_DEFECTIVE_CARS("get_defective_cars"),
        SET_DEFECTIVE_ON_CAR("set_defective_on_car"),
        DELETE_USER("delete_user"),
        EDIT_PASSAGE("edit_passage"),
        UPDATE_PASSAGE("update_passage");

        private String name;

        Command(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String command = servletRequest.getParameter("command");
        session = ((HttpServletRequest) servletRequest).getSession();
        Object o = session.getAttribute("user");
        User user = null;
        if (o != null) {
            user = (User) o;
            String role = user.getRole();
            if (role == Role.ADMIN.getRole()) {
                servletRequest.setAttribute("isAdmin", true);
                servletRequest.setAttribute("isUser", true);

            } else if (role == Role.USER.getRole()){
                servletRequest.setAttribute("isAdmin", false);
                servletRequest.setAttribute("isUser", true);
            } else {
                servletRequest.setAttribute("isAdmin", false);
                servletRequest.setAttribute("isUser", false);
            }
        }

        if (command == null) {
            command = "";
        }

        if (command.equals(Command.GET_PASSAGES.getName()) ||
                command.equals(Command.GET_CARS.getName()) ||
                command.equals(Command.GET_DRIVERS.getName()) ||
                command.equals(Command.GET_PASSAGES_BY_DRIVER.getName()) ||
                command.equals(Command.ADD_PASSAGE.getName()) ||
                command.equals(Command.GET_DEFECTIVE_CARS.getName()) ||
                command.equals(Command.SET_DEFECTIVE_ON_CAR.getName()) ||
                command.equals(Command.DELETE_USER.getName()) ||
                command.equals(Command.EDIT_PASSAGE.getName()) ||
                command.equals(Command.UPDATE_PASSAGE.getName())) {
            forwardUserToLogin(user, servletRequest, servletResponse, filterChain);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    /**
     * forwardUserToLogin
     * @param user user
     * @param servletRequest servletRequest
     * @param servletResponse servletResponse
     * @param filterChain filterChain
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    private void forwardUserToLogin(User user, ServletRequest servletRequest, ServletResponse servletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (user == null) {
            servletRequest.getRequestDispatcher("static/pages/login.jsp")
                    .forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
