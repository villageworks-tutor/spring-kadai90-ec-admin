package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Controller
public class CategoryAdminController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	// カテゴリー一覧表示
	@GetMapping("/admin/categories")
	public String index(Model model) {
		// すべてのカテゴリーを取得
		List<Category> list = categoryRepository.findAll();
		// 取得したカテゴリーリストをスコープに登録
		model.addAttribute("categoryList", list);
		// 画面遷移
		return "admin/categories";
	}
}
