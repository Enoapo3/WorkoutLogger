package com.turkcell.service.impl;

import com.turkcell.entity.User;
import com.turkcell.repository.user.IUserRepository;
import com.turkcell.service.IUserService;

import java.util.List;

/**
 * UserServiceImpl
 * ---------------
 * IUserService interface'ini uygular.
 * Kullanıcı ekleme ve listeleme iş kurallarını içerir.
 */
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepo;

    public UserServiceImpl(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User addUser(String name) {
        // Yeni User oluştur
        User u = new User(0, name); // id = 0 → repo otomatik atayacak
        return userRepo.save(u);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }
}
