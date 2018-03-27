package Przyrost_3.entities;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "CREW_MEMBER", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class CrewMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "profession")
    private  String profession;



    public CrewMember() {}

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

    public String getProfession() {
        return profession;
    }
    public void setProfession( String profession ) {
        this.profession = profession;
    }


}
