package com.example.TaskManagement.controller;

import com.example.TaskManagement.dto.ReqRes;
import com.example.TaskManagement.entity.Task;
import com.example.TaskManagement.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class AdminUsersController {

    @Autowired
    private TaskRepo taskRepo;


    //Controllers For Admin

    //To Retrieve all the tasks
    @GetMapping("/admin/tasks")
    public ResponseEntity<Object> getAllTasks(){
        return ResponseEntity.ok(taskRepo.findAll());
    }




    //To Update a task by ID
    @PutMapping("/admin/tasks/{id}")
    public String updateOneTask(@PathVariable Integer id, @RequestBody Task task)
    {
        task.setId(id);
        taskRepo.save(task);
        return "Task Updated";
    }


    //To Delete a task by ID
    @DeleteMapping("/admin/tasks/{id}")
    public String deleteTask(@PathVariable Integer id)
    {
        taskRepo.deleteById(id);
        return "Deleted :(";
    }



    //Controllers For User


    //To Update a task by ID
    @PutMapping("/user/tasks/{id}")
    public String updateOneUTask(@PathVariable Integer id, @RequestBody Task task)
    {
        Task oneTaskToSave = new Task();
        oneTaskToSave = taskRepo.findById(id).get();
        if(Objects.equals(task.getName(), oneTaskToSave.getName()))
        {
            task.setId(id);
            taskRepo.save(task);
            return "Task Updated";
        }
        return "Error";

    }


    //To Delete a task by ID
    @DeleteMapping("/user/tasks/{id}")
    public String deleteUTask(@PathVariable Integer id, @RequestBody Task task)
    {
        Task taskToDelete = new Task();
        taskToDelete=taskRepo.findById(id).get();
        if(Objects.equals(task.getName(), taskToDelete.getName()))
        {
            taskRepo.deleteById(id);
            return "Deleted :(";
        }
        return "Error";
    }

    //Controllers For Both Admin & User

    //To Create a task
    @PostMapping("/adminuser/tasks")
    public ResponseEntity<Object> saveTask(@RequestBody ReqRes taskRequest){
        Task taskToSave = new Task();
        taskToSave.setTitle(taskRequest.getTitle());
        taskToSave.setDescription(taskRequest.getDescription());
        taskToSave.setStatus(taskRequest.getStatus());
        taskToSave.setName(taskRequest.getName());
        return ResponseEntity.ok(taskRepo.save(taskToSave));
    }
}