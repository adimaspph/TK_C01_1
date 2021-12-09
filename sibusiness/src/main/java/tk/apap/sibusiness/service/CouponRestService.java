package tk.apap.sibusiness.service;

import tk.apap.sibusiness.model.CouponModel;

import java.util.List;
import java.util.Set;

public interface CouponRestService {
    List<CouponModel> retrieveListCoupon();
    CouponModel getCouponByIdCoupon(Long id);
    Set<String> getDayOfWeek(CouponModel coupon);
    String generateCouponCode(CouponModel coupon);
}
