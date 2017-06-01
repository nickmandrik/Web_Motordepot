package motordepot.servlet.actions;

import motordepot.servlet.commands.*;
import motordepot.servlet.commands.user.*;
import motordepot.servlet.commands.user.DeleteUserCommand;
import motordepot.servlet.commands.user.admin.EditPassageCommand;
import motordepot.servlet.commands.user.admin.UpdatePassageCommand;

/**
 * Created by Nick Mandrik on 21.04.2017.
 * EnumCommands requires all commands that can be executed
 */
public enum EnumCommands {
    GET_PASSAGES {
        {
            this.command = new CommandGetPassages();
        }
    },

    GET_CARS {
        {
            this.command = new CommandGetCars();
        }
    },

    GET_DRIVERS {
        {
            this.command = new CommandGetDrivers();
        }
    },
    GET_PASSAGES_BY_DRIVER {
        {
            this.command = new CommandGetPassagesByDriver();
        }
    },
    ADD_PASSAGE {
        {
            this.command = new CommandAddPassage();
        }
    },
    GET_DEFECTIVE_CARS {
        {
            this.command = new CommandGetDefectiveCars();
        }
    },
    SET_DEFECTIVE_ON_CAR {
        {
            this.command = new CommandSetDefectiveOnCar();
        }
    },
    ADD_USER {
        {
            this.command = new AddUserCommand();
        }
    },
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    },
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    DELETE_USER {
        {
            this.command = new DeleteUserCommand();
        }
    },
    EDIT_PASSAGE {
        {
            this.command = new EditPassageCommand();
        }
    },
    UPDATE_PASSAGE {
        {
            this.command = new UpdatePassageCommand();
        }
    };

    ActionCommandMD command;

    public ActionCommandMD getCommand() {
        return command;
    }

    public static String getStringCommand(EnumCommands enumCommands) {
        switch(enumCommands) {
            case GET_PASSAGES:
                return "getPassages";
            case GET_CARS:
                return "getCars";
            case GET_DRIVERS:
                return "getDrivers";
            case GET_PASSAGES_BY_DRIVER:
                return "getPassagesByDriver";
            case GET_DEFECTIVE_CARS:
                return "getDefectiveCars";
            case ADD_PASSAGE:
                return "addPassage";
            case SET_DEFECTIVE_ON_CAR:
                return "setDefectiveOnCar";
            case ADD_USER:
                return "addUser";
            case REGISTRATION:
                return "registration";
            case LOGIN:
                return "login";
            case LOGOUT:
                return "logout";
            case DELETE_USER:
                return "deleteUser";
            case EDIT_PASSAGE:
                return "editPassage";
            case UPDATE_PASSAGE:
                return "updatePassage";
            default:
                return "none";
        }
    }
}
