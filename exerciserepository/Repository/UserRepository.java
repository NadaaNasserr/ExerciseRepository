package com.example.exerciserepository.Repository;


import com.example.exerciserepository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {

    User findUserById(Integer id);
    User findByEmail(String email);
    List<User> findUserByRole(String role);
    List<User> findByAgeGreaterThanEqual(Integer age);
    @Query("select c from User c where c.username=?1 and c.password=?2")
    User pleasCheckPasswordAndUsername(String username, String password);


    @Query("select c from User c where c.email=?1")
    User emailUser(String email);

}
