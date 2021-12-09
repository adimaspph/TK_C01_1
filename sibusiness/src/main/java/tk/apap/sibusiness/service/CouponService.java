package tk.apap.sibusiness.service;

import tk.apap.sibusiness.model.CouponModel;

import java.util.List;
import java.util.Optional;

public interface CouponService {
        List<CouponModel> getCouponList();
        void addCoupon(CouponModel coupon, String username);
        void updateCoupon(CouponModel coupon);
//        String generateCouponCode(CouponModel couponModel);
        List<CouponModel> getCouponCreationList();
        CouponModel getCouponById(Long id);
        void acceptRequest(Long idCoupon);
        void deleteCoupon(Long idCoupon);
}
