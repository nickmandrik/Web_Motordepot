package motordepot.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represent the Car as entity with technology JPA.
 * Represent table named 'car'
 * Created by Nick Mandrik on 09.02.2017.
 * Modified by Nick Mandrik on 25.02.2017.
 * @author Nick Mandrik
 */
@Entity
@Table(name = "car")
public class Car implements Serializable {

    /**
     * fields in table.
     */
    private int id;
    private String number;
    private boolean defective;
    private int maxPassangers;
    private int capacity;
    private String model;

    /**
     * represent connect one to one with Driver entity.
     */
    private Driver driver;

    /**
     * Id column named 'id'.
     */
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Basic column named 'number'.
     */
    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Basic column named 'defective'.
     */
    @Basic
    @Column(name = "defective")
    public boolean getDefective() {
        return defective;
    }

    public void setDefective(boolean defective) {
        this.defective = defective;
    }

    /**
     * Basic column named 'max_passangers'.
     */
    @Basic
    @Column(name = "max_passangers")
    public int getMaxPassangers() {
        return maxPassangers;
    }

    public void setMaxPassangers(int maxPassangers) {
        this.maxPassangers = maxPassangers;
    }

    /**
     * Basic column named 'capacity'.
     */
    @Basic
    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Basic column named 'model'.
     */
    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Connection with Driver entity.
     * Mapped by car.
     */
    @OneToOne(mappedBy = "car")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (defective != car.defective) return false;
        if (maxPassangers != car.maxPassangers) return false;
        if (capacity != car.capacity) return false;
        if (number != null ? !number.equals(car.number) : car.number != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + maxPassangers;
        result = 31 * result + capacity;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str = "Car{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", defective=" + defective +
                ", max_passangers=" + maxPassangers +
                ", capacity=" + capacity +
                ", model='" + model + '\'';
        if(driver != null) {
            str += ", driver_id=" + driver.getId();
        }
        str += '}';
        return str;
    }
}
