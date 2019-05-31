package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.shop.models.RoleModel;
import vn.edu.leading.shop.services.RoleService;

import javax.validation.Valid;

@Controller
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/admin/roles")
    public String roles(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "admin/pages/roles";
    }

    @PostMapping("admin/roles")
    public String save(@Valid RoleModel role, Model model) {
        roleService.save(role);
        model.addAttribute("roles", roleService.findAll());
        return "admin/pages/roles";
    }

    @GetMapping("/admin/roles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect, Model model) {
        if (roleService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted customer successfully!");
            model.addAttribute("roles", roleService.findAll());
            return "admin/pages/roles";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            model.addAttribute("roles", roleService.findAll());
            return "admin/pages/roles";
        }
    }
}