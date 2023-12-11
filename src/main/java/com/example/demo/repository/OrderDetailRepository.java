package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	/**
	 * 注文番号で注文詳細を取得する
	 * SELECT * FROM order_details WHERE order_id = ?
	 */
	List<OrderDetail> findByOrderId(Integer orderId);

}
