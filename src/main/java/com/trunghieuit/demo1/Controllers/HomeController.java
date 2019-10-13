package com.trunghieuit.demo1.Controllers;

import com.trunghieuit.demo1.Entity.Contact;
import com.trunghieuit.demo1.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class HomeController {
    @Autowired
    private ContactService contactService;
    @GetMapping("/")
    public String index(Model model){
        Iterable<Contact> cts = contactService.FindAll();
        model.addAttribute("contacts" , cts);
        return "Client/list";
    }
    @GetMapping("contact/search")
    public String search(@RequestParam("term") String term , Model model){
        if (StringUtils.isEmpty(term)) {
            return "redirect:/";
        }
            model.addAttribute("contacts", contactService.search(term));
            return "Client/list";
}
    @GetMapping("/contact/add")
    public String add(Model model) {
        model.addAttribute("contact", new Contact());
        return "Client/form";
    }
    @PostMapping("/contact/save")
    public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        contactService.Save(contact);
        redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
        return "redirect:/contact";
    }
    @GetMapping("/contact/{id}/delete")
    public String delete(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("contact",contactService.FindOne(id).get());
        return "Client/contact";
    }
    @GetMapping("contact")
    public String contact(){
        return "redirect:/";
    }
}
