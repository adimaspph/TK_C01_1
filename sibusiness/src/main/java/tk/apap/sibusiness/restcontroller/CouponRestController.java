package tk.apap.sibusiness.restcontroller;

import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.repository.CouponDB;
import tk.apap.sibusiness.service.CouponRestService;
import tk.apap.sibusiness.rest.BaseResponseT;
import tk.apap.sibusiness.service.CouponRestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;
import java.time.DayOfWeek;

@RestController
@RequestMapping("/api")
public class CouponRestController {

    @Autowired
    private CouponDB couponDB;

    @Autowired
    private CouponRestService couponRestService;

    @GetMapping(value = "/list-coupon")
    private BaseResponseT<List<HashMap>> retrieveListCoupon() {
        List<CouponModel> listCoupon = couponRestService.retrieveListCoupon();
        LocalDate now = LocalDate.now();
        List<CouponModel> listCouponThisDay = new ArrayList<>();

        BaseResponseT<List<HashMap>> response = new BaseResponseT<>();
        for (CouponModel coupon : listCoupon) {
            Set<String> listUseDay = couponRestService.getDayOfWeek(coupon);
            String couponCode = couponRestService.generateCouponCode(coupon);
            coupon.setCouponCode(couponCode);
            couponDB.save(coupon);
//            System.out.println(coupon.getCouponName());
            for (String useDay : listUseDay) {
//                System.out.println(useDay.toLowerCase());
//                System.out.println(now.getDayOfWeek().toString().toLowerCase());
                if (useDay.toLowerCase().equals(now.getDayOfWeek().toString().toLowerCase())) {
                    listCouponThisDay.add(coupon);
                }
            }
        }

//        for (CouponModel coupon : listCouponThisDay) {
//            System.out.println(coupon.getId());
//        }

        List<HashMap> listCouponShow = new ArrayList<>();
        for (CouponModel coupon : listCouponThisDay) {
            HashMap<String, Object> detail = new HashMap<>();
            detail.put("ID Coupon", coupon.getId());
            detail.put("Coupon Code", coupon.getCouponCode());
            detail.put("Coupon Name", coupon.getCouponName());
            detail.put("Discount Amount", coupon.getDiscountAmount());
            detail.put("Expiry Date", coupon.getExpiryDate());
            listCouponShow.add(detail);
        }

        response.setStatus(200);
        response.setMessage("success");
        response.setResult(listCouponShow);

        return response;
    }
}
