package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;

@Controller
public class CustomerAdminController {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	// 顧客一覧画面表示
	@GetMapping("/admin/customers")
	public String index(Model model) {
		// すべての顧客を取得
		List<Customer> list = customerRepository.findAll();
		// 取得した顧客リストをスコープをに登録
		model.addAttribute("customerList", list);
		// 画面遷移
		return "admin/customers";
	}
	
	// 注文情報画面表示
	@GetMapping("/admin/customers/{id}/orders")
	public String show(
			@PathVariable("id") Integer id,
			Model model) {
		// パスパラメータをもとに顧客インスタンスを取得
		Customer customer = customerRepository.findById(id).get();
		// 取得した顧客インスタンスをスコープに登録
		model.addAttribute("customer", customer);
		// 顧客の注文履歴を取得
		List<Order> orderList= orderRepository.findByCustomerId(id);
		// 取得した注文リストをスコープに登録
		model.addAttribute("orderList", orderList);
		// 注文履歴の先頭要素の詳細を取得
		if (orderList != null && orderList.size() > 0) {
			// 注文履歴の戦闘要素を取得
			Order order = orderList.get(0);
			// IDに紐づいた明細を取得
			List<OrderDetail> detailList = orderDetailRepository.findByOrderId(order.getId());
			// 取得した注文リストをスコープに登録
			model.addAttribute("detailList", detailList);
		}
		// 画面遷移
		return "admin/orders.html";
	}
 }
