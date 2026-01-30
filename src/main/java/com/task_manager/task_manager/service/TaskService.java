package com.task_manager.task_manager.service;

import java.util.List;
import com.task_manager.task_manager.entity.task.Task;

public interface TaskService {

    Task createTask(String title, String description);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    void updateStatus(Long id);

    void updateTask(Long id, Task task);

    void deleteTask(Long id);
}
