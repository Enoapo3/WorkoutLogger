package com.turkcell.entity;

import java.time.LocalDate;

/**
 * WorkoutLog (Antrenman Kaydı) Entity
 * -----------------------------------
 * Bu sınıf bir kullanıcının yaptığı bir antrenmanı temsil eder.
 * Her kayıtta şu bilgiler vardır:
 * - id: benzersiz kayıt numarası
 * - userId: hangi kullanıcıya ait olduğu
 * - date: antrenman tarihi
 * - exerciseName: yapılan egzersiz (ör: Bench Press)
 * - reps: tekrar sayısı (ör: 12 tekrar)
 */

public class WorkoutLog {

    // Antrenman kaydı için benzersiz ID
    private int id;

    // Bu workout'un hangi kullanıcıya ait olduğunu gösterir
    private int userId;

    // Workout tarihi
    private LocalDate date;

    // Yapılan egzersizin adı
    private String exerciseName;

    // Yapılan tekrar sayısı
    private int reps;

    // --- Constructor ---
    public WorkoutLog() {
    }

    public WorkoutLog(int id, int userId, LocalDate date, String exerciseName, int reps) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.exerciseName = exerciseName;
        this.reps = reps;
    }

    // --- Getter ve Setter Metotları ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    // --- toString Metodu ---
    @Override
    public String toString() {
        return "WorkoutLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", exerciseName='" + exerciseName + '\'' +
                ", reps=" + reps +
                '}';
    }
}