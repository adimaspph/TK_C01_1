package tk.apap.sibusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.model.RoleModel;
import tk.apap.sibusiness.model.UserModel;
import tk.apap.sibusiness.rest.CabangDetail;
import tk.apap.sibusiness.service.CabangRestService;

import javax.servlet.http.HttpServletRequest;
import java.util. ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalTime;
import java.util.Map;

@Controller
@RequestMapping("/cabang")
public class CabangController {

    @Autowired
    private CabangRestService cabangRestService;

    @GetMapping("/create")
    private String addUserFormPage(Model model) {
        CabangDetail cabang = new CabangDetail();
        model.addAttribute("cabang", cabang);
        return "form-buka-cabang";
    }

    @PostMapping(value = "/create")
    private String addUserSubmit(@ModelAttribute CabangDetail cabang, Model model) {
        System.out.println(cabang.getNamaCabang());
        System.out.println(cabang.getAlamatCabang());
        System.out.println(cabang.getNoTelpCabang());
        System.out.println(cabang.getAlamatCabang());
        cabangRestService.permintaanCabang(cabang);
        return "confirm-buka-cabang";
    }

//    @PostMapping(value = "/create")
//    private String coba(@RequestParam CabangDetail cabang){
//        // request url
//        String url = "https://si-retail-c01.herokuapp.com/api/cabang/create";
//
//        // create an instance of RestTemplate
//        RestTemplate restTemplate = new RestTemplate();
//
//        // request body parameters
//        Map<String, String> map = new HashMap<>();
//        map.put("name", cabang.getNama());
//        map.put("alamat", cabang.getAlamat());
//        map.put("no_telp", cabang.getNotelp());
//        map.put("ukuran", cabang.getUkuran().toString());
//
//        // send POST request
//        ResponseEntity<Void> response = restTemplate.postForEntity(url, map.toString(), Void.class);
//        if (response.getStatusCode() == HttpStatus.OK) {
//            System.out.println("Request Successful");
//        } else {
//            System.out.println("Request Failed");
//        }
//        return "confirm-buka-cabang";
//    }

}
