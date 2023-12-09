package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountAdminController {
	// 管理者ログイン画面表示
	@GetMapping("/admin/login")
	public String index() {
		// 画面遷移
		return "admin/login";
	}
	
}
