package motordepot.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represent the Request as entity with technology JPA.
 * Represent table named 'request'.
 * Created by Nick Mandrik on 08.02.2017.
 * Modified by Nick Mandrik on 25.02.2017.
 * @author Nick Mandrik
 */
@Entity
@Table(name="request")
public class Request implements Serializable  {
    /**
     * fields in table.
     */
    private int id;
    private Integer carCountPassangers;
    private Integer carCapacity;
    private String carModel;
    /**
     * represent connect many to one with Dispatcher entity.
     */
    private Dispatcher dispatcher;
    /**
     * represent connect one to one with Passage entity.
     */
    private Passage passage;

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
     * Basic column named 'car_count_passangers'.
     */
    @Basic
    @Column(name = "car_count_passangers")
    public Integer getCarCountPassangers() {
        return carCountPassangers;
    }

    public void setCarCountPassangers(Integer carCountPassangers) {
        this.carCountPassangers = carCountPassangers;
    }

    /**
     * Basic column named 'car_capacity'.
     */
    @Basic
    @Column(name = "car_capacity")
    public Integer getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(Integer carCapacity) {
        this.carCapacity = carCapacity;
    }

    /**
     * Basic column named 'car_model'.
     */
    @Basic
    @Column(name = "car_model")
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    /**
     * Manu to one connection with Dispatcher entity.
     * By join column named 'dispatcher_id', referenced column named 'id'.
     */
    @ManyToOne
    @JoinColumn(name = "dispatcher_id", referencedColumnName = "id")
    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    /**
     * One to one connection with Passage entity.
     * By join column named 'passage_id', referenced column named 'id'.
     */
    @OneToOne
    @PrimaryKeyJoinColumn(name = "passage_id", referencedColumnName = "id")
    public Passage getPassage() {
        return passage;
    }

    public void setPassage(Passage passage) {
        this.passage = passage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (id != request.id) return false;
        if (carCountPassangers != null ? !carCountPassangers.equals(request.carCountPassangers) : request.carCountPassangers != null)
            return false;
        if (carCapacity != null ? !carCapacity.equals(request.carCapacity) : request.carCapacity != null) return false;
        if (carModel != null ? !carModel.equals(request.carModel) : request.carModel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (carCountPassangers != null ? carCountPassangers.hashCode() : 0);
        result = 31 * result + (carCapacity != null ? carCapacity.hashCode() : 0);
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append("Request{id" + id +
                ", car_count_passangers=" + carCountPassangers +
                ", car_capacity=" + carCapacity +
                ", car_model='" + carModel + '\'');
        if(dispatcher != null) {
            stb.append("driver_id=" + dispatcher.getId());
        } else {
            stb.append("dispatcher=null");
        }
        if(passage != null) {
            stb.append(", passage_id=" + passage.getId() + "}");
        } else {
            stb.append(", passage=null}");
        }
        return stb.toString();
    }
}
