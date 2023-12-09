package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// カテゴリー登録画面表示
	@GetMapping("/admin/categories/add")
	public String create() {
		// 画面遷移
		return "admin/addCategory";
	}
	
	// カテゴリー登録処理
	@PostMapping("/admin/categories/add")
	public String store(@RequestParam("name") String name) {
		// リクエストパラメータをもとにカテゴリーインスタンスを生成
		Category category = new Category(name);
		// 生成したカテゴリーインスタンスを永続化
		categoryRepository.save(category);
		// 画面遷移
		return "redirect:/admin/categories";
	}
	
	// カテゴリー更新画面表示
	@GetMapping("/admin/categories/{id}/edit")
	public String edit(
			@PathVariable("id") Integer id,
			Model model) {
		// カテゴリーインスタンスを取得
		Category category = categoryRepository.findById(id).get();
		// 取得したカテゴリーインスタンスをスコープに登録
		model.addAttribute("category", category);
		// 画面遷移
		return "admin/editCategory";
	}
	
	// カテゴリー登録処理
	@PostMapping("/admin/categories/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam("name") String name) {
		// パスパラメータとリクエストパラメータをもとにカテゴリーインスタンスを生成
		Category category = new Category(id, name);
		// 生成したカテゴリーインスタンスを永続化
		categoryRepository.save(category);
		// 画面遷移
		return "redirect:/admin/categories";
	}
	
	// カテゴリー削除処理
	@PostMapping("/admin/categories/{id}/delete")
	public String delete(@PathVariable("id") Integer id) {
		// カテゴリー削除
		categoryRepository.deleteById(id);
		// 画面遷移
		return "redirect:/admin/categories";
	}
	
}
