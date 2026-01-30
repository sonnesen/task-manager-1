package com.task_manager.task_manager.entity.taskStatus;

import com.task_manager.task_manager.entity.task.TaskStatus;

public interface TaskStatusStrategy {

    TaskStatus next();

    String getName();

    static TaskStatusStrategy fromName(String name) {
        return switch (name) {
            case "PENDING" -> new PendingStatus();
            case "IN_PROGRESS" -> new InProgressStatus();
            case "DONE" -> new DoneStatus();
            default -> throw new IllegalArgumentException("Unknown status: " + name);
        };
    }

}