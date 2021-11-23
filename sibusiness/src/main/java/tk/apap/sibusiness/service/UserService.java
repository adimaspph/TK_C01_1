package tk.apap.sibusiness.service;

import tk.apap.sibusiness.model.UserModel;
import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);

    List<UserModel> getUserList();
}
