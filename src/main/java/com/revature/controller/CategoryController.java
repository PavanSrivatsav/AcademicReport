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
import com.revature.model.dto.CategoryDTO;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private static Logger logger = Logger.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list/all")
	public List<CategoryDTO> getActiveCategoriesController() {
		List<CategoryDTO> categories = null;
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
	public CategoryDTO getActiveCategoriesController(@PathVariable("id") Integer id) {
		CategoryDTO categoryById = null;
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(id);
		try {
			logger.info("Getting the categories by id data...");
			categoryById = categoryService.getCategoryById(categoryDTO);
			logger.info("category by id data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return categoryById;
	}

	@GetMapping("/list/name/{name}")
	public CategoryDTO getActiveCategoriesController(@PathVariable("name") String name) {
		CategoryDTO categoryByName = null;
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setName(name);
		
		try {
			logger.info("Getting the categories by name data...");
			categoryByName = categoryService.getCategoryByName(categoryDTO);
			logger.info("category by name data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return categoryByName;
	}

}
