package com.task_manager.task_manager.service;

import java.util.List;

import com.task_manager.task_manager.entity.taskStatus.TaskStatus;
import com.task_manager.task_manager.request.TaskRequestDTO;

public interface TaskService {

    void createTask(TaskRequestDTO request);

    List<TaskService> getTasks();

    TaskService getTask(Long id);

    void updateStatus(Long id, TaskStatus status);

    void updateTask(Long id);

    void deleteTask(Long id);

}
