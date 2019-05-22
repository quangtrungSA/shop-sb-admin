package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.shop.models.EmployeeModel;
import vn.edu.leading.shop.services.EmployeeService;

import javax.validation.Valid;

@Controller
public class IndexController {
    @GetMapping("/home")
    public String home() {
        return "viewer/index";
    }

    @GetMapping("/blogdetail")
    public String blogDetail() {
        return "viewer/blog-details";
    }

    @GetMapping("/bloghome")
    public String blogHome() {
        return "viewer/blog-home";
    }

    @GetMapping("/contact")
    public String contact() {
        return "viewer/contact-us";
    }

    @GetMapping("/element")
    public String element() {
        return "viewer/elements";
    }

    @GetMapping("/menu")
    public String menu() {
        return "viewer/menu";
    }

}
