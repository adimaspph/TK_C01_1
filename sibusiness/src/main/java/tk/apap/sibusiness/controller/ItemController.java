package tk.apap.sibusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.apap.sibusiness.service.ItemRestService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRestService itemRestService;

    @GetMapping("/viewall")
    private String viewAllItem(Model model){
        List<List> listItem = new ArrayList<>();

        for (int i = 1; i < 15; i++) {
            List listPerKategori = itemRestService.getItemByKategori(i);
            if (listPerKategori.size() != 0) listItem.add(listPerKategori);
        }

        model.addAttribute("listAllItem", listItem);
        return "viewall-item";
    }

    @GetMapping("/{idItem}")
    private String detailItem(Model model, @PathVariable String idItem){

        model.addAttribute("item", itemRestService.getItemById(idItem));
        return "detail-item";
    }
}
