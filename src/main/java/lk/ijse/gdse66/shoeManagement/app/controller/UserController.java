package lk.ijse.gdse66.shoeManagement.app.controller;


import lk.ijse.gdse66.shoeManagement.app.dto.SupplierDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.UserDTO;
import lk.ijse.gdse66.shoeManagement.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    public UserController() {
        System.out.println("User is working");
    }

    @GetMapping("/getAllUser")
    List<UserDTO> getAllUser() {
        System.out.println("request received");
        return userService.getAllUsers();
    }

    @PostMapping("/save")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return userService.saveUser(userDTO);
    }

    @PatchMapping("/update")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(value = "id") String id) {
        userService.deleteUser(id);
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUserDetails(@PathVariable("id") String id) {
        return userService.getUserDetails(id);

    }

}