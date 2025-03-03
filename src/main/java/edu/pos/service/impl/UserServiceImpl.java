package edu.pos.service.impl;

import edu.pos.dto.User;
import edu.pos.entity.UserEntity;
import edu.pos.repository.UserDao;
import edu.pos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserDao userDao;
    final ModelMapper modelMapper;

    @Override
    public boolean login(User user) {
        Optional<UserEntity> optionalUser = userDao.findByUsername(user.getUsername());

        if (optionalUser.isPresent()){
            UserEntity foundUser = optionalUser.get();
            return foundUser.getPassword().equals(user.getPassword());
        }

        return false;
    }
}