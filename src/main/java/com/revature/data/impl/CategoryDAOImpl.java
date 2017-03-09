package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.CategoryDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Category;
import com.revature.model.dto.CategoryDTO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	private static Logger logger = Logger.getLogger(CategoryDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
}
	
	@Override
	public List<CategoryDTO> getAllCategories() throws DataServiceException {
		List<CategoryDTO> categories = null;
		try {
			StringBuilder sb = new StringBuilder("select c.ID id,c.NAME name,c.IS_ACTIVE isActive from seed_categories c where c.IS_ACTIVE=true");
			categories = dataRetriver.retrieveBySQLAsJSON(sb.toString(),CategoryDTO.class);
			logger.info("Categories data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return categories;
	}

	@Override
	public <E>CategoryDTO getCategoryById(Category category) throws DataServiceException {
		CategoryDTO categoriesById = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select c.ID id,c.NAME name,c.IS_ACTIVE isActive from seed_categories c where c.ID='" + category.getId() + "' and c.IS_ACTIVE=true");
			categoriesById = (CategoryDTO)dataRetriver.retrieveBySQLAsObject(sb.toString(),CategoryDTO.class);
			logger.info("Category data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return categoriesById;
	}

	@Override
	public <E>CategoryDTO getCategoryByName(Category category) throws DataServiceException {
		CategoryDTO categoriesByName = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select c.ID id,c.NAME name,c.IS_ACTIVE isActive from seed_categories c where c.NAME='" + category.getName() + "' and c.IS_ACTIVE=true");
			categoriesByName = (CategoryDTO)dataRetriver.retrieveBySQLAsObject(sb.toString(),CategoryDTO.class);
			logger.info("Category data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return categoriesByName;
	}

}
