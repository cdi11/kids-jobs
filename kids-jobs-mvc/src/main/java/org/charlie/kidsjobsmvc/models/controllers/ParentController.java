package org.charlie.kidsjobsmvc.models.controllers;


import org.charlie.kidsjobsmvc.models.data.Parent;
import org.charlie.kidsjobsmvc.models.data.ParentData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("parent")
public class ParentController {


    // Request path: /parent
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("parents", ParentData.getAll());
        model.addAttribute("title", "Parents");

        return "parent/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddParentForm(Model model) {
        model.addAttribute("title", "Add Parent");
        model.addAttribute(new Parent());

        return "parent/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddParentForm(@ModelAttribute @Valid Parent newParent,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Parent");
            return "parent/add";

        }
            ParentData.add(newParent);
            return "redirect:";
        }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveParentForm(Model model) {
        model.addAttribute("parents", ParentData.getAll());
        model.addAttribute("title", "Remove Parent");
        return "parent/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveParentForm(@RequestParam int[] parentIds) {

        for (int parentId : parentIds) {
            ParentData.remove(parentId);
        }

        return "redirect:";
    }
}



