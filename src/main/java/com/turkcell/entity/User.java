package com.turkcell.entity;

/**
 * User (Kullanıcı) Entity
 * -----------------------
 * Bu sınıf uygulamadaki kullanıcıları temsil eder.
 * İçinde sadece kullanıcıya ait bilgiler (id ve isim) vardır.
 * İş kuralları veya hesaplamalar burada tutulmaz.
 * Sadece "veri modeli"dir.
 */

public class User {

    // Kullanıcıya ait benzersiz ID
    private int id;

    // Kullanıcının adı
    private String name;

    // --- Constructor (Kurucu Metotlar) ---
    // Boş constructor (bazı durumlarda Java için gerekli)
    public User() {
    }

    // Dolu constructor (id ve name alanlarını set etmek için)
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // --- Getter ve Setter Metotları ---
    // Dışarıdan id ve name erişimi için kullanılır
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // --- toString Metodu ---
    // Nesneyi konsola yazdırmak istediğimizde okunabilir format sağlar
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

