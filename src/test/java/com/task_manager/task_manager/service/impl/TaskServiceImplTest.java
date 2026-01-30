package com.task_manager.task_manager.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.task_manager.task_manager.entity.task.Task;
import com.task_manager.task_manager.entity.task.TaskStatus;
import com.task_manager.task_manager.repository.TaskRepository;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    private TaskServiceImpl taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskServiceImpl(taskRepository);
    }

    @Test
    void constructor_shouldThrowNullPointerException_whenRepositoryIsNull() {
        assertThrows(NullPointerException.class, () -> new TaskServiceImpl(null));
    }

    @Test
    void createTask_shouldSaveTaskAndReturnModelWithId() {
        // Given
        final var expectedTitle = "Test Task";
        final var expectedDescription = "Test Description";

        when(taskRepository.save(any(Task.class))).thenAnswer(invocation -> {
            Task task = invocation.getArgument(0);
            task.setId(1L);
            return task;
        });

        // When
        Task result = taskService.createTask(expectedTitle, expectedDescription);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test Task", result.getTitle());
        assertEquals("Test Description", result.getDescription());
        assertEquals(TaskStatus.PENDING, result.getStatus());
        assertNotNull(result.getCreatedAt());

        verify(taskRepository).save(any(Task.class));
    }

    @Test
    void updateStatus_shouldUpdateTaskStatusToNext() {
        // Given
        final var expectedTaskId = 1L;
        final var existingTask = new Task(1L, "Test", "Description", TaskStatus.PENDING, LocalDateTime.now());
        final var updatedTask = new Task(1L, "Test", "Description", TaskStatus.IN_PROGRESS, LocalDateTime.now());

        when(taskRepository.findById(expectedTaskId)).thenReturn(Optional.of(existingTask));
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);

        // When
        taskService.updateStatus(expectedTaskId);

        // Then
        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);

        verify(taskRepository).save(taskCaptor.capture());

        final var savedTask = taskCaptor.getValue();
        assertEquals(TaskStatus.IN_PROGRESS, savedTask.getStatus());
    }

    @Test
    void updateStatus_shouldThrowException_whenTaskNotFound() {
        // Given
        final var expectedTaskId = 999L;
        when(taskRepository.findById(expectedTaskId)).thenReturn(Optional.empty());

        // When & Then
        RuntimeException exception = assertThrows(RuntimeException.class,
            () -> taskService.updateStatus(expectedTaskId));
        assertEquals("Task with ID 999 not found", exception.getMessage());
        verify(taskRepository, never()).save(any(Task.class));
    }

    @Test
    @Disabled
    void getAllTasks_shouldReturnNull() {

    }

    @Test
    @Disabled
    void getTaskById_shouldReturnNull() {

    }

    @Test
    @Disabled
    void updateTask_shouldReturnNull() {

    }

    @Test
    @Disabled
    void deleteTask_shouldDoNothing() {

    }
}