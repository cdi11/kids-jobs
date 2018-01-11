package org.charlie.kidsjobsmvc.models.controllers;

import org.charlie.kidsjobsmvc.models.data.Child;
import org.charlie.kidsjobsmvc.models.data.ChildData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
@Controller
@RequestMapping("child")
public class ChildController {

    // Request path: /child
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("children", ChildData.getAll());
        model.addAttribute("title", "Children");

        return "child/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddChildForm(Model model) {
        model.addAttribute("title", "Add Child");
        model.addAttribute(new Child());

        return "child/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddChildForm(@ModelAttribute @Valid Child newChild,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Child");
            return "child/add";

        }
        ChildData.add(newChild);
        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveChildForm(Model model) {
        model.addAttribute("children", ChildData.getAll());
        model.addAttribute("title", "Remove Child");
        return "child/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveChildForm(@RequestParam int[] childIds) {

        for (int childId : childIds) {
            ChildData.remove(childId);
        }

        return "redirect:";
    }
}





