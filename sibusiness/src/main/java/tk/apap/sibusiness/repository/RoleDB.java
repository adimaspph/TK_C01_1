package tk.apap.sibusiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.apap.sibusiness.model.RoleModel;

public interface RoleDB extends JpaRepository<RoleModel, Long> {
}
