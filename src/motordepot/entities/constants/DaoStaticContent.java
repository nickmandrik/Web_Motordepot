package motordepot.entities.constants;

import java.io.Serializable;

/**
 * Class contains static strings used in Dao entities and DaoException
 * Created by Nick Mandrik on 13.02.2017.
 * Modified by Nick Mandrik on 25.02.2017.
 * @author Nick Mandrik
 */
public class DaoStaticContent implements Serializable{
    public static final String PERSISTENCE_UNIT_NAME =
            "MotorDepot";

    public static final String CANT_INSERT_PASSAGE =
            "Can't insert passage.";
    public static final String CANT_GET_PASSAGES_BY_DRIVER =
            "Can't get passages by driver";
    public static final String CANT_SET_DEFECTIVE_ON_CAR =
            "Can't set defective on car.";
    public static final String CANT_GET_DEFFECTIVE_CARS =
            "Can't get defective cars.";
    public static final String CANT_GET_PASSAGES =
            "Can't get passages.";
    public static final String CANT_GET_CARS =
            "Can't get cars.";
    public static final String CANT_GET_DRIVERS =
            "Can't get drivers.";
    public static final String DRIVER_IS_NULL =
            "Driver wasn't founded.";
    public static final String CANT_GET_DRIVER =
            "Can't get driver.";
    public static final String CANT_GET_CAR =
            "Can't get car.";
    public static final String CAR_IS_NULL =
            "Car wasn't founded.";

    public static final String CANT_GET_USER =
            "Can't get user from database.";
    public static final String CANT_ADD_USER =
            "Can't add user";
    public static final String CANT_DELETE_USER =
            "Can't delete user";
    public static final String USER_IS_NULL =
            "User is null";
    public static final String CANT_GET_PASSAGE =
            "Can't get passage";
    public static final String PASSAGE_IS_NULL =
            "Passage is null";
    public static final String CANT_UPDATE_PASSAGE =
            "Can't update passage";
}
