package com.firas.userwithvideogames.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.firas.userwithvideogames.models.LoginUser;
import com.firas.userwithvideogames.models.User;
import com.firas.userwithvideogames.repositories.UserRepository;

@Service
public class UserService {
    private static UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User create(User registerringUser) {
        String hashed = BCrypt.hashpw(registerringUser.getPassword(), BCrypt.gensalt());
        registerringUser.setPassword(hashed);
        return userRepo.save(registerringUser);
    }

    public User getUser(Long id) {
        Optional<User> potentialUser = userRepo.findById(id);
        return potentialUser.isPresent() ? potentialUser.get() : null;
    }

    public User getUser(String email) {
        Optional<User> potentialUser = userRepo.findByEmail(email);
        return potentialUser.isPresent() ? potentialUser.get() : null;
    }

    public User login(LoginUser loginUser, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }
        User existingUser = getUser(loginUser.getEmail());
        if (existingUser == null) {
            result.rejectValue("Email", "Unique", "Unknown Email!");
            return null;
        }
        if (!BCrypt.checkpw(loginUser.getPassword(), existingUser.getPassword())) {
            result.rejectValue("password", "Matches", "Incorret Password!");
            return null;
        }
        return existingUser;
    }
}