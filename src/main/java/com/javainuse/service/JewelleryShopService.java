package com.javainuse.service;

import com.javainuse.model.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class JewelleryShopService {

	private final KieContainer kieContainer;
	private final List<Product> eligibleProducts = new ArrayList<Product>();
	private final List<Campaign> eligibleCampaigns = new ArrayList<Campaign>();
	private final List<ProductCategory> eligibleCategories = new ArrayList<ProductCategory>();


	@Autowired
	public JewelleryShopService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Order getProductDiscount(Order order) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(order);
		kieSession.insert(eligibleProducts);
		kieSession.insert(eligibleCampaigns);
		kieSession.fireAllRules();
		kieSession.dispose();
		return order;
	}

	public void generateProducts(){
		this.eligibleProducts.add(new Product("gold", "Nokia 3500", eligibleCategories.get(0), 100.00));
		this.eligibleProducts.add(new Product("silver", "Huawei A11", eligibleCategories.get(1), 1200.00));
		this.eligibleProducts.add(new Product("platinum", "Nokia 3652", eligibleCategories.get(2), 1030.00));
		this.eligibleProducts.add(new Product("gold", "Motorola", eligibleCategories.get(3), 1030.00));
		this.eligibleProducts.add(new Product("silver", "iPhone Pro Max 12", eligibleCategories.get(4), 1004.00));
	}

	public void  generateCampaigns(){
		this.eligibleCampaigns.add(new Campaign(1L, "%x indirim kampanyası", "single", new Benefit(1L, "discount by percentage",  new Discount("percent", 10.0))));
		this.eligibleCampaigns.add(new Campaign(2L,  "xTL indirim kampanyası", "single", new Benefit(2L, "discount by cash",  new Discount("cash", 100.0))));

		this.eligibleCampaigns.add(new Campaign(3L, "Seçili ürün kategorilerinde %15 indirim kampanyası", "single", new Benefit(3L, "discount by percentage",  new Discount("percent", 15.0))));
		this.eligibleCampaigns.add(new Campaign(4L,  "Seçili ürün kategorilerinde 40TL indirim kampanyası", "single", new Benefit(4L, "discount by cash",  new Discount("cash", 40.0))));

		this.eligibleCampaigns.add(new Campaign(5L, "Seçili üründe %x indirim kampanyası", "single", new Benefit(5L, "discount by percentage",  new Discount("percent", 10.0))));
		this.eligibleCampaigns.add(new Campaign(6L,  "Seçili üründe xTL indirim kampanyası", "single", new Benefit(6L, "discount by cash",  new Discount("cash", 20.0))));

		this.eligibleCampaigns.add(new Campaign(7L, "Kredi kartı ödemelerinde %x indirim kampanyası", "single", new Benefit(7L, "discount by percentage",  new Discount("percent", 25.0))));
		this.eligibleCampaigns.add(new Campaign(8L,  "Nakit ödemelerde xTL indirim kampanyası", "single", new Benefit(8L, "discount by cash",  new Discount("cash", 36.0))));

		this.eligibleCampaigns.add(new Campaign(9L, "Seçili ürünlerde 40 puan indirim kampanyası", "single", new Benefit(9L, "discount by point",  new Discount("point", 40.0))));
		this.eligibleCampaigns.add(new Campaign(10L,  "Seçili ürün kategorilerinde 50 puan indirim kampanyası", "single", new Benefit(10L, "discount by point",  new Discount("point", 50.0))));


	}

	public void generateCategories(){
		this.eligibleCategories.add(new ProductCategory(1L, "phone"));
		this.eligibleCategories.add(new ProductCategory(1L, "computer"));
		this.eligibleCategories.add(new ProductCategory(1L, "car"));
		this.eligibleCategories.add(new ProductCategory(1L, "house"));
		this.eligibleCategories.add(new ProductCategory(1L, "drone"));
	}

	@PostConstruct
	public void initialize(){
		generateCampaigns();
		generateCategories();
		generateProducts();
	}

	public List<Product> getEligibleProducts(){
		return this.eligibleProducts;
	}
}