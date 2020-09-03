package com.bbodenheimer.yucksnyums.controller;
import com.bbodenheimer.yucksnyums.dao.CategoryDAO;
import com.bbodenheimer.yucksnyums.dao.FoodDAO;
import com.bbodenheimer.yucksnyums.dao.PreferenceDAO;
import com.bbodenheimer.yucksnyums.model.Category;
import com.bbodenheimer.yucksnyums.model.Food;
import com.bbodenheimer.yucksnyums.model.Preference;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)

public class MainController {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("Spring-Module.xml");
    @GetMapping("/getAllCategories")
    @ResponseBody
    public List<Category> getCategories() {
        CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
        return categoryDAO.getAllCategories();
    }

    @GetMapping("/getFoodByCategory")
    @ResponseBody
    public List<Food> getFoodByCategory(@RequestParam int category) {
        FoodDAO foodDAO = (FoodDAO) context.getBean("foodDAO");
        return foodDAO.findFoodByCategory(category);
    }

}
