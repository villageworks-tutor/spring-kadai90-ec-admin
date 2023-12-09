package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemAdminController {
	
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ItemRepository itemRepository;
	
	// 管理者用商品一覧画面表示
	@GetMapping("/admin/items")
	public String index(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			Model model) {
		// すべてのカテゴリーを取得
		List<Category> categoryList = categoryRepository.findAll();
		// 取得したカテゴリーリストをスコープに登録
		model.addAttribute("categoryList", categoryList);
		List<Item> itemList = null;
		if (categoryId == null) {
			// すべての商品を取得
			itemList = itemRepository.findAll();
		} else {
			// カテゴリー検索
			itemList = itemRepository.findByCategoryId(categoryId);
		}
		// 取得した商品リストをスコープに登録
		model.addAttribute("itemList", itemList);
		// 画面遷移
		return "admin/items";
	}
	
	// 商品登録画面表示
	@GetMapping("/admin/items/add")
	public String create(Model model) {
		// すべてのカテゴリーを取得
		List<Category> categoryList = categoryRepository.findAll();
		// 取得したカテゴリーリストをスコープに登録
		model.addAttribute("categoryList", categoryList);
		// 画面遷移
		return "admin/addItem";
	}
	
	// 商品登録処理
	@PostMapping("/admin/items/add")
	public String  store(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "") Integer price) {
		// リクエストパラメータをもとに商品インスタンスを生成
		Item item = new Item(categoryId, name, price);
		// 取得した商品インスタンスを永続化
		itemRepository.save(item);
		// 画面遷移
		return "redirect:/admin/items";
	}
	
}
