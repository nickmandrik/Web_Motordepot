package motordepot.entities.exceptions;

import java.io.Serializable;

/**
 * Be thrown in Dao classes when something go wrong.
 * Created by Nick Mandrik on 09.02.2017.
 * Modified by Nick Mandrik on 25.02.2017.
 * @author Nick Mandrik
 */
public class DaoException extends Exception implements Serializable{

    public DaoException(String message) {
        super(message);
    }

    public DaoException( Exception e) {
        super(e);
    }

    public DaoException(String message, Exception e) {
        super(message, e);
    }
}
