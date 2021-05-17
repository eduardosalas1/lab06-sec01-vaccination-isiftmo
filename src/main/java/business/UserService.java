package business;

import business.custom_exceptions.CustomNotFoundException;
import data.dtos.UserDTO;
import data.entities.User;
import data.repositories.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(UserDTO userDTO) throws Exception {
        var user = new User();
        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setDni(userDTO.getDni());
        user.setBirthdate(userDTO.getBirthdate());
        String apellidodepapa = consult(userDTO.getDni());
        if (apellidodepapa == userDTO.getLastname())
            return userRepository.save(user);
        throw new Exception("Datos erroneos con respecto a ese DNI");
    }

    public User findUserByDni(String dni) {
        Optional<User> userOptional = userRepository.findByDni(dni);
        if (userOptional.isPresent()) return userOptional.get();
        else throw new CustomNotFoundException("EL usuario con el id " + dni + " no existe!");
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Calendar findVaccinationDateByDni(String dni) {
        User user = findUserByDni(dni);
        Calendar birthdate = user.getBirthdate();
        Calendar vaccinationDate = Calendar.getInstance();
        vaccinationDate.set(Calendar.YEAR, 2021);
        vaccinationDate.set(Calendar.MONTH, birthdate.get(Calendar.MONTH));
        vaccinationDate.set(Calendar.DAY_OF_MONTH, birthdate.get(Calendar.DAY_OF_MONTH));
        return vaccinationDate;
    }

    public String consult(String dni) throws IOException, JSONException {
        URL consult = new URL("https://ws-consultas.herokuapp.com/api/dni/" + dni);
        URLConnection connectionvariable = consult.openConnection();
        StringBuilder response = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(connectionvariable.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
        JSONObject ciudadano = new JSONObject(response.toString());
        return ciudadano.getString("apellido_p");
    }
}


