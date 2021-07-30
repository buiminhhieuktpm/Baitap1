package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Product;
import com.services.ProductService;



@Controller
public class MainController {
	@Autowired
	ProductService psv;
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("list", psv.listAll());
		return "index";
	}
	@GetMapping("/admin/add")
	public String addproduct(Model model) {
		Product p= new Product();
		model.addAttribute("p", p);
		return "add";
	}
	@GetMapping("/admin/edit/{id}")
	public String editproduct(Model model,@PathVariable("id")int id) {
		Product p = psv.findByID(id);
		model.addAttribute("p", p);
		return "edit";
	}
	@PostMapping("/admin/save")
	public String saveProduct(@ModelAttribute("p")Product p) {
		psv.saveProduct(p);
		return "redirect:/";
	}
	@RequestMapping("/admin/delete/{id}")
	public String deleteProduct(@PathVariable("id")int id) {
		psv.deleteProduct(id);
		return "redirect:/";
	}
}
