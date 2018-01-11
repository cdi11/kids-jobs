package org.charlie.kidsjobsmvc.models.controllers;


import org.charlie.kidsjobsmvc.models.data.Reward;
import org.charlie.kidsjobsmvc.models.data.RewardData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("reward")
public class RewardController {


    // Request path: /reward
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("rewards", RewardData.getAll());
        model.addAttribute("title", "Rewards");

        return "reward/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddRewardForm(Model model) {
        model.addAttribute("title", "Add Reward");
        model.addAttribute(new Reward());

        return "reward/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddRewardForm(@ModelAttribute @Valid Reward newReward,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Reward");
            return "reward/add";

        }
        RewardData.add(newReward);
        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveRewardForm(Model model) {
        model.addAttribute("rewards", RewardData.getAll());
        model.addAttribute("title", "Remove Reward");
        return "reward/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveRewardForm(@RequestParam int[] rewardIds) {

        for (int rewardId : rewardIds) {
            RewardData.remove(rewardId);
        }

        return "redirect:";
    }
}





