package com.turkcell.repository.user;

import com.turkcell.entity.User;
import com.turkcell.repository.IRepository;

/**
 * IUserRepository
 * ----------------
 * User entity için repository interface'i.
 * IRepository'den miras alır.
 */

public interface IUserRepository extends IRepository<User, Integer> {
}
