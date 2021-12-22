package tk.apap.sibusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.service.CouponService;
import tk.apap.sibusiness.service.TypeService;
import tk.apap.sibusiness.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private UserService userService;

    @GetMapping("/viewall")
    private String viewAllCoupon(Model model){
        List<CouponModel> listCoupon = couponService.getCouponList();
        model.addAttribute("listCoupon", listCoupon);
        return "viewall-coupon";
    }

    @GetMapping("/viewall-creation-request")
    private String viewAllCouponCreation(Model model){
        List<CouponModel> listCoupon = couponService.getCouponCreationList();
        model.addAttribute("listCoupon", listCoupon);
        return "viewall-coupon-creation-req";
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
            RedirectAttributes redir,
            @ModelAttribute CouponModel coupon,
            Principal principal
    ){
        couponService.addCoupon(coupon, principal.getName());
        redir.addFlashAttribute("title", "Coupon Berhasil Dibuat");
        redir.addFlashAttribute("message", "Berhasil menambah Coupon Baru dengan nama " + coupon.getCouponName());

        if (userService.getUserByUsername(principal.getName()).getRole().getRole().equals("Staff_Marketing")) {
            return "redirect:/coupon/viewall";
        } else {
            return "redirect:/coupon/viewall-creation-request";
        }
    }

    @GetMapping("/update/{id}")
    private String updateCouponForm(Model model, @PathVariable Long id){
        CouponModel coupon = couponService.getCouponById(id);

        model.addAttribute("listCouponType", typeService.getCouponList());
        model.addAttribute("coupon", coupon);
        return "form-update-coupon";
    }

    @PostMapping("/update")
    private String addCoupon(
            RedirectAttributes redir,
            @ModelAttribute CouponModel coupon
    ){
        couponService.updateCoupon(coupon);
        redir.addFlashAttribute("title", "Update Berhasil");
        redir.addFlashAttribute("message", "Berhasil mengubah Coupon dengan nama " + coupon.getCouponName());
        return "redirect:/coupon/viewall";
    }

    @GetMapping("/accept-request/{idCoupon}")
    private String acceptCouponRequest(@PathVariable Long idCoupon, Model model){
        couponService.acceptRequest(idCoupon);
        return "redirect:/coupon/viewall-creation-request";
    }

    @GetMapping("/delete/coupon-type/{idCoupon}")
    private String deleteTypeCouponRequest(
            @PathVariable Long idCoupon,
            Model model
    ){
        String coupon = couponService.getCouponById(idCoupon).getCouponName();
        couponService.deleteListType(idCoupon);
        return "redirect:/coupon/delete/{idCoupon}";
    }

    @GetMapping("/delete/{idCoupon}")
    private String deleteCouponRequest(@PathVariable Long idCoupon, Model model){
        couponService.deleteCoupon(idCoupon);
        return "redirect:/coupon/viewall";
    }
}
