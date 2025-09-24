package com.turkcell.repository;

import java.util.List;
import java.util.Optional;

/**
 * IRepository (Generic Interface)
 * -------------------------------
 * Tüm repository sınıfları için ortak CRUD (Create, Read, Update, Delete) metotlarını tanımlar.
 * Generic T → entity tipini (User, WorkoutLog gibi)
 * Generic ID → entity'nin id tipini (biz int kullanıyoruz) belirtir.
 */

public interface IRepository<T, ID> {

    // Yeni kayıt ekle veya var olanı güncelle
    T save(T entity);

    // ID'ye göre kaydı bul
    Optional<T> findById(ID id);

    // Tüm kayıtları listele
    List<T> findAll();

    // ID'ye göre kaydı sil
    void deleteById(ID id);
}
