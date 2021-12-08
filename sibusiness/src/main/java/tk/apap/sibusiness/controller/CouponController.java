package tk.apap.sibusiness.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.model.UserModel;
import tk.apap.sibusiness.service.CouponService;
import tk.apap.sibusiness.service.TypeService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util. ArrayList;
import java.util.List;
import java.time.LocalTime;

@Controller
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/viewall")
    private String viewAllCoupon(Model model){
        List<CouponModel> listCoupon = couponService.getCouponList();
        model.addAttribute("listCoupon", listCoupon);
        return "viewall-coupon";
    }

    @GetMapping("/add")
    private String addCouponForm(Model model){
        CouponModel coupon = new CouponModel();
        model.addAttribute("listCouponType", typeService.getCouponList());
        model.addAttribute("coupon", coupon);
        return "coupon-add-form";
    }

    @PostMapping("/add")
    private String addCoupon(
            Model model,
            @ModelAttribute CouponModel coupon,
            Authentication auth,
            Principal principal
    ){
        couponService.addCoupon(coupon, principal.getName());
        model.addAttribute("pesan", "Berhasil menambah Coupon Baru dengan nama " + coupon.getCouponName());
        return "message";
    }
}
