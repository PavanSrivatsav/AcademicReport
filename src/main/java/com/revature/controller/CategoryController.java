package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.CategoryService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Category;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private static Logger logger = Logger.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list/all")
	public List<Category> getActiveCategoriesController() {
		List<Category> categories = null;
		try {
			logger.info("Getting the categories data...");
			categories = categoryService.getAllCategories();
			logger.info("categories data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return categories;
	}

	@GetMapping("/list/id/{id}")
	public List<Category> getActiveCategoriesController(@PathVariable("id") int categoryId) {
		List<Category> category = null;
		try {
			logger.info("Getting the categories data...");
			category = categoryService.getCategoryById(categoryId);
			logger.info("category data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return category;
	}

	@GetMapping("/list/name/{name}")
	public List<Category> getActiveCategoriesController(@PathVariable("name") String categoryName) {
		List<Category> category = null;
		try {
			logger.info("Getting the categories data...");
			category = categoryService.getCategoryByName(categoryName);
			logger.info("category data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return category;
	}

}
