package com.bbodenheimer.yucksnyums.controller;
import com.bbodenheimer.yucksnyums.dao.CategoryDAO;
import com.bbodenheimer.yucksnyums.dao.FoodDAO;
import com.bbodenheimer.yucksnyums.model.Category;
import com.bbodenheimer.yucksnyums.model.Food;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tools")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)

public class InternalToolsController {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("Spring-Module.xml");
    @GetMapping("/getAllCategories")
    @ResponseBody
    public List<Category> getCategories() {
        CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
        return categoryDAO.getAllCategories();
    }

    @PostMapping(path = "/addFood", consumes = "application/json", produces = "application/json")
    public String newFood(@RequestBody Food newFood) {
        try {
            FoodDAO foodDAO = (FoodDAO) context.getBean("foodDAO");
            Food food = new Food(newFood.getDescription(), newFood.getCategory());
            foodDAO.insert(food);
        } catch (Exception e) {
            throw e;
        }
        return "";
    }

    @PostMapping(path = "/addCategory", consumes = "application/json", produces="application/json")
    public String newCategory(@RequestBody Category newCategory) {
        try {
            CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
            Category category = new Category(newCategory.getDescription());
            categoryDAO.insert(category);
        } catch(Exception e) {
            throw e;
        }
        return "";
    }
}
