package com.example.hw17.Repostry;

import com.example.hw17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User>  findUserByRole(String Role);

    @Query("select role from User role where role.id=?1")
    User findUserbyId(Integer id);
    User findUserByEmail(String email);

    @Query("select u from User u where u.age>=?1")
    List<User> findUsersByAge(Integer age);

    User findUsersByUsernameAndPassword(String username, String password);





}
