package com.turkcell.repository.user;

import com.turkcell.entity.User;

import java.util.*;

/**
 * InMemoryUserRepository
 * -----------------------
 * User verilerini RAM üzerinde saklar.
 * Gerçek veritabanı yok → HashMap kullanıyoruz.
 */

public class InMemoryUserRepository implements IUserRepository {

    private final Map<Integer, User> users = new HashMap<>();
    private int counter = 1; // ID atamak için sayaç

    @Override
    public User save(User entity) {
        if (entity.getId() == 0) { // yeni kayıt
            entity.setId(counter++);
        }
        users.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void deleteById(Integer id) {
        users.remove(id);
    }
}
