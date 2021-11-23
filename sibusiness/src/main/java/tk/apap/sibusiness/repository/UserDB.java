package tk.apap.sibusiness.repository;

import tk.apap.sibusiness.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDB extends JpaRepository<UserModel, Long> {
}