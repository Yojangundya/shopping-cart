package org.jsp.shoppingcart.controller;

import org.jsp.shoppingcart.dto.Merchant;
import org.jsp.shoppingcart.dto.Product;
import org.jsp.shoppingcart.exception.UserDefinedException;
import org.jsp.shoppingcart.helper.Login;
import org.jsp.shoppingcart.helper.ResponseStructure;
import org.jsp.shoppingcart.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("merchants")
public class MerchantController {

	@Autowired
	MerchantService service;
	
	@PostMapping("signup")
	public ResponseStructure<Merchant> saveMerchant(@RequestBody Merchant merchant)
	{ 
		return service.saveMerchant(merchant);
	}
	
	@PutMapping("signup/{id}")
	public ResponseStructure<Merchant> saveMerchant(@PathVariable int id,@RequestParam int otp) throws UserDefinedException
	{ 
		return service.verifyMerchant(id,otp);
	}
	
	@PostMapping("login")
	public ResponseStructure<Merchant> login(@RequestBody Login login) throws UserDefinedException
	{
		return service.merchantLogin(login);
	}
	
	@PostMapping("products/{id}")
	public ResponseStructure<Merchant> addProduct(@PathVariable int id,@RequestBody Product product)
	{
		return service.addProduct(id,product);
	}
	
	@PutMapping("products")
	public ResponseStructure<Product> updateProduct(@RequestBody Product product)
	{
		return service.updateProduct(product);
	}
	
	@DeleteMapping("products/{id}")
	public ResponseStructure<Product> deleteProduct(@PathVariable int id) throws UserDefinedException
	{
		return service.deleteProduct(id);
	}
	
}
