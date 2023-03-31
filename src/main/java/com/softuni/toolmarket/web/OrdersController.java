package com.softuni.toolmarket.web;

import com.softuni.toolmarket.model.dto.OrdersDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/pages/all")
public class OrdersController {

    @GetMapping("/add")
    public String add(Model model){
        if (!model.containsAttribute("ordersDTO")){
            model.addAttribute("ordersDTO", new OrdersDTO());
        }


        return "/all";
    }

    @PostMapping("/add")
    public String addConfirm(OrdersDTO ordersDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("ordersDTO", ordersDTO);
            redirectAttributes.addFlashAttribute(ordersDTO);
            return "redirect:add";
        }
        return "redirect:/";
    }



}
