package edu.pos.service;

import edu.pos.dto.User;
import edu.pos.entity.CustomerEntity;
import org.hibernate.mapping.List;

public interface UserService {
    boolean login(User user);

}
