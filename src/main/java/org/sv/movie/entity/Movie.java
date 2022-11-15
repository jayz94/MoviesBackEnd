package org.sv.movie.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  unique = true)
    private long id;
    @Column(name = "name", nullable = false,length = 50, unique = true)
    private String name;
    @ManyToOne
    private User user;

    public Long getUserId() {
        return user.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    @Column(name = "adult")
    private boolean adult;
    //@ManyToOne

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
