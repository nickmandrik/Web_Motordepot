package motordepot.entities.bean;

import motordepot.entities.*;
import motordepot.entities.exceptions.DaoException;
import motordepot.entities.exceptions.DaoResourceException;

import javax.ejb.*;
import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContextType;

import java.io.Serializable;
import java.util.List;

import static motordepot.entities.constants.DaoStaticContent.*;

/**
 * Java bean class for MotorDepot db
 * Created by Nick Mandrik on 19.03.2017.
 * @author Nick Mandrik
 */
@Stateless(mappedName = "ejbMotorDepot")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MotorDepotBean implements MotorDepotEjbDao, Serializable {

    @PersistenceContext(unitName = "MotorDepot", type =
            PersistenceContextType.TRANSACTION)
    private EntityManager em;


/*
    @Resource
    private EJBContext context;*/

    private String GET_ALL_PASSAGES = "Select pas from Passage pas";
    public static final String SELECT_CARS_WITH_DEFECTIVE =
            "select c FROM Car c WHERE c.defective = true";
    private static final String SELECT_ALL_CARS =
            "select c from Car c";
    private static final String SELECT_ALL_DRIVERS =
            "select d from Driver d";
    private static final String SELECT_PASSAGES_BY_DRIVER =
            "select p from Passage p where p.driver.id = ";
    private static final String SELECT_USER_BY_LOGIN_AND_PASS =
            "select u from User u where u.login LIKE :custLogin " +
                    "and u.password LIKE :custPass";
    private static final String SELECT_USER_BY_LOGIN =
            "select u from User u where u.login LIKE :custLogin";

    public MotorDepotBean() {}

    public Driver getDriverById (int id) throws DaoException, DaoResourceException {
        Driver driver;
        try {
            driver = em.find(Driver.class, id);
        } catch(Exception e) {
            throw new DaoException(CANT_GET_DRIVER, e);
        }
        if(driver == null) {
            throw new DaoResourceException(DRIVER_IS_NULL);
        }
        return driver;
    }

    public List<Passage> getPassages() throws DaoException {
        try {
            List<Passage> query = em.createQuery(GET_ALL_PASSAGES, Passage.class)
                    .getResultList();
            return query;
        } catch (Exception e) {
            throw new DaoException(CANT_GET_PASSAGES, e);
        }
    }

    public List<Passage> getPassagesByDriver(Driver driver) throws DaoException {
        try {
            List<Passage> passages = em.createQuery
                    (SELECT_PASSAGES_BY_DRIVER + driver.getId(), Passage.class).getResultList();
            return passages;
        } catch(Exception e) {
            throw new DaoException(CANT_GET_PASSAGES_BY_DRIVER, e);
        }
    }

    public void insertPassage(Passage passage) throws DaoException {
        try {
            //userTransaction.begin();
            em.persist(passage);
            //userTransaction.commit();
        } catch(Exception e) {
            throw new DaoException(CANT_INSERT_PASSAGE, e);
        }
    }

    public List<Car> getDefgectiveCars() throws DaoException {
        try {
            List<Car> cars = em.createQuery(SELECT_CARS_WITH_DEFECTIVE,
                    Car.class).getResultList();
            return cars;
        }
        catch(Exception e) {
            throw new DaoException(CANT_GET_DEFFECTIVE_CARS, e);
        }
    }

    public List<Car> getCars() throws DaoException {
        try {
            List<Car> cars = em.createQuery
                    (SELECT_ALL_CARS, Car.class).getResultList();
            return cars;
        } catch (Exception e) {
            throw new DaoException(CANT_GET_PASSAGES, e);
        }
    }

    public List<Driver> getDrivers() throws DaoException {
        try {
            List<Driver> cars = em.createQuery
                    (SELECT_ALL_DRIVERS, Driver.class).getResultList();
            return cars;
        } catch (Exception e) {
            throw new DaoException(CANT_GET_DRIVERS, e);
        }
    }

    public boolean setDefectiveOnCar(int id) throws DaoException {
        try {
            Car car1 = em.find(Car.class, id);
            boolean isSuccess = true;
            if(car1.getDefective()) {
                isSuccess = false;
            }
            if(isSuccess) {
                car1.setDefective(true);
            } else {
                car1.setDefective(false);
            }
            em.merge(car1);
            return isSuccess;
        }
        catch(Exception e) {
            throw new DaoException(CANT_SET_DEFECTIVE_ON_CAR, e);
        }
    }

    public Car getCarById(Integer id) throws DaoException, DaoResourceException {
        Car driver;
        try {
            driver = em.find(Car.class, id);
        } catch(Exception e) {
            throw new DaoException(CANT_GET_CAR, e);
        }
        if(driver == null) {
            throw new DaoResourceException(CAR_IS_NULL);
        }
        return driver;
    }

    public User getUser (String login, String pass) throws DaoException {
        try {
            User user = em.createQuery
                    (SELECT_USER_BY_LOGIN_AND_PASS, User.class)
                    .setParameter("custLogin", login)
                    .setParameter("custPass", pass)
                    .getSingleResult();
            return user;
        } catch (Exception e) {
            throw new DaoException(CANT_GET_USER, e);
        }
    }

    public boolean addUser(User user) throws DaoException {
        try {
            //userTransaction.begin();
            if(em.createQuery
                    (SELECT_USER_BY_LOGIN, User.class)
                    .setParameter("custLogin", user.getLogin())
                    .getResultList().size() == 0) {
                em.persist(user);
                return true;
            } else {
                return false;
            }
            //userTransaction.commit();
        } catch(Exception e) {
            throw new DaoException(CANT_ADD_USER, e);
        }
    }

    public void deleteUser(User user) throws DaoException {
        try {
            //userTransaction.begin();
            em.remove(user);
            //userTransaction.commit();
        } catch(Exception e) {
            throw new DaoException(CANT_DELETE_USER, e);
        }
    }

    public User getUserById (int id) throws DaoException, DaoResourceException {
        User user;
        try {
            user = em.find(User.class, id);
        } catch(Exception e) {
            throw new DaoException(CANT_GET_USER, e);
        }
        if(user == null) {
            throw new DaoResourceException(USER_IS_NULL);
        }
        return user;
    }

    public Passage getPassageById(Integer id)
            throws DaoException, DaoResourceException {
        Passage passage;
        try {
            passage = em.find(Passage.class, id);
        } catch(Exception e) {
            throw new DaoException(CANT_GET_PASSAGE, e);
        }
        if(passage == null) {
            throw new DaoResourceException(PASSAGE_IS_NULL);
        }
        return passage;
    }

    public void updatePassage(Passage passage)
            throws DaoException, DaoResourceException {
        try {
            em.merge(passage);
        } catch(Exception e) {
            throw new DaoException(CANT_UPDATE_PASSAGE, e);
        }
    }
}