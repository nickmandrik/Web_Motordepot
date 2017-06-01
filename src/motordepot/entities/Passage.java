package motordepot.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Represent the Passage as entity with technology JPA.
 * Represent table named 'passage'.
 * Created by Nick Mandrik on 09.02.2017.
 * Modified by Nick Mandrik on 25.02.2017.
 * @author Nick Mandrik
 */
@Entity
@Table(name = "passage")
public class Passage implements Serializable {
    /**
     * fields in table.
     */
    private int id;
    private boolean isMade;
    /**
     * represent connect many to one with Driver entity.
     */
    private Driver driver;
    /**
     * represent connect one to one with Request entity.
     */
    private Request request;


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
     * Basic column named 'is_made'.
     */
    @Basic
    @Column(name = "is_made")
    public boolean getIsMade() {
        return isMade;
    }

    public void setIsMade(boolean isMade) {
        this.isMade = isMade;
    }

    /**
     * Connection with Driver entity.
     * By join column named 'driver_id', referenced column named 'id'.
     */
    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /**
     * Connection with Request entity.
     * Mapped by 'passage'.
     */
    @OneToOne(mappedBy = "passage")
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passage passage = (Passage) o;

        if (id != passage.id) return false;
        if (isMade != passage.isMade) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append("Passage{id=" + id + ", is_made=" + isMade + ", ");
        if(driver != null) {
            stb.append("driver_id=" + driver.getId());
        } else {
            stb.append("driver=null");
        }
        if(request != null) {
            stb.append(", request_id=" + request.getId() + "}");
        } else {
            stb.append(", request=null}");
        }
        return stb.toString();
    }
}
