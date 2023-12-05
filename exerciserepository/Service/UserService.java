package com.example.exerciserepository.Service;

import com.example.exerciserepository.API.ApiException;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;



    public List<User>  getAllUses(){

        return userRepository.findAll();
    }


    public void addUses(User user){

        userRepository.save(user);
    }
//
    public User updateUser(Integer id , User user){

        User user1 = userRepository.findUserById(id);
        if(user==null){
            throw new ApiException("Uses id not found");

        }
        user1.setName(user1.getName());


        userRepository.save(user1);
        return user;
    }


    public void deleteUser(Integer id){

        User user = userRepository.findUserById(id);
        if(user == null){
            throw new ApiException("user id not found");
        }
        userRepository.delete(user);

    }

    public User searchUsesByEmail(String email){
        User user = userRepository.findByEmail(email);
        if(user == null){

            throw new ApiException("user email not found");
        }

        return user;
    }


    public List<User> searchByRole(String role){

        List<User> userList = userRepository.findUserByRole(role);
        if(userList.isEmpty()){
            throw new ApiException("role not found");
        }
        return userList;

    }

    public List<User> ageGreater(Integer age){
        List<User> userList = userRepository.findByAgeGreaterThanEqual(age);

        if(userList.isEmpty()){
            throw new ApiException("age found");

        }
        return userList;

    }

    public  User Check(String username , String password){

        User user = userRepository.pleasCheckPasswordAndUsername(username,password);

        if(user == null){
            throw new ApiException("username and password not correct");

        }
        return user;
    }



}
