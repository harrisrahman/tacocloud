package org.study.pcfdevcert.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.study.pcfdevcert.domain.Ingredient;
import org.study.pcfdevcert.domain.Order;
import org.study.pcfdevcert.domain.Taco;
import org.study.pcfdevcert.repository.IngredientRepository;
import org.study.pcfdevcert.repository.TacoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/design")
@SessionAttributes("order")
public class DesignTacoController {

    Logger logger = LoggerFactory.getLogger(DesignTacoController.class);

    private final IngredientRepository repository;
    private final TacoRepository tacoRepository;


    @ModelAttribute
    public Order order(){
        return new Order();
    }

    @ModelAttribute
    public Taco taco(){
        return new Taco();
    }

    @Autowired
    public DesignTacoController(IngredientRepository repository, TacoRepository tacoRepository) {
        this.repository = repository;
        this.tacoRepository = tacoRepository;
    }

    private void initializeModel(Model model){
        List<Ingredient> ingredientList = new ArrayList<>();
        repository.findAll().forEach(ing -> ingredientList.add(ing));
        logger.info("** Model initialization *******");
        for (Ingredient.Type type : Ingredient.Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), ingredientList.stream().
                    filter(ingredient -> ingredient.getType().name().equalsIgnoreCase(type.name())).collect(Collectors.toList()));
        }
    }

    @GetMapping()
    public String showDesignForm(Taco taco, Model model) {
        logger.info("** In Design Form *******");
        initializeModel(model);
        return "design";
    }

    @PostMapping()
    public String processDesign(@Valid Taco taco,
                                BindingResult bindingResult, Model model,
                                @ModelAttribute Order order) {

        if (bindingResult.hasErrors()) {
            logger.info("** Has validation errors **" + taco);
            initializeModel(model);
            return "design";
        }

        logger.info("** In Processing design *******" + taco);
        Taco taco1 = tacoRepository.save(taco);
        order.addDesign(taco1);
        return "redirect:/orders/current/";
    }
}
