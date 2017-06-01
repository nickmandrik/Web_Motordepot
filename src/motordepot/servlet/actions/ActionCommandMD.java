package motordepot.servlet.actions;

import motordepot.entities.bean.MotorDepotEjbDao;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface used to released all commands
 * Created by Nick Mandrik on 21.04.2017.
 */
public interface ActionCommandMD {
    /**
     * execute
     * @param req req
     * @param resp resp
     * @return String
     */
    String execute(HttpServletRequest req,
                   HttpServletResponse resp, MotorDepotEjbDao motorDepot);
}
