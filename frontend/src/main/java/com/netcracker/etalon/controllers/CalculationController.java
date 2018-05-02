package com.netcracker.etalon.controllers;


import com.netcracker.devschool.dev4.etalon.entity.Calculation;
import com.netcracker.devschool.dev4.etalon.entity.Subscription;
import com.netcracker.devschool.dev4.etalon.service.CalculationService;
import com.netcracker.devschool.dev4.etalon.service.GymService;
import com.netcracker.devschool.dev4.etalon.service.SubscriptionService;
import com.netcracker.devschool.dev4.etalon.service.UserService;
import com.netcracker.devschool.dev4.etalon.utils.ColculationConverter;
import com.netcracker.devschool.dev4.etalon.utils.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/calculation")
public class CalculationController {
    @Autowired
    UserService userService;
    @Autowired
    CalculationService calculationService;
    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    GymService gymService;

    @RequestMapping(value = "/addCalculation/{idSubscription}", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAnyAuthority( 'ROLE_CLIENT')")
    private Calculation addCalculation(@PathVariable(value = "idSubscription") int idSubscription
    ) {
        //todo validation
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uname = auth.getName();
        int id = userService.getIdByName(uname);
        List<Calculation> list = calculationService.findByIdClient(id);
        Calculation calculation = new Calculation();
        for (Calculation item : list) {
            if (item.getIdSubscription() == idSubscription) return null;
        }
        calculation.setIdClient(id);
        calculation.setIdSubscription(idSubscription);
        return calculationService.create(calculation);
    }

    @RequestMapping(value = "/deleteCalculation/{id}", method = RequestMethod.POST)
    private String deleteCalculation(@PathVariable(value = "id") int id
    ) {
        calculationService.deleteCalculationById(id);


        return "redirect:/student";
    }

    @RequestMapping(value = "/deleteCalculation1/{idClient}/{idSubscription}")
    private String deleteCalculation1(@PathVariable(value = "idClient") int idClient,
                                      @PathVariable(value = "idSubscription") int idSubscription
    ) {
        calculationService.findCalculationByIdClientAndIdSubscription(idClient,idSubscription);


        return "redirect:/client";
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
        List<Subscription> list = subscriptionService.findSubscriptionByIdClient(id);
        result.setDraw(Integer.parseInt(draw));
        ColculationConverter converter = new ColculationConverter();
        for (Subscription item: list
                ) {
            result.addData(converter.culculationToStringArrayAdvanced(item,gymService));
        }
        return result;
    }
}
