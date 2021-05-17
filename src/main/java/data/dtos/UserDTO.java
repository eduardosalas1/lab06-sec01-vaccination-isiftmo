package data.dtos;
import java.util.Calendar;

public class UserDTO {
    String dni;
    String name;
    String lastname;
    String email;
    String phone;
    Calendar birthdate;

    public UserDTO(String name, String lastname, String email, String phone, String dni, Calendar birthdate){
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

    public Calendar getBirthdate() { return birthdate; }

    public void setBirthdate(Calendar birthdate) { this.birthdate = birthdate; }
}