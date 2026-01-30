package com.task_manager.task_manager.service.impl;

import java.util.Objects;

import com.task_manager.task_manager.entity.task.TaskStatus;
import com.task_manager.task_manager.entity.taskStatus.TaskStatusStrategy;
import com.task_manager.task_manager.repository.TaskRepository;
import com.task_manager.task_manager.service.TaskService;
import com.task_manager.task_manager.entity.task.Task;
import java.time.LocalDateTime;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = Objects.requireNonNull(taskRepository);
    }

    @Override
    public List<Task> getAllTasks() {
        // TODO: implement
        return null;
    }

    @Override
    public Task getTaskById(Long id) {
        // TODO: implement
        return null;
    }

    @Override
    public Task createTask(String title, String description) {
        final var newTask = new Task();
        newTask.setTitle(title);
        newTask.setDescription(description);
        newTask.setStatus(TaskStatus.PENDING);
        newTask.setCreatedAt(LocalDateTime.now());
        
        return taskRepository.save(newTask);
    }

    @Override
    public void updateTask(Long id, Task task) {
        // TODO: implement
    }

    @Override
    public void deleteTask(Long id) {
        // TODO: implement
    }

    @Override
    public void updateStatus(Long id) {
        final var toUpdate = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task with ID " + id + " not found"));
        
        final var currentStatus = TaskStatusStrategy.fromName(toUpdate.getStatus().name());
        final var newStatus = TaskStatus.valueOf(currentStatus.next().name());
        toUpdate.setStatus(newStatus);

        taskRepository.save(toUpdate);
    }

}