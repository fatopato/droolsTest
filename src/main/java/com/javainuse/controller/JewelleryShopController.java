package com.javainuse.controller;

import com.javainuse.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javainuse.model.Product;
import com.javainuse.service.JewelleryShopService;

import java.util.Timer;

@RestController
public class JewelleryShopController {

	private final JewelleryShopService jewelleryShopService;

	@Autowired
	public JewelleryShopController(JewelleryShopService jewelleryShopService) {
		this.jewelleryShopService = jewelleryShopService;
	}

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public Order getQuestions(@RequestBody Order order) {

		long start = System.currentTimeMillis();
		jewelleryShopService.getProductDiscount(order);
		System.out.println("-----------------------------------------------------");
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		return order;
	}

}
