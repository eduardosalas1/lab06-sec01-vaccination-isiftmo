package data.dtos;
import java.util.Date;


public class UserDTO {
    String dni;
    String name;
    String lastname;
    String email;
    String phone;
    Date birthdate;

    public UserDTO(String name, String lastname, String email, String phone, String dni, Date birthdate){
        setName(name);
        setLastname(lastname);
        setDni(dni);
        setEmail(email);
        setPhone(phone);
        setBirthdate(birthdate);
    }

    public UserDTO(){}

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

    public Date getBirthdate() { return birthdate; }

    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }
}