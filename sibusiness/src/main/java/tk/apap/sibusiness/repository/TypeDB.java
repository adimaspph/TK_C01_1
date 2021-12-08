package tk.apap.sibusiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.apap.sibusiness.model.TypeModel;

public interface TypeDB extends JpaRepository<TypeModel, Long> {
}
