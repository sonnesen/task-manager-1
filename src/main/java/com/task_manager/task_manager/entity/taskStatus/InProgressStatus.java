package com.task_manager.task_manager.entity.taskStatus;

import com.task_manager.task_manager.entity.task.TaskStatus;

public class InProgressStatus implements TaskStatusStrategy {

    @Override
    public TaskStatus next() {
        return TaskStatus.DONE;
    }

    @Override
    public String getName() {
        return TaskStatus.IN_PROGRESS.name();   
    }

}
