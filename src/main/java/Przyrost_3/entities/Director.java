package Przyrost_3.entities;

import javax.persistence.*;
import java.time.ZonedDateTime;


@Entity
@Table(name = "DIRECTOR", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private ZonedDateTime dateofbirth;


    public Director(){}

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }

    public String getFirstName() {
        return name;
    }
    public void setFirstName( String name ) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName( String last_name ) {
        this.lastName = last_name;
    }

    public ZonedDateTime getDate_of_Birth() {
        return dateofbirth;
    }
    public void setDate_of_birth( ZonedDateTime dateofbirth ) {
        this.dateofbirth = dateofbirth;
    }

}
