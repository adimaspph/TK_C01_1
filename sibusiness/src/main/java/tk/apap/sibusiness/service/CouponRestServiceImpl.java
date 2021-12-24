package tk.apap.sibusiness.service;

import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.model.TypeModel;
import tk.apap.sibusiness.repository.CouponDB;
import tk.apap.sibusiness.repository.TypeDB;
import tk.apap.sibusiness.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.*;

@Service
@Transactional
public class CouponRestServiceImpl implements CouponRestService {

    @Autowired
    private CouponDB couponDB;

    @Autowired
    private TypeRestService typeRestService;

    @Override
    public List<CouponModel> retrieveListCoupon() {
        return couponDB.findAll();
    }

    @Override
    public CouponModel getCouponByIdCoupon(Long id) {
        Optional<CouponModel> coupon = couponDB.findById(id);
        if (coupon.isPresent()) {
            return coupon.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Set<String> getDayOfWeek(CouponModel coupon) {
        Set<TypeModel> listType = coupon.getListType();
        Set<String> dayOfWeeks = new HashSet<>();
        if (!listType.isEmpty()) {
            for (TypeModel type : listType) {
                dayOfWeeks.add(type.getUseDay());
            }
        }
//        DayOfWeek dayOfWeek = coupon.getExpiryDate().getDayOfWeek();
//        String hari = dayOfWeek.toString();
        return dayOfWeeks;
    }

    @Override
    public String generateCouponCode(CouponModel coupon) {
        String couponCode = "DISC";

        float disc = coupon.getDiscountAmount();
        double discfloor = Math.floor(disc);
        String discstr = String.valueOf(Math.round(discfloor));
//        String[] discstrsplit = discstrs.split(".");
//        String discstr = discstrsplit[0] + discstrsplit[1];

        String disccoupon = "";
        if (discstr.length() == 1) {
            disccoupon += "00" + discstr;
        } else if (discstr.length() == 2) {
            disccoupon += "0" + discstr;
        } else {
            disccoupon += discstr;
        }
        couponCode += disccoupon;

        Set<TypeModel> listType = coupon.getListType();
        List<Long> listTypeId = new ArrayList<>();
        if (!listType.isEmpty()) {
            for (TypeModel type : listType) {
                listTypeId.add(type.getId());
            }
        }
        Long min = Collections.min(listTypeId);
        TypeModel type = typeRestService.getTypeByIdType(min);
        String dayName = type.getUseDay().substring(0,3).toUpperCase();
        couponCode += dayName;

        String[] dates = coupon.getExpiryDate().toString().split("-");
        String date = dates[2] + dates[1] + dates[0].substring(2,4);
        couponCode += date;

        return couponCode;
    }
}
