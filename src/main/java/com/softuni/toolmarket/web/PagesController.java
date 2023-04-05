package com.softuni.toolmarket.web;

import com.softuni.toolmarket.model.enums.OrderedProductName;
import com.softuni.toolmarket.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
    private final OrderService orderService;

    public PagesController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {

            return "index";
        }
        model.addAttribute("totalOrders", orderService.getTotalOrders());

        model.addAttribute("Shovel",
                orderService.findOrdersEntityByProductName_AndProductName(OrderedProductName.SHOVEL));
        return "all";
    }

    @GetMapping("/pages/all")
    public String all() {
        return "all";
    }

    @GetMapping("/pages/admins")
    public String admins() {
        return "admins";
    }

    @GetMapping("/pages/users")
    public String users() {
        return "users";
    }

    @GetMapping("/pages/company")
    public String company() {
        return "company";
    }


}
