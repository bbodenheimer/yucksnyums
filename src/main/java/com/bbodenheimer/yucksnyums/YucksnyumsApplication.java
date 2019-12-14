package com.bbodenheimer.yucksnyums;

import com.bbodenheimer.yucksnyums.dao.CategoryDAO;
import com.bbodenheimer.yucksnyums.dao.FoodDAO;
import com.bbodenheimer.yucksnyums.model.Category;
import com.bbodenheimer.yucksnyums.model.Food;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class YucksnyumsApplication {

	public static void main(String[] args) {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		List<Category> allCategories = categoryDAO.getAllCategories();

//		Category category = new Category("Test");
//		categoryDAO.insert(category);

//		Category categoryFind = categoryDAO.findCategoryById(2);
//		System.out.println(categoryFind);

//		FoodDAO foodDAO = (FoodDAO) context.getBean("foodDAO");
//		Food food = new Food("Test", 2);
//		foodDAO.insert(food);

//		Food foodFind = foodDAO.findFoodById(1);
//		System.out.println(foodFind);

		System.out.println("Successful Run");
	}

}
