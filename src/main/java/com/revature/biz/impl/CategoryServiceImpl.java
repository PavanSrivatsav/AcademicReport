package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.CategoryService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CategoryDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Category;
import com.revature.model.dto.CategoryDTO;

@Service
public class CategoryServiceImpl implements CategoryService {

	private static Logger logger = Logger.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List<CategoryDTO> getAllCategories() throws BusinessServiceException {
		List<CategoryDTO> categories = null;
		try {
			categories = categoryDAO.getAllCategories();
			logger.info("Categories retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return categories;
	}

	@Override
	public CategoryDTO getCategoryById(CategoryDTO categoryDTO) throws BusinessServiceException {
	CategoryDTO categoriesById = new CategoryDTO();
	Category category = new Category();
	category.setId(categoryDTO.getId());
		try {
			categoriesById = categoryDAO.getCategoryById(category);
			logger.info("Category retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return categoriesById;
	}

	@Override
	public CategoryDTO getCategoryByName(CategoryDTO categoryDTO) throws BusinessServiceException {
		CategoryDTO categoriesByName = new CategoryDTO();
		Category category = new Category();
		category.setName(categoryDTO.getName());
		
		try {
			categoriesByName = categoryDAO.getCategoryByName(category);
			logger.info("Category retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return categoriesByName;
	}

}
