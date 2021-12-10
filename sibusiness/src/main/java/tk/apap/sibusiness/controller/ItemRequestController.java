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
import tk.apap.sibusiness.service.ItemRequestRestServiceImpl;
import tk.apap.sibusiness.service.TypeService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

@Controller
@RequestMapping("/item-request")
public class ItemRequestController {
    @Autowired
    private ItemRequestRestService itemRequestRestService;

    @GetMapping("/viewall")
    private String viewAllItemRequest(Model model){
        List<ItemRequestModel> listItemRequest = itemRequestRestService.getItemRequestFromStatus();
        model.addAttribute("listItemRequest", listItemRequest);
        // System.out.println(listItemRequest.toString());
        return "viewall-item-request-factory";
    }

    @GetMapping(value = "/accept-item/{uuid}")
    private String acceptItemRequest(Model model, @PathVariable("uuid")  String uuid){
        ItemRequestModel itemRequest = itemRequestRestService.findItemRequestModelByUuid(uuid);
        Mono result = itemRequestRestService.addItemToSIItem(itemRequest);
        itemRequestRestService.acceptItemRequestStatus1(itemRequest);
//        List<ItemRequestModel> listItemRequest = itemRequestRestService.getAllRequestItem();
//        model.addAttribute("listItemRequest", listItemRequest);
        System.out.println(result.block());
        return "success-add-item-request";
    }

    @GetMapping(value = "/reject-item/{uuid}")
    private String rejectItemRequest(@PathVariable("uuid") String uuid, Model model){
        ItemRequestModel itemRequest = itemRequestRestService.findItemRequestModelByUuid(uuid);
        itemRequestRestService.rejectItemRequestStatus2(itemRequest);
        return "fail-add-item-request";
    }
}


