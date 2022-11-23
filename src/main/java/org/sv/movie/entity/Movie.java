package org.sv.movie.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONE)
@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  unique = true)
    private long id;
    @Column(name = "name", nullable = false,length = 50, unique = true)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore//para indicar que no lo necesito en el json
    public Long getUserId() {
        return user.getId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "adult")
    private boolean adult;
    //@ManyToOne


    public Movie() {
    }

    public Movie(long id, String name, User user, boolean adult) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.adult = adult;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", adult=" + adult +
                '}';
    }
}
