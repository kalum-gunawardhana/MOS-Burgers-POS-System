package edu.pos.controller;

import edu.pos.dto.User;
import edu.pos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        boolean logined = userService.login(user);

        if (logined){
            return ResponseEntity.ok("login successful!");
        }

        return ResponseEntity.ok("login fail!");
    }
}
