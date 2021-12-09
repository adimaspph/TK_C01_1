package tk.apap.sibusiness.service;

import tk.apap.sibusiness.model.UserModel;
import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    Integer updateUser(UserModel user, String passLama, String passKonfirm);
    UserModel getUserByUsername(String username);
    UserModel getUserByUuid(String uuid);
    List<UserModel> getUserList();
}
