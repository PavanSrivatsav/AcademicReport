package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.dto.CategoryDTO;

public interface CategoryService {

	/**
	 * Used to get all the categories.
	 * 
	 * @return categories
	 * @throws BusinessServiceException
	 *             if any business error occurs
	 */
	List<CategoryDTO> getAllCategories() throws BusinessServiceException;

	CategoryDTO getCategoryById(CategoryDTO categoryDTO) throws BusinessServiceException;

	CategoryDTO getCategoryByName(CategoryDTO categoryDTO) throws BusinessServiceException;

}
