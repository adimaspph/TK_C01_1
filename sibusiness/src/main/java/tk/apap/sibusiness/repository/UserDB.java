package tk.apap.sibusiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.apap.sibusiness.model.UserModel;

public interface UserDB extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}
