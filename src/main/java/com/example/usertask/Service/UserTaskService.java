package com.example.usertask.Service;

import com.example.usertask.Api.ApiException;
import com.example.usertask.Model.UserTask;
import com.example.usertask.Repository.UserTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTaskService {
    private final UserTaskRepository userTaskRepository;


    public void addUser(UserTask user){
        userTaskRepository.save(user);
    }
    public UserTask userAcceptUsernameOrEmail(String username){
        UserTask usernameTask = userTaskRepository.findUserTaskByUsername(username);
        UserTask userTaskEmail = userTaskRepository.findUserTaskByEmail(username);

        if (usernameTask != null)
            return usernameTask;
        else if (userTaskEmail != null) {
            return userTaskEmail;
        }

        throw new ApiException("Sorry incorrect username or email");
    }
}
