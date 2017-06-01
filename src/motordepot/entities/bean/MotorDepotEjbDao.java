package motordepot.entities.bean;

import motordepot.entities.*;
import motordepot.entities.exceptions.DaoException;
import motordepot.entities.exceptions.DaoResourceException;

import javax.ejb.Remote;

import java.util.Collection;
import java.util.List;

/**
 * Remote interface to use java bean MotorDepot
 * @author Nick Mandrik
 */
@Remote
public interface MotorDepotEjbDao {
    /**
     * @param id driver id
     * @return Driver object if object with id exists else return null
     */
    public Driver getDriverById(int id) throws DaoException, DaoResourceException;

    /**
     * @return List of all passages
     */
    public List<Passage> getPassages() throws DaoException;

    /**
     * @param driver entity Driver
     * @return Collection contains of all passages by driver contain in database
     */
    public List<Passage> getPassagesByDriver(Driver driver) throws DaoException;

    /**
     * insert Passage entity in table 'passage' in database
     */
    public void insertPassage(Passage passage) throws DaoException;

    /**
     * @return List<Car> object of any operation of select cars in database
     */
    public List<Car> getDefgectiveCars() throws DaoException;

    /**
     * @return List of all cars contains in table 'car'
     */
    public List<Car> getCars() throws DaoException;

    /**
     * @return List of all drivers contains in table 'driver'
     */
    public List<Driver> getDrivers() throws DaoException;

    /**
     * @param id id of the car
     * Set defective equals true of the car
     */
    public boolean setDefectiveOnCar(int id) throws DaoException;

    /**
     * @param id car id
     * @return Car object if object with id exists else return null
     */
    public Car getCarById(Integer id) throws DaoException, DaoResourceException;

    /**
     * @param login of the user
     * @param pass password to login
     * @return User object if object with login and pass exists else return null
     */
    public User getUser(String login, String pass) throws DaoException;

    /**
     * insert User entity in table 'users' in database
     * @return true if user was added other way if object with this login
     * exist return false
     */
    public boolean addUser(User user) throws DaoException;

    /**
     * delete User entity in table 'users' in database
     */
    public void deleteUser(User user) throws DaoException;

    /**
     * @param id user id
     * @return User object if object with id exists else return null
     */
    public User getUserById (int id) throws DaoException, DaoResourceException;

    /**
     * @param id passage id
     * @return Passage object if object with id exists else return null
     */
    public Passage getPassageById(Integer id) throws DaoException, DaoResourceException;

    /**
     * @param passage that should be updated
     */
    public void updatePassage(Passage passage) throws DaoException, DaoResourceException;
}
