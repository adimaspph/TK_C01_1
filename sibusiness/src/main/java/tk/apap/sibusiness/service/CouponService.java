package tk.apap.sibusiness.service;

import tk.apap.sibusiness.model.CouponModel;

import java.util.List;

public interface CouponService {
        List<CouponModel> getCouponList();
        void addCoupon(CouponModel coupon, String username);
        String generateCouponCode(CouponModel couponModel);
}
