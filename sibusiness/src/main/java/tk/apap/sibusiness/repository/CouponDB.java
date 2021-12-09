package tk.apap.sibusiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tk.apap.sibusiness.model.CouponModel;

import java.util.List;
import java.util.Optional;

public interface CouponDB extends JpaRepository<CouponModel, Long> {
    @Query("select e from CouponModel e where e.status = false")
    List<CouponModel> listCouponCreation();
    Optional<CouponModel> findById(Long id);
}
