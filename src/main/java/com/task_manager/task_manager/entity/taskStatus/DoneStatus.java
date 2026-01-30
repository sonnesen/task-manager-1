package com.task_manager.task_manager.entity.taskStatus;

public class DoneStatus implements TaskStatusStrategy {

    @Override
    public TaskStatus next() {
        throw new IllegalStateException("Task already done!");
    }

}
