package com.turkcell;

import com.turkcell.entity.User;
import com.turkcell.entity.WorkoutLog;

import com.turkcell.repository.user.InMemoryUserRepository;
import com.turkcell.repository.workoutlog.InMemoryWorkoutLogRepository;

import com.turkcell.service.IUserService;
import com.turkcell.service.IWorkoutLogService;

import com.turkcell.service.impl.UserServiceImpl;
import com.turkcell.service.impl.WorkoutLogServiceImpl;

import com.turkcell.util.ConsolePrinter;

import java.util.List;
import java.util.Scanner;

/**
 * Main (Uygulama Giriş Noktası)
 * ----------------------------
 * Menü üzerinden kullanıcı ve workout yönetimi yapılır.
 * Listeleme işlemleri ConsolePrinter sınıfı ile tablo formatında yapılır.
 */
public class Main {
    public static void main(String[] args) {
        // Repository ve Service nesneleri
        IUserService userService = new UserServiceImpl(new InMemoryUserRepository());
        IWorkoutLogService workoutService = new WorkoutLogServiceImpl(new InMemoryWorkoutLogRepository());

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Menü
            System.out.println("\n--- Workout Logger ---");
            System.out.println("1) Yeni kullanıcı ekle");
            System.out.println("2) Workout kaydı ekle");
            System.out.println("3) Kullanıcının workout geçmişini listele");
            System.out.println("4) Kullanıcının toplam tekrar sayısını göster");
            System.out.println("5) Tüm kullanıcıları listele");
            System.out.println("0) Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer temizle

            switch (choice) {
                case 1 -> {
                    System.out.print("Kullanıcı adı: ");
                    String name = scanner.nextLine();
                    User u = userService.addUser(name);
                    ConsolePrinter.printInfo("Kullanıcı eklendi: " + u);
                }
                case 2 -> {
                    System.out.print("Kullanıcı ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Egzersiz adı: ");
                    String exercise = scanner.nextLine();
                    System.out.print("Tekrar sayısı: ");
                    int reps = scanner.nextInt();
                    scanner.nextLine();

                    WorkoutLog log = workoutService.addWorkoutLog(userId, exercise, reps);
                    ConsolePrinter.printInfo("Workout eklendi: " + log);
                }
                case 3 -> {
                    System.out.print("Kullanıcı ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    List<WorkoutLog> logs = workoutService.getWorkoutsByUser(userId);

                    if (logs.isEmpty()) {
                        ConsolePrinter.printError("Bu kullanıcı için kayıt bulunamadı.");
                    } else {
                        ConsolePrinter.printWorkoutLogs(logs); // renkli tablo
                    }
                }
                case 4 -> {
                    System.out.print("Kullanıcı ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    int totalReps = workoutService.getTotalRepsByUser(userId);

                    if (totalReps == 0) {
                        ConsolePrinter.printError("Bu kullanıcı için workout kaydı yok.");
                    } else {
                        ConsolePrinter.printInfo("Toplam tekrar sayısı: " + totalReps);
                    }
                }
                case 5 -> {
                    List<User> users = userService.getAll();
                    if (users.isEmpty()) {
                        ConsolePrinter.printError("Hiç kullanıcı yok.");
                    } else {
                        ConsolePrinter.printUsers(users); // renkli tablo
                    }
                }
                case 0 -> {
                    ConsolePrinter.printInfo("Çıkış yapılıyor...");
                    running = false;
                }
                default -> ConsolePrinter.printError("Geçersiz seçim!");
            }
        }

        scanner.close();
    }
}