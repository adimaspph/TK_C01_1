//package tk.apap.sibusiness.restcontroller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//import reactor.core.publisher.Mono;
//import tk.apap.sibusiness.rest.CabangDetail;
//import tk.apap.sibusiness.service.CabangRestService;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//
//@RestController
//@RequestMapping("/api/v1")
//public class CabangRestController {
//
//    @Autowired
//    CabangRestService cabangRestService;
//
//    @GetMapping(value = "/cabang")
//    private Mono<String> permintaanCabang(@ModelAttribute CabangDetail cabang){
//        return cabangRestService.permintaanCabang(cabang);
//    }
//}
