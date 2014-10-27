package ru.qlogistic.manager;

import ru.qlogistic.entity.User;

public interface UserManager {
    public User findUserById(Long id);
    public User findUserByUsername(String userName);
    public void createUser(User user);
}
