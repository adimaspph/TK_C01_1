package tk.apap.sibusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.model.TypeModel;
import tk.apap.sibusiness.model.UserModel;
import tk.apap.sibusiness.repository.CouponDB;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CouponServiceImpl implements CouponService{
    @Autowired
    private CouponDB couponDB;

    @Autowired
    private CouponRestService couponRestService;

    @Autowired
    private UserService userService;

    @Override
    public List<CouponModel> getCouponList() {
        return couponDB.findAll();
    }

    @Override
    public void addCoupon(CouponModel coupon, String username) {
        String code = couponRestService.generateCouponCode(coupon);
        coupon.setCouponCode(code);
        UserModel user = userService.getUserByUsername(username);
        coupon.setCreator(user);

        if (user.getRole().getRole().equals("Staff_Marketing")) {
            coupon.setStatus(true);
        } else {
            coupon.setStatus(false);
        }
        couponDB.save(coupon);
    }

    @Override
    public List<CouponModel> getCouponCreationList() {
        return couponDB.listCouponCreation();
    }

    @Override
    public void acceptRequest(Long idCoupon) {
        Optional<CouponModel> couponModel = couponDB.findById(idCoupon);
        CouponModel coupon = couponModel.get();
        coupon.setStatus(true);
        couponDB.save(coupon);
    }

    @Override
    public void deleteCoupon(Long idCoupon) {
        couponDB.deleteById(idCoupon);
    }
}
