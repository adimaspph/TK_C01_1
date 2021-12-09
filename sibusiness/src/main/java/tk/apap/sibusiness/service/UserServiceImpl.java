package tk.apap.sibusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.apap.sibusiness.model.UserModel;
import tk.apap.sibusiness.repository.UserDB;

import javax.transaction.Transactional;
import java.util.List;

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
    public Integer updateUser(UserModel user, String passLama, String passKonfirm) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserModel userLama = getUserByUuid(user.getUuid());

        if (!passKonfirm.equals(user.getPassword())) {
            return 0;
        }

        if (passwordEncoder.matches(passLama , userLama.getPassword())) {
            String pass = encrypt(user.getPassword());
            user.setPassword(pass);
            userDB.save(user);
            return 1;
        }
        return -1;
    }

    @Override
    public void updateUserRole(UserModel user) {
        userDB.save(user);
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return userDB.findByUsername(username);
    }

    @Override
    public UserModel getUserByUuid(String uuid) {
        return userDB.findUserModelByUuid(uuid);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getUserList() {
        return userDB.findAll();
    }
}
