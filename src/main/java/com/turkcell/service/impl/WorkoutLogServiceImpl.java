package com.turkcell.service.impl;

import com.turkcell.entity.WorkoutLog;
import com.turkcell.repository.workoutlog.IWorkoutLogRepository;
import com.turkcell.service.IWorkoutLogService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * WorkoutLogServiceImpl
 * ----------------------
 * IWorkoutLogService'i uygular.
 * Workout ekleme, listeleme ve toplam tekrar sayısını hesaplama iş kurallarını içerir.
 */
public class WorkoutLogServiceImpl implements IWorkoutLogService {

    private final IWorkoutLogRepository logRepo;

    public WorkoutLogServiceImpl(IWorkoutLogRepository logRepo) {
        this.logRepo = logRepo;
    }

    @Override
    public WorkoutLog addWorkoutLog(int userId, String exerciseName, int reps) {
        WorkoutLog log = new WorkoutLog(0, userId, LocalDate.now(), exerciseName, reps);
        return logRepo.save(log);
    }

    @Override
    public List<WorkoutLog> getWorkoutsByUser(int userId) {
        return logRepo.findAll()
                .stream()
                .filter(log -> log.getUserId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public int getTotalRepsByUser(int userId) {
        return logRepo.findAll()
                .stream()
                .filter(log -> log.getUserId() == userId)
                .mapToInt(WorkoutLog::getReps)
                .sum();
    }
}