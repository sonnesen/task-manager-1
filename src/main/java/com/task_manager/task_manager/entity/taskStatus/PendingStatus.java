package com.task_manager.task_manager.entity.taskStatus;

public class PendingStatus implements TaskStatusStrategy {

    @Override
    public TaskStatus next() {
        return TaskStatus.IN_PROGRESS;
    }

}
