package com.ejemplo.taskapi.repository;

import com.ejemplo.taskapi.model.Task;
import com.ejemplo.taskapi.model.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Buscar tareas por estado
    List<Task> findByStatus(TaskStatus status);

    // Buscar tareas de un usuario
    List<Task> findByUserId(Long userId);

    // Buscar tareas por categoría
    List<Task> findByCategoryId(Long categoryId);

    // Buscar tareas por estado y usuario
    List<Task> findByStatusAndUserId(TaskStatus status, Long userId);

    // Traer todas las tareas con user y category cargados
    @Query("""
        SELECT t
        FROM Task t
        JOIN FETCH t.user
        JOIN FETCH t.category
    """)
    List<Task> findAllWithUserAndCategory();

    // Traer una tarea con user y category cargados
    @Query("""
        SELECT t
        FROM Task t
        JOIN FETCH t.user
        JOIN FETCH t.category
        WHERE t.id = :id
    """)
    Optional<Task> findByIdWithUserAndCategory(Long id);

    @Procedure(procedureName = "count_pending_tasks")
    Integer countPendingTasks(Long user_id_param);
}