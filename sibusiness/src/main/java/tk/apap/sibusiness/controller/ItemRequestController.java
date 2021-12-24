package tk.apap.sibusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import reactor.core.publisher.Mono;
import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.model.ItemRequestModel;
import tk.apap.sibusiness.service.ItemRequestRestService;
import tk.apap.sibusiness.service.ItemRequestRestServiceImpl;
import tk.apap.sibusiness.service.TypeService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
    private String acceptItemRequest(RedirectAttributes redir, Model model, @PathVariable("uuid")  String uuid, Principal principal) throws Exception {
        ItemRequestModel itemRequest = itemRequestRestService.findItemRequestModelByUuid(uuid);
        itemRequestRestService.addItemToSIItem(itemRequest);
        itemRequestRestService.acceptItemRequestStatus1(itemRequest, principal.getName());
        model.addAttribute("itemRequest", itemRequest);
//        //System.out.println(result.block());
//        redir.addFlashAttribute("title", "Item Accepted");
//        redir.addFlashAttribute("message", "Pembuatan item ' + ${itemRequest.nama} + ' berhasil");
//        return "redirect:/item-request-viewall";
        return "success-add-item-request";
    }

    @GetMapping(value = "/reject-item/{uuid}")
    private String rejectItemRequest(@PathVariable("uuid") String uuid, Model model){
        ItemRequestModel itemRequest = itemRequestRestService.findItemRequestModelByUuid(uuid);
        itemRequestRestService.rejectItemRequestStatus2(itemRequest);
        model.addAttribute("itemRequest", itemRequest);
        return "fail-add-item-request";
    }
}


