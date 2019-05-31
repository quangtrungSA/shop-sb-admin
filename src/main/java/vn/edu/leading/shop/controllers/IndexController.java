package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.leading.shop.configs.IAuthenticationFacade;
import vn.edu.leading.shop.models.UserModel;
import vn.edu.leading.shop.services.ProductService;
import vn.edu.leading.shop.services.UserService;

@Controller
public class IndexController {

    private final ProductService productService;

    private final UserService userService;

    private final IAuthenticationFacade authentication;

    public IndexController(ProductService productService, UserService userService, IAuthenticationFacade authentication) {
        this.productService = productService;
        this.userService = userService;
        this.authentication = authentication;
    }


    @GetMapping("/")
    public String home(Model model) {
        UserModel userModel = userService.findByUsername(authentication.getAuthentication().getName()).orElse(new UserModel());
        model.addAttribute("userModel", userModel);
        return "viewer/index";
    }

    @GetMapping("/blogdetail")
    public String blogDetail(Model model) {

        UserModel userModel = userService.findByUsername(authentication.getAuthentication().getName()).orElse(new UserModel());
        model.addAttribute("userModel", userModel);
        return "viewer/blog-details";
    }

    @GetMapping("/about")
    public String about(Model model) {
        UserModel userModel = userService.findByUsername(authentication.getAuthentication().getName()).orElse(new UserModel());
        model.addAttribute("userModel", userModel);
        return "viewer/blog-details";

    }

    @GetMapping("/bloghome")
    public String blogHome(Model model) {
        UserModel userModel = userService.findByUsername(authentication.getAuthentication().getName()).orElse(new UserModel());
        model.addAttribute("userModel", userModel);
        return "viewer/blog-home";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        UserModel userModel = userService.findByUsername(authentication.getAuthentication().getName()).orElse(new UserModel());
        model.addAttribute("userModel", userModel);
        return "viewer/contact-us";
    }

    @GetMapping("/element")
    public String element(Model model) {
        UserModel userModel = userService.findByUsername(authentication.getAuthentication().getName()).orElse(new UserModel());
        model.addAttribute("userModel", userModel);
        return "viewer/elements";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        UserModel userModel = userService.findByUsername(authentication.getAuthentication().getName()).orElse(new UserModel());
        model.addAttribute("userModel", userModel);
        model.addAttribute("products", productService.findAll());
        return "viewer/menu";
    }

    @GetMapping("/productDetail/{id}/show")
    public String detail(@PathVariable("id") Long id, Model model) {
        UserModel userModel = userService.findByUsername(authentication.getAuthentication().getName()).orElse(new UserModel());
        model.addAttribute("userModel", userModel);
        model.addAttribute("productModel", productService.findById(id));
        return "viewer/productDetail";
    }

    @GetMapping("/cart")
    public String cart() {
        return "viewer/cart";
    }

}
