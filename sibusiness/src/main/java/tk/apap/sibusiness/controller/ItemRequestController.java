package tk.apap.sibusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.model.ItemRequestModel;
import tk.apap.sibusiness.model.UserModel;
import tk.apap.sibusiness.service.CouponService;
import tk.apap.sibusiness.service.ItemRequestRestService;
import tk.apap.sibusiness.service.TypeService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util. ArrayList;
import java.util.List;
import java.time.LocalTime;

@Controller
@RequestMapping("/item-request")
public class ItemRequestController {
    @Autowired
    private ItemRequestRestService itemRequestRestService;

    @GetMapping("/viewall")
    private String viewAllItemRequest(Model model){
        //System.out.println("halooo");
        List<ItemRequestModel> listItemRequest = itemRequestRestService.getAllRequestItem();
        model.addAttribute("listItemRequest", listItemRequest);
        //System.out.println(listItemRequest.toString());
        return "viewall-item-request-factory";
    }

    @GetMapping(value = "/accept-item/{uuid}")
    private String acceptItemRequest(Model model, @PathVariable String uuid){
        ItemRequestModel itemRequest = itemRequestRestService.findItemRequestModelByUuid(uuid);
        Mono result = itemRequestRestService.addItemToSIItem(itemRequest);
        System.out.println(result.block());
        return "home";
    }
}


