package com.netcracker.etalon.controllers;


import com.netcracker.devschool.dev4.etalon.entity.Client;
import com.netcracker.devschool.dev4.etalon.entity.Coach;
import com.netcracker.devschool.dev4.etalon.entity.Subscription;
import com.netcracker.devschool.dev4.etalon.service.CoachService;
import com.netcracker.devschool.dev4.etalon.service.GymService;
import com.netcracker.devschool.dev4.etalon.service.UserService;
import com.netcracker.devschool.dev4.etalon.utils.ColculationConverter;
import com.netcracker.devschool.dev4.etalon.utils.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/coachs")
public class CoachController {
    @Autowired
    CoachService coachService;
    @Autowired
    UserService userService;
    @Autowired
    GymService gymService;

    @RequestMapping(value = "/edit/{idCoach}", method = RequestMethod.POST)
    @ResponseBody
    public Coach editCoach(@PathVariable String idCoach,
                              @RequestParam(value = "first_name", required = false) String first_name,
                              @RequestParam(value = "last_name", required = false) String last_name

    ) {
        String msg = "";
        Coach coach = coachService.findById(Integer.parseInt(idCoach));
        try {
            if (!Objects.equals(first_name, "") && first_name != null) coach.setFirst_name(first_name);
            if (!Objects.equals(last_name, "") && last_name != null) coach.setLast_name(last_name);
            coachService.update(coach);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return coach;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Coach getClient(@PathVariable int id) {
        return coachService.findById(id);
    }

    @RequestMapping(value = "/tableSubscriptions", method = RequestMethod.GET)
    @ResponseBody
    private TableData returnTable(
            @RequestParam(value = "start") String start,
            @RequestParam(value = "length") String length,
            @RequestParam(value = "draw") String draw,
            @RequestParam(value = "search[value]", required = false) String key,
            @RequestParam(value = "order[0][column]") String order,
            @RequestParam(value = "order[0][dir]") String orderDir) {
        if (key==null) key="";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uname = auth.getName();
        int id = userService.getIdByName(uname);
        TableData result = new TableData();
        List<Subscription> list = coachService.findSubscriptionByIdCoach(id);
        result.setDraw(Integer.parseInt(draw));
        ColculationConverter converter = new ColculationConverter();
        for (Subscription item: list
                ) {
            result.addData(converter.calculationToArray(item,gymService));
        }
        return result;
    }

}
