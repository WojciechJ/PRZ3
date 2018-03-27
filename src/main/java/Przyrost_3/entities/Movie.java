package Przyrost_3.entities;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MOVIE", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Movie {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "premiere_date")
    private ZonedDateTime premiereDate;

    @Column(name = "genre")
    private String genre;

    @Column(name = "box_office")
    private Double boxOffice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director", referencedColumnName = "id")
    Director director;


    public Movie() {}

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle( String title ) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre( String genre ){ this.genre = genre; }

    public Double getBoxOffice() { return boxOffice; }
    public void setBoxOffice( Double boxOffice ) { this.boxOffice = boxOffice; }

    public ZonedDateTime getPremiereDate() {
        return premiereDate;
    }
    public void setPremiereDate( ZonedDateTime premiereDate ) {
        this.premiereDate = premiereDate;
    }

    public Director getDirectorid(){ return director; }
    public void setDirectorid( Director director) { this.director = director; }

}
