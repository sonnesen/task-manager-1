package com.task_manager.task_manager.entity.taskStatus;

import com.task_manager.task_manager.entity.task.TaskStatus;

public class PendingStatus implements TaskStatusStrategy {

    @Override
    public TaskStatus next() {
        return TaskStatus.IN_PROGRESS;
    }

    @Override
    public String getName() {
        return TaskStatus.PENDING.name();
    }

}
