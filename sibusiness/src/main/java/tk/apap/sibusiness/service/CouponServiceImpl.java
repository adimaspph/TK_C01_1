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

    @Override
    public List<CouponModel> getCouponList() {
        return couponDB.findAll();
    }
}
