package com.example.springsecurity;

import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.repository.AuthRepository;
import com.example.springsecurity.repository.TodoRepository;
import com.example.springsecurity.service.AuthService;
import com.example.springsecurity.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)

public class AuthServiceTest {


    @InjectMocks
    AuthService authService;
    //TodoService todoService;


    @Mock
    TodoRepository todoRepository;
    @Mock
    AuthRepository authRepository;


    Todo todo1, todo2, todo3;
    MyUser myUser;
    List<Todo> todos;

    @BeforeEach
    void setUp() {
        myUser = new MyUser(null, "Maha", "12345", "ADMIN", null);


        todo1 = new Todo(null, "todo1", myUser);
        todo2 = new Todo(null, "todo2", myUser);
        todo3 = new Todo(null, "todo3", myUser);
    }



    @Test
    public void registerTest() {

      //  when(authRepository.findMyUserById(myUser.getId())).thenReturn(myUser);

        authService.register(myUser);

      //  verify(authRepository, times(1)).findMyUserById(myUser.getId());
        verify(authRepository, times(1)).save(myUser);


    }


}