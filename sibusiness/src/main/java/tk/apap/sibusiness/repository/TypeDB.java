package tk.apap.sibusiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tk.apap.sibusiness.model.TypeModel;

import java.util.Optional;

public interface TypeDB extends JpaRepository<TypeModel, Long> {
    Optional<TypeModel> findById(Long id);
}
