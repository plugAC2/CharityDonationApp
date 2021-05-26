package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.models.DonationModel;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @ModelAttribute("allCategories")
    public Collection<Category> allCategories(){
        return this.categoryService.getAll();
    }

    @ModelAttribute("institutions")
    public Collection<Institution> allInstitutions(){
        return this.institutionService.getAll();
    }

    @GetMapping("/donate")
    public ModelAndView getDonationForm() {
        ModelAndView donationForm = new ModelAndView("form");
        donationForm.addObject("donation", new Donation());
//        donationForm.addObject("allCategories", categoryService.getAll());
//        donationForm.addObject("institutions", institutionService.getAll());
        return donationForm;
    }

    @PostMapping("/donate")
    public String postDonationForm(@Valid @ModelAttribute("donation") Donation donation,
                                   BindingResult result) {
        if(result.hasErrors()) {
            return "form";
        }

        donationService.newRecordDirect(donation);

        return "formConfirmation";
    }
}
