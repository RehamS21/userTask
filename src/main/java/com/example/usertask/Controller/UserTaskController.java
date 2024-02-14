package com.example.usertask.Controller;

import com.example.usertask.Model.UserTask;
import com.example.usertask.Service.UserTaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor

public class UserTaskController {

    private final UserTaskService userTaskService;

    @GetMapping("getUser/{username}")
    public UserTask acceptUsernameOrEmail(@PathVariable String username){
        return userTaskService.userAcceptUsernameOrEmail(username);
//        return null;
    }

    @PostMapping("/add")
    public ResponseEntity addNewUser(@RequestBody @Valid UserTask userTask){
        userTaskService.addUser(userTask);
        return ResponseEntity.status(200).body("User added successfully");
    }
}
