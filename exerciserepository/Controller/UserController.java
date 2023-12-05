package com.example.exerciserepository.Controller;


import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;



    @GetMapping("/get")
    public ResponseEntity getAllUser() {

        return ResponseEntity.status(200).body(userService.getAllUses());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.addUses(user);
        return ResponseEntity.status(200).body("user added");

    }
//
    @PutMapping("/update/{id}")
    public ResponseEntity updateDelete(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        User userUpdate = userService.updateUser(id, user);

        return ResponseEntity.status(200).body(userUpdate);

    }
//
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {

        userService.deleteUser(id);

        return ResponseEntity.status(200).body("user deleted");
    }


    @GetMapping("/searchUserByEmail/{email}")
    public ResponseEntity searchUserByEmail(@PathVariable String email) {

        User user = userService.searchUsesByEmail(email);
        return ResponseEntity.status(200).body(user);


    }


@GetMapping("/searchUserByRole/{role}")
public ResponseEntity searchUserByRole(@PathVariable String role) {

    List<User> user = userService.searchByRole(role);
    return ResponseEntity.status(200).body(user);


}



@GetMapping("/ageGreater/{age}")
public ResponseEntity ageGreater(@PathVariable Integer age){
    List<User> user = userService.ageGreater(age);
    return ResponseEntity.status(200).body(user);

}



@GetMapping("/check/{username}/{password}")
public ResponseEntity check(@PathVariable String username ,@PathVariable String password){

        User user = userService.Check(username,password);
    return ResponseEntity.status(200).body(user);

}

}



