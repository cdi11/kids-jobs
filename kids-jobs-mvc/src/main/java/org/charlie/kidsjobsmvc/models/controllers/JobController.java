package org.charlie.kidsjobsmvc.models.controllers;

import org.charlie.kidsjobsmvc.models.data.Job;
import org.charlie.kidsjobsmvc.models.data.JobData;
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
@RequestMapping("job")
public class JobController {


        // Request path: /parent
        @RequestMapping(value = "")
        public String index(Model model) {

            model.addAttribute("jobs", JobData.getAll());
            model.addAttribute("title", "Jobs");

            return "job/index";
        }

        @RequestMapping(value = "add", method = RequestMethod.GET)
        public String displayAddJobForm(Model model) {
            model.addAttribute("title", "Add Job");
            model.addAttribute(new Job());

            return "job/add";
        }

        @RequestMapping(value = "add", method = RequestMethod.POST)
        public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                           Errors errors, Model model) {

            if (errors.hasErrors()) {
                model.addAttribute("title", "Add Job");
                return "job/add";

            }
            JobData.add(newJob);
            return "redirect:";
        }


        @RequestMapping(value = "remove", method = RequestMethod.GET)
        public String displayRemoveJobForm(Model model) {
            model.addAttribute("jobs", JobData.getAll());
            model.addAttribute("title", "Remove Job");
            return "job/remove";
        }

        @RequestMapping(value = "remove", method = RequestMethod.POST)
        public String processRemoveJobForm(@RequestParam int[] jobIds) {

            for (int jobId : jobIds) {
                JobData.remove(jobId);
            }

            return "redirect:";
        }
    }







