package com.example.springsecurity.service;


import com.example.springsecurity.Exception.ApiException;
import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.repository.AuthRepository;
import com.example.springsecurity.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

   private final TodoRepository todoRepository;
   private  final AuthRepository authRepository;


   public List<Todo> getTodos(MyUser user) {
        return todoRepository.findAllByMyUser(user);
    }

    public Todo  getTodoByID(Integer id) {
        return todoRepository.findTodoById(id);
    }


    public void addTodo(MyUser user,Todo todo) {
        MyUser found=  authRepository.findMyUserById(user.getId());

        if (found==null)
        {

            throw  new ApiException(" Not found");
        }

        todo.setMyUser(user);
        todoRepository.save(todo);
    }

    public void removeTodo(MyUser user, Integer todoId) {
        MyUser found=  authRepository.findMyUserById(user.getId());
        Todo todo=todoRepository.findTodoById(todoId);

       if(todo.getMyUser().getId()!= user.getId()){
           throw  new ApiException(" Not found");
        }

        todoRepository.deleteById(todoId);
    }

    public void updateTodo(MyUser user, Todo todoobj) {
        MyUser found=  authRepository.findMyUserById(user.getId());
        Todo todo=todoRepository.findTodoById(todoobj.getId());

        if(todo.getMyUser().getId()!= user.getId()){
            throw  new ApiException(" Not found");
        }
        todo.setMessage(todoobj.getMessage());
       todoRepository.save(todo);
    }


}
