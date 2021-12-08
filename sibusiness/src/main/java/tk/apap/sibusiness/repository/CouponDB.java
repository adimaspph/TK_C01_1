package tk.apap.sibusiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.apap.sibusiness.model.CouponModel;

public interface CouponDB extends JpaRepository<CouponModel, Long> {
}
