package edu.pos.service;

import edu.pos.dto.User;

public interface UserService {
    boolean login(User user);
}