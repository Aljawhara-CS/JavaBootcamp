
package com.example.springsecurity;


import com.example.springsecurity.Exception.ApiException;
import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.repository.AuthRepository;
import com.example.springsecurity.repository.TodoRepository;
import com.example.springsecurity.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {


    @InjectMocks
    TodoService todoService;


    @Mock
    TodoRepository todoRepository;
    @Mock
    AuthRepository authRepository;


    Todo todo1,todo2,todo3;
    MyUser myUser;
    List<Todo> todos;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"Maha" , "12345" , "ADMIN" , null);


        todo1 = new Todo(null , "todo1", myUser );
        todo2 = new Todo(null , "todo2", myUser );
        todo3 = new Todo(null , "todo3", myUser );
    }


    @Test
    public void getTodoByIdTest()
    {

        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);

        Todo todo = todoService.getTodoByID(todo1.getId());
        Assertions.assertEquals(todo1,todo);

        verify(todoRepository,times(1)).findTodoById(todo1.getId());


    }

    @Test
    public void addTodoTest(){

        when(authRepository.findMyUserById(myUser.getId())).thenReturn(myUser);

        todoService.addTodo(myUser,todo1);
        verify(authRepository,times(1)).findMyUserById(myUser.getId());
        verify(todoRepository,times(1)).save(todo1);


    }


    @Test
    public void removeTodoTest(){

        when(authRepository.findMyUserById(myUser.getId())).thenReturn(myUser);
        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);

        todoService.removeTodo(myUser,todo1.getId());

        verify(authRepository,times(1)).findMyUserById(myUser.getId());
        verify(todoRepository,times(1)).findTodoById((todo1.getId()));


    }

    @Test
    public void updateTodoTest() {

        when(authRepository.findMyUserById(myUser.getId())).thenReturn(myUser);
        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);
        todoService.updateTodo(myUser,todo1);
        verify(authRepository,times(1)).findMyUserById(myUser.getId());
        verify(todoRepository,times(1)).findTodoById((todo1.getId()));
        verify(todoRepository,times(1)).save(todo1);

    }


}
