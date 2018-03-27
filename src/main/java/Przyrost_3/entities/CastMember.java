package Przyrost_3.entities;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "CAST_MEMBER", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class CastMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "profession")
    private  String profession;



    public CastMember() {}

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName( String first_name ) {
        this.firstName = first_name;
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
