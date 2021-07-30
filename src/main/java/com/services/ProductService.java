package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	ProductRepository prepo;
	public List<Product> listAll(){
		return prepo.findAll();
	}
	public Product findByID(int id) {
		return prepo.getById(id);
	}
	public void saveProduct(Product p) {
		prepo.save(p);
	}
	public void deleteProduct(int id) {
		prepo.deleteById(id);
	}
}
