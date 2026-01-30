package com.task_manager.task_manager.entity.taskStatus;

import com.task_manager.task_manager.entity.task.TaskStatus;

public class DoneStatus implements TaskStatusStrategy {

    @Override
    public TaskStatus next() {
        throw new IllegalStateException("Task already done!");
    }

    @Override
    public String getName() {
        return TaskStatus.DONE.name();
    }

}
