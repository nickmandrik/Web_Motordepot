package motordepot.servlet.actions;

import motordepot.servlet.MotorDepotServlet;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nick Mandrik on 21.04.2017.
 * ActionCommandFactory for MotorDepot
 */
public class ActionCommandFactory {

    /**
     * define command ActionCommandMD by parameter command
     * @param request request
     * @return ActionCommand
     */
    public ActionCommandMD defineCommand(HttpServletRequest request) {
        ActionCommandMD current = new EmptyCommand();

        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }

        try {
            EnumCommands currentCommand = EnumCommands.valueOf(action.toUpperCase());
            current = currentCommand.getCommand();
        } catch (IllegalArgumentException exp) {
            request.setAttribute("wrongAction", "Wrong action");
            MotorDepotServlet.logger.error(exp.getMessage());
        }
        return current;
    }
}

