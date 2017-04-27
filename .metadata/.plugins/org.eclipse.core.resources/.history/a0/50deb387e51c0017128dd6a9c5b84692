package com.wpc.validator;

import java.util.ArrayList;
import java.util.List;

import com.wpc.form.ProductForm;

public class ProductValidator {

	public List<String> validate(ProductForm productForm) {
		List<String> errors = new ArrayList<>();

		String name = productForm.getProductName();
		if (name == null || name.trim().isEmpty()) {
			errors.add("Product must have a name !");
		}

		String price = productForm.getPrice();
		if (price == null || price.trim().isEmpty()) {
			errors.add("Product must have a price !");
		} else {
			try {
				Double.parseDouble(price);
			} catch (NumberFormatException e) {
				errors.add("Invalid price value !");
			}
		}

		return errors;
	}

}
