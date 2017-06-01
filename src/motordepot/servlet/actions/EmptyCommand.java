package motordepot.servlet.actions;

import motordepot.entities.bean.MotorDepotEjbDao;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Nick Mandrik on 21.04.2017.
 * EmptyCommand
 */
public class EmptyCommand implements ActionCommandMD {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp, MotorDepotEjbDao motorDepot) {
        return null;
    }
}
