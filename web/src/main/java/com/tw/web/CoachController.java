package com.tw.web;

import com.tw.core.Coach;
import com.tw.core.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by chenbojian on 15-6-23.
 */
@RestController
@RequestMapping("/coach")
public class CoachController {
    private CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService){
        this.coachService = coachService;
    }

    @RequestMapping("/")
    public ModelAndView listOfCoach(){
        ModelAndView modelAndView = new ModelAndView("coachList");
        List<Coach> coachs = coachService.listCoach();
        modelAndView.addObject("coachs", coachs);

        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addCoachPage(){
        ModelAndView modelAndView = new ModelAndView("addCoach");
        modelAndView.addObject("coach",new Coach());
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addCoach(@ModelAttribute Coach coach){
        coachService.addCoach(coach);
        return new ModelAndView("redirect:/coach/");
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.GET)
    public ModelAndView editCoachPage(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView("coachEdit");
        Coach coach = coachService.findCoachById(id);
        modelAndView.addObject("coach", coach);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.POST)
    public ModelAndView editCoach(@PathVariable("id") long id,
                                     @ModelAttribute Coach coach){
        coachService.updateCoach(coach);
        return new ModelAndView("redirect:/coach/");
    }

    @RequestMapping("/{id}/delete")
    public ModelAndView deleteCoach(@PathVariable("id") long id){
        coachService.deleteCoach(id);
        return new ModelAndView("redirect:/coach/");
    }
}
