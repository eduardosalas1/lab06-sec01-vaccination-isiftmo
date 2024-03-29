package data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import static config.GlobalVariables.DB_CHAR_LENGTH;
import static config.GlobalVariables.DB_DNI_LENGTH;
import static config.GlobalVariables.DB_PHONE_LENGTH;


@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email","dni"})})
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = DB_CHAR_LENGTH)
    private String name;

    @Column(name = "lastname", length = DB_CHAR_LENGTH)
    private String lastname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", length = DB_PHONE_LENGTH, unique = true)
    private String phone;

    @Column(name = "dni", updatable = false, length = DB_DNI_LENGTH, unique = true)
    private String dni;

    @Column(name = "birthdate")
    private Calendar birthdate;

    public User(String name, String lastname, String email, String phone, String dni, Calendar birthDate){
        setName(name);
        setLastname(lastname);
        setDni(dni);
        setEmail(email);
        setPhone(phone);
        setBirthdate(birthdate);
    }

    public User(){}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getDni() { return dni; }

    public void setDni(String dni) { this.dni = dni; }

    public Calendar getBirthdate() { return birthdate; }

    public void setBirthdate(Calendar birthdate) { this.birthdate = birthdate; }
}