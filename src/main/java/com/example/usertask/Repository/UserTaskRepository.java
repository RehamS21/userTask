package com.example.usertask.Repository;

import com.example.usertask.Model.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Integer> {

    UserTask findUserTaskByUsername(String username);
    UserTask findUserTaskByEmail(String email);
}
