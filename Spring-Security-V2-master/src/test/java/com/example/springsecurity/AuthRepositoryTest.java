package com.example.springsecurity;

import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.repository.AuthRepository;
import com.example.springsecurity.repository.TodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class AuthRepositoryTest {
    @Autowired
    TodoRepository todoRepository;

    @Autowired
    AuthRepository authRepository;

    Todo todo1,todo2,todo3;
    MyUser myUser;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"Maha" , "12345" , "ADMIN" , null);


        todo1 = new Todo(null , "todo1" , myUser );
        todo2 = new Todo(null , "todo2", myUser );
        todo3 = new Todo(null , "todo3", myUser );
    }
/*    MyUser findMyUserById(Integer id);


    MyUser findMyUserByUsername(String username);*/

    @Test
    public void findMyUserByUsernameTesting(){
        authRepository.save(myUser);

        MyUser user= authRepository.findMyUserByUsername(myUser.getUsername());
        Assertions.assertThat(user.getUsername()).isEqualTo(myUser.getUsername());
    }

    @Test
    public void findMyUserById(){


        authRepository.save(myUser);

        MyUser user= authRepository.findMyUserById(myUser.getId());
        Assertions.assertThat(myUser).isEqualTo(user);
    }

}