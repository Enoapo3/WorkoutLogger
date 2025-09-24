package com.turkcell.service;

import com.turkcell.entity.WorkoutLog;

import java.util.List;

/**
 * IWorkoutLogService
 * ------------------
 * Workout kayıtlarıyla ilgili iş kurallarını tanımlar.
 */

public interface IWorkoutLogService {

    // Workout kaydı ekle
    WorkoutLog addWorkoutLog(int userId, String exerciseName, int reps);

    // Kullanıcının tüm workoutlarını listele
    List<WorkoutLog> getWorkoutsByUser(int userId);

    // Kullanıcının toplam tekrar sayısını döndür
    int getTotalRepsByUser(int userId);
}
