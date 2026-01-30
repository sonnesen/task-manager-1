package com.task_manager.task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task_manager.task_manager.entity.task.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}