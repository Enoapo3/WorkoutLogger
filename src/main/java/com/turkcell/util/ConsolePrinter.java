package com.turkcell.util;

import com.turkcell.entity.User;
import com.turkcell.entity.WorkoutLog;

import java.util.List;

public class ConsolePrinter {

    // ANSI renk kodları
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BOLD = "\u001B[1m";

    /**
     * Kullanıcı listesini renkli tablo halinde yazdırır.
     */
    public static void printUsers(List<User> users) {
        System.out.println(BOLD + BLUE + "\n--- Kullanıcı Listesi ---" + RESET);
        System.out.printf(BOLD + "%-5s %-20s" + RESET + "\n", "ID", "İsim");
        System.out.println("-------------------------------------------------");
        users.forEach(u ->
                System.out.printf(GREEN + "%-5d %-20s" + RESET + "\n",
                        u.getId(), u.getName())
        );
    }

    /**
     * Workout kayıtlarını renkli tablo halinde yazdırır.
     */
    public static void printWorkoutLogs(List<WorkoutLog> logs) {
        System.out.println(BOLD + PURPLE + "\n--- Workout Geçmişi ---" + RESET);
        System.out.printf(BOLD + "%-5s %-10s %-12s %-20s %-10s" + RESET + "\n",
                "ID", "UserID", "Tarih", "Egzersiz", "Tekrar");
        System.out.println("--------------------------------------------------------------------");

        logs.forEach(log ->
                System.out.printf(CYAN + "%-5d %-10d %-12s %-20s %-10d" + RESET + "\n",
                        log.getId(),
                        log.getUserId(),
                        log.getDate(),
                        log.getExerciseName(),
                        log.getReps())
        );
    }

    /**
     * Hata mesajlarını kırmızı renkte basar.
     */
    public static void printError(String message) {
        System.out.println(RED + "HATA: " + message + RESET);
    }

    /**
     * Bilgi mesajlarını sarı renkte basar.
     */
    public static void printInfo(String message) {
        System.out.println(YELLOW + message + RESET);
    }
}
