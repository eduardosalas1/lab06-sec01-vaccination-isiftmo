package controller;

import business.UserService;
import data.dtos.UserDTO;
import data.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User postUser(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping("/{dni}")
    public User getUserByDni(@PathVariable String dni){
        return userService.findUserByDni(dni);
    }

    @GetMapping("/all_users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{dni}/vaccination_date")
    public Calendar getVaccinationDateByDni(@PathVariable String dni){
        return userService.findVaccinationDateByDni(dni);
    }

}