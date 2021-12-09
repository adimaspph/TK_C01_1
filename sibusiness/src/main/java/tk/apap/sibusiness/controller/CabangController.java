package tk.apap.sibusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.apap.sibusiness.rest.CabangDTO;
import tk.apap.sibusiness.service.CabangRestService;

@Controller
@RequestMapping("/cabang")
public class CabangController {

    @Autowired
    private CabangRestService cabangRestService;

    @GetMapping("/create")
    private String addUserFormPage(Model model) {
        CabangDTO cabang = new CabangDTO();
        model.addAttribute("cabang", cabang);
        return "form-buka-cabang";
    }

    @PostMapping(value = "/create")
    private String addUserSubmit(@ModelAttribute CabangDTO cabang, Model model) {
//        System.out.println(cabang.getNamaCabang());
//        System.out.println(cabang.getAlamatCabang());
//        System.out.println(cabang.getNoTelpCabang());
//        System.out.println(cabang.getAlamatCabang());
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
