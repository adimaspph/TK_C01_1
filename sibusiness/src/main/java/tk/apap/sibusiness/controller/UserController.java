package tk.apap.sibusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tk.apap.sibusiness.model.RoleModel;
import tk.apap.sibusiness.model.UserModel;
import tk.apap.sibusiness.service.RoleService;
import tk.apap.sibusiness.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(RedirectAttributes redir, @ModelAttribute UserModel user, Model model) {

        userService.addUser(user);
        redir.addFlashAttribute("title", "User Berhasil Dibuat");
        redir.addFlashAttribute("message", "Berhasil menambah User Baru dengan username " + user.getUsername());

        return "redirect:/user/viewall";
    }

    @GetMapping("/viewall")
    private String viewAllUser(Model model){
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/update/{username}")
    private String formUpdateUser(
            Model model,
            @PathVariable String username
    ){
        UserModel user = userService.getUserByUsername(username);
        List<RoleModel> listRole = roleService.getListRole();

        user.setPassword("");

        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-update-user";
    }

    @GetMapping("/update/role/{username}")
    private String formUpdateRoleUser(
            Model model,
            @PathVariable String username
    ){
        UserModel user = userService.getUserByUsername(username);
        List<RoleModel> listRole = roleService.getListRole();

        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-update-role-user";
    }

    @PostMapping("/update")
    private String updateUser(
            Model model,
            RedirectAttributes redir,
            @RequestParam("passLama") String passLama,
            @RequestParam("passKonfirm") String passKonfirm,
            @ModelAttribute UserModel user
    ){
        UserModel userLama = userService.getUserByUuid(user.getUuid());
        List<RoleModel> listRole = roleService.getListRole();
        Integer result =  userService.updateUser(user, passLama, passKonfirm);

        model.addAttribute("listRole", listRole);
        if (result == -1){
            model.addAttribute("user", userLama);
            model.addAttribute("error", "Password Lama Salah");
            return "form-update-user";
        } else if (result == 0) {
            model.addAttribute("user", userLama);
            model.addAttribute("error", "Password Konfirmasi Salah");
            return "form-update-user";
        }

        redir.addFlashAttribute("title", "Berhasil Update User");
        redir.addFlashAttribute("message", "User dengan username " + user.getUsername() + " berhasil diupdate!!");
        return "redirect:/user/viewall";
    }

    @PostMapping("/update/role")
    private String updateRoleUser(
            Model model,
            RedirectAttributes redir,
            @ModelAttribute UserModel user
    ){
        userService.updateUserRole(user);

        redir.addFlashAttribute("title", "Berhasil Update Role User");
        redir.addFlashAttribute("message", "User dengan username " + user.getUsername() + " berhasil diupdate!!");
        return "redirect:/user/viewall";
    }
}
