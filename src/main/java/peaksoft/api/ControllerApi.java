package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.service.CompanyService;

@Controller
@RequestMapping("/companies")
public class ControllerApi {
    private final CompanyService service;
    @Autowired
    public ControllerApi(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllCompanies(Model model){
        model.addAttribute("companies",service.getAllCompanies());
        return "mainPage";
    }
    @GetMapping("/new")
    public String createCompany(Model model){
        model.addAttribute("newCompany",new Company());
        return "newCompany";
    }
    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newCompany")Company company){
        service.save(company);
        return "redirect:/companies";
    }
    @DeleteMapping("{companyId}/delete")
    public String deleteCompany(@PathVariable("companyId")Long id){
        service.deleteCompany(id);
        return "redirect:/companies";
    }

    @GetMapping("/getCompany")
    public String getCompany(Model model){
        model.addAttribute("updateCompany",new Company());
        return "update";
    }
    @PutMapping("{companyId}/update")
    public String updateCompany(@PathVariable Long companyId, @ModelAttribute("newCompany")Company newCompany){
        service.updateCompany(companyId,newCompany);
        return "redirect:/companies";
    }
//    @RequestMapping(value="/companies/{id}", method = RequestMethod.PUT)
//    public String getUser(@PathVariable Long id, @RequestBody Company company) {
//        service.updateCompany(id, company);
//        return "redirect:/companies";
//    }
}
