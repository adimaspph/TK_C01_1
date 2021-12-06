package tk.apap.sibusiness.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.model.UserModel;
import tk.apap.sibusiness.service.CouponService;

import javax.servlet.http.HttpServletRequest;
import java.util. ArrayList;
import java.util.List;
import java.time.LocalTime;

@Controller
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/viewall")
    private String viewAllCoupon(Model model){
        List<CouponModel> listCoupon = couponService.getCouponList();
        model.addAttribute("listCoupon", listCoupon);
        return "viewall-coupon";
    }
}
