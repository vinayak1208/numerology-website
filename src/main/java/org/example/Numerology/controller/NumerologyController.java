package org.example.Numerology.controller;

import org.example.Numerology.model.NumerologyResult;
import org.example.Numerology.service.NumerologyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NumerologyController {

    private final NumerologyService numerologyService;

    public NumerologyController(NumerologyService numerologyService) {
        this.numerologyService = numerologyService;
    }

    @GetMapping("/")
    public String home() {

        return "numerology";
    }

    // Browser refresh or direct GET request to /calculate
    @GetMapping("/calculate")
    public String calculatePage() {
        return "redirect:/";
    }

    // Form submission
    @PostMapping("/calculate")
    public String calculate(
            @RequestParam String name,
            Model model) {

        NumerologyResult result =
                numerologyService.calculate(name);

        model.addAttribute("result", result);

        return "numerology";
    }

}
