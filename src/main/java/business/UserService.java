package business;

import business.custom_exceptions.CustomNotFoundException;
import data.dtos.UserDTO;
import data.entities.User;
import data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(UserDTO userDTO){
        var user = new User();
        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setDni(userDTO.getDni());
        user.setBirthdate(userDTO.getBirthdate());
        return userRepository.save(user);
    }

    public User findUserByDni(String dni){
        Optional<User> userOptional = userRepository.findByDni(dni);
        if(userOptional.isPresent()) return userOptional.get();
        else throw new CustomNotFoundException("EL usuario con el id " + dni + " no existe!");
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Calendar findVaccinationDateByDni(String dni){
        User user = findUserByDni(dni);
        Calendar birthdate = user.getBirthdate();
        Calendar vaccinationDate = Calendar.getInstance();
        vaccinationDate.set(Calendar.YEAR, 2021);
        vaccinationDate.set(Calendar.MONTH, birthdate.get(Calendar.MONTH));
        vaccinationDate.set(Calendar.DAY_OF_MONTH, birthdate.get(Calendar.DAY_OF_MONTH));
        return vaccinationDate;
    }
}