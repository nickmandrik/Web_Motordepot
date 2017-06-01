package motordepot.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Represent the dispatcher as entity with technology JPA.
 * Represent table named 'dispatcher'.
 * Created by Nick Mandrik on 08.02.2017.
 * Modified by Nick Mandrik on 25.02.2017.
 * @author Nick Mandrik
 */
@Entity
@Table(name = "dispatcher")
public class Dispatcher implements Serializable {
    /**
     * fields in table.
     */
    private int id;
    private String fio;
    /**
     * represent connect one to many with Request entity.
     */
    private Collection<Request> requests;

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
     * Connection with Request entity.
     * Mapped by dispatcher.
     */
    @ElementCollection
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dispatcher")
    public Collection<Request> getRequests() {
        return requests;
    }

    public void setRequests(Collection<Request> requests) {
        this.requests = requests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dispatcher that = (Dispatcher) o;

        if (id != that.id) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;

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
        StringBuilder stb = new StringBuilder("Dispatcher{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", requests_id=[");
        if(requests != null) {
            for (Request req : requests) {
                stb.append(" " + req.getId() + ",");
            }
        }
        stb.append("]}");
        return  stb.toString();
    }
}
