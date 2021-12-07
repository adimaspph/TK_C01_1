package tk.apap.sibusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.repository.CouponDB;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CouponServiceImpl implements CouponService{
    @Autowired
    private CouponDB couponDB;

    @Autowired
    private UserService userService;

    @Override
    public List<CouponModel> getCouponList() {
        return couponDB.findAll();
    }

    @Override
    public void addCoupon(CouponModel coupon, String username) {
        String code = generateCouponCode(coupon);
        coupon.setCouponCode(code);
        System.out.println(userService.getUserByUsername(username));
        coupon.setCreator(userService.getUserByUsername(username));
        coupon.setStatus(0);
        couponDB.save(coupon);
    }

    @Override
    public String generateCouponCode(CouponModel couponModel) {
        //Belum diimplement
        return "dummycode";
    }
}
