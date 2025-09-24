package com.turkcell.repository.workoutlog;

import com.turkcell.entity.WorkoutLog;

import java.util.*;

/**
 * InMemoryWorkoutLogRepository
 * -----------------------------
 * WorkoutLog verilerini RAM üzerinde saklar.
 */

public class InMemoryWorkoutLogRepository implements IWorkoutLogRepository {

    private final Map<Integer, WorkoutLog> logs = new HashMap<>();
    private int counter = 1;

    @Override
    public WorkoutLog save(WorkoutLog entity) {
        if (entity.getId() == 0) { // yeni kayıt
            entity.setId(counter++);
        }
        logs.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<WorkoutLog> findById(Integer id) {
        return Optional.ofNullable(logs.get(id));
    }

    @Override
    public List<WorkoutLog> findAll() {
        return new ArrayList<>(logs.values());
    }

    @Override
    public void deleteById(Integer id) {
        logs.remove(id);
    }
}
