package tk.apap.sibusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.apap.sibusiness.model.ItemRequestModel;
import tk.apap.sibusiness.service.ItemRequestRestService;

import java.util.List;

@Controller
@RequestMapping("/item-request")
public class ItemRequestController {

    @Autowired
    private ItemRequestRestService itemRequestRestService;

    @GetMapping("/viewall")
    private String viewAllItemRequest(Model model){
//        System.out.println("halooo");
        List<ItemRequestModel> listItemRequest = itemRequestRestService.getAllRequestItem();
        model.addAttribute("listItemRequest", listItemRequest);
//        System.out.println(listItemRequest.toString());
        return "viewall-item-request-factory";
    }

}


