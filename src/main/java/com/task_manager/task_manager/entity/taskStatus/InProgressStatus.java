package com.task_manager.task_manager.entity.taskStatus;

public class InProgressStatus implements TaskStatusStrategy {

    @Override
    public TaskStatus next() {
        return TaskStatus.DONE;
    }

}
