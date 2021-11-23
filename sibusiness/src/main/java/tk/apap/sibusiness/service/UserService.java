package tk.apap.sibusiness.service;

import tk.apap.sibusiness.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
}
