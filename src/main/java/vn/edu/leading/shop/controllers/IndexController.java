package vn.edu.leading.shop.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sun.plugin.liveconnect.SecurityContextHelper;
import vn.edu.leading.shop.services.ProductService;

@Controller
public class IndexController {

    private final ProductService productService;

    public IndexController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String home( ) {
        return "viewer/index";
    }

    @GetMapping("/blogdetail")
    public String blogDetail() {
        return "viewer/blog-details";
    }

    @GetMapping("/about")
    public String about() {
        return "viewer/about";
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
    public String menu(Model model) {
        model.addAttribute("products", productService.findAll());
        return "viewer/menu";
    }

    @GetMapping("/productDetail/{id}/show")
    public String detail(@PathVariable("id") Long id,Model model) {
        model.addAttribute("productModel",productService.findById(id));
        return "viewer/productDetail";
    }

}
