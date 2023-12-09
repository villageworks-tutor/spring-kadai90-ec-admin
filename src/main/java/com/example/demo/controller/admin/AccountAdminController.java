package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountAdminController {
	// 管理者ログイン画面表示
	@GetMapping("/admin/login")
	public String index() {
		// 画面遷移
		return "admin/login";
	}
	
	// 管理者ログイン処理
	@PostMapping("/admin/login")
	public String login(
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			Model model) {
		// 管理者用ログイン処理
		boolean notAuthenticated = !("admin".equals(name) && "himitu".equals(password));
		if (notAuthenticated) {
			model.addAttribute("error", "ユーザ名とパスワードが一致しませんでした");
			return "/admin/login";
		}
		// 画面遷移
		return "redirect:/admin/items";
	}
	
}
