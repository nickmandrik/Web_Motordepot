package motordepot.entities.exceptions;

import java.io.Serializable;

/**
 * Be thrown if info about some entity doesn't exist.
 * Created by Home on 11.02.2017.
 * Modified by Nick Mandrik on 25.02.2017.
 * @author Nick Mandrik
 */
public class DaoResourceException extends Exception implements Serializable {

    public DaoResourceException(String message) {
        super(message);
    }

}
