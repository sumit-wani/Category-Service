package com.shopify.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.dao.CategoryDao;
import com.shopify.entity.CategoryEntity;
import com.shopify.exception.ResourceNotExistsException;
import com.shopify.model.CategoryModel;
import com.shopify.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public boolean addCategory(CategoryModel categoryModel) {

		CategoryEntity categoryEntity = mapper.map(categoryModel, CategoryEntity.class);

		boolean isAdded = dao.addCategory(categoryEntity);

		return isAdded;
	}

	@Override
	public CategoryModel getCategoryById(long categoryId) {
		CategoryEntity categoryEntity = dao.getCategoryById(categoryId);

		if (categoryEntity != null) {
			CategoryModel categoryModel = mapper.map(categoryEntity, CategoryModel.class);
			return categoryModel;
		} else {
			throw new ResourceNotExistsException("Category Not Exists with ID : " + categoryId);
		}

	}

	@Override
	public boolean updateCategory(CategoryModel categoryModel)  {

	CategoryEntity categoryEntity = mapper.map(categoryModel, CategoryEntity.class);
		
	boolean isUpdated=	dao.updateCategory(categoryEntity);
	
//	if(isUpdated==false) {
//		throw new ResourceNotExistsException("Category Not Exists with ID : " + categoryEntity.getCategoryId());
//	}

		return isUpdated;
	}

}
