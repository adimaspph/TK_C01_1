package tk.apap.sibusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.apap.sibusiness.service.MesinRestService;

@Controller
@RequestMapping("/mesin")
public class MesinController {

    @Autowired
    private MesinRestService mesinRestService;

    @GetMapping("/viewall")
    private String viewAllMesin(Model model) {
        model.addAttribute("listMesin", mesinRestService.getAllMesin());
        return "viewall-mesin";
    }
}
