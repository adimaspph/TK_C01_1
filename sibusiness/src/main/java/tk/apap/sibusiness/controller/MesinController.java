package tk.apap.sibusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.apap.sibusiness.service.MesinRestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/view/kategori/{idKategori}")
    private String viewMesinByKategori(@PathVariable Integer idKategori, Model model) {
        List<Map<String, Object>> data = new ArrayList<>(mesinRestService.getAllMesin());
        List<Map<String, Object>> newdata = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).get("idKategori").equals(idKategori)) {
                newdata.add(data.get(i));
            }
        }

        model.addAttribute("listMesin", newdata);
        return "viewall-mesin";
    }
}
