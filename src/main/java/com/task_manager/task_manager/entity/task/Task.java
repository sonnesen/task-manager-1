package com.task_manager.task_manager.entity.task;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.task_manager.task_manager.entity.taskStatus.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private TaskStatus status;

    @CreatedDate
    private LocalDateTime createdAt;

}
