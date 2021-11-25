package tk.apap.sibusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.apap.sibusiness.model.UserModel;
import tk.apap.sibusiness.repository.UserDB;

import javax.transaction.Transactional;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 3e7d908ae955262a03ddfd8f420fa42848fa38c9

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public UserModel updateUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return userDB.findByUsername(username);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
<<<<<<< HEAD
=======

    @Override
    public List<UserModel> getUserList() {
        return userDB.findAll();
    }
>>>>>>> 3e7d908ae955262a03ddfd8f420fa42848fa38c9
}
