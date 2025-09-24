package com.turkcell.service;

import com.turkcell.entity.User;

import java.util.List;

/**
 * IUserService
 * ------------
 * Kullanıcılarla ilgili iş kurallarını tanımlar.
 */

public interface IUserService {

    // Yeni kullanıcı ekle
    User addUser(String name);

    // Tüm kullanıcıları getir
    List<User> getAll();
}