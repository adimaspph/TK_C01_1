package tk.apap.sibusiness.service;

import tk.apap.sibusiness.model.UserModel;
import tk.apap.sibusiness.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDB;

    @Override
    public List<UserModel> getUserList() {
        return userDB.findAll();
    }
}
