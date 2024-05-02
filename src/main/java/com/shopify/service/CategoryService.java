package com.shopify.service;

import com.shopify.model.CategoryModel;

public interface CategoryService {
	
	public boolean addCategory(CategoryModel categoryModel);
	
	public CategoryModel getCategoryById(long categoryId);
	
	public boolean updateCategory(CategoryModel categoryModel);

}
