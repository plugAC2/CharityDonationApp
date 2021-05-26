package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

        @RequestMapping("/")
    public ModelAndView homeAction(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("charities", institutionService.getAllModel());
        modelAndView.addObject("sacks", donationService.addAllSacks());
        modelAndView.addObject("donations", donationService.addAllDonations());
        return modelAndView;
    }

}
