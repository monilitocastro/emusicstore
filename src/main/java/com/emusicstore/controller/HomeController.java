package com.emusicstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;

@Controller
public class HomeController {
	

		

		@Autowired
		private ProductDao productDao; //Spring will drop in the productDao due to the applicationContext.xml
		
		@RequestMapping("/")
		public String home(){
			return "home";
		}
		
		@RequestMapping("/productList")
		public String getProducts(Model model){
			List<Product> products = productDao.getAllProducts();
			
			model.addAttribute("products", products);
			
			return "productList";
		}
		
		@RequestMapping("/productList/viewProduct/{productId}")
		public String viewProduct(@PathVariable String productId, Model model){
			Product product = null;
		
			product = productDao.getProductById(productId);

			model.addAttribute(product);
			
			return "viewProduct";
		}
		
}