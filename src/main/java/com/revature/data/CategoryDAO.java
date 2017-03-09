package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Category;
import com.revature.model.dto.CategoryDTO;

public interface CategoryDAO {

	/**
	 * Used to get the categories data from db.
	 * 
	 * @return categories
	 * @throws DataServiceException
	 *             if any exception happens while executing the query
	 */

	public List<CategoryDTO> getAllCategories() throws DataServiceException;

	public <E> CategoryDTO getCategoryById(Category category) throws DataServiceException;

	public <E> CategoryDTO getCategoryByName(Category category) throws DataServiceException;
}
