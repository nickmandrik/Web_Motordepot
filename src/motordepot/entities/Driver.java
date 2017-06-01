package motordepot.entities;

import javax.persistence.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

/**
 * Represent the Driver as entity with technology JPA.
 * Represent table named 'driver'.
 * Created by Nick Mandrik on 09.02.2017.
 * Modified by Nick Mandrik on 25.02.2017.
 * @author Nick Mandrik
 */
@Entity
@Table(name = "driver")
public class Driver implements Serializable {
    /**
     * fields in table.
     */
    private int id;
    private String fio;
    /**
     * represent connect one to one with Car entity.
     */
    private Car car;
    /**
     * represent connect one to many with Passage entity.
     */
    private Collection<Passage> passages;

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
     * Basic column named 'FIO'.
     */
    @Basic
    @Column(name = "FIO")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    /**
     * Connection with Car entity.
     * By primary key named car_id, reference named 'id'.
     */
    @OneToOne
    @PrimaryKeyJoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Connection with Passage entities.
     * Mapped by 'driver'.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "driver")
    public Collection<Passage> getPassages() {
        return passages;
    }

    public void setPassages(Collection<Passage> passages) {
        this.passages = passages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (id != driver.id) return false;
        if (fio != null ? !fio.equals(driver.fio) : driver.fio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", car_id=" + car.getId() +
                ", passages=" + passages +
                '}';
    }
}
