package com.javainuse.service;

import com.javainuse.model.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JewelleryShopService {

	private final KieContainer kieContainer;
	private final List<Product> eligibleProducts = new ArrayList<Product>();
	private final List<Campaign> eligibleCampaigns = new ArrayList<Campaign>();
	private final List<ProductCategory> eligibleCategories = new ArrayList<ProductCategory>();
	private final List<ProductGroup> eligibleGroups = new ArrayList<ProductGroup>();


	@Autowired
	public JewelleryShopService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Order getProductDiscount(Order order) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(order);
		kieSession.insert(eligibleProducts);
		kieSession.insert(eligibleCampaigns);
		kieSession.insert(eligibleCategories);
		kieSession.insert(eligibleGroups);
		kieSession.fireAllRules();
		kieSession.dispose();
		return order;
	}

	public void generateProducts(){
		this.eligibleProducts.add(new Product("gold", "Nokia 3500", getAsList(eligibleCategories.get(0)), getAsList(eligibleGroups.get(0)) , 100.00));
		this.eligibleProducts.add(new Product("silver", "Huawei A11",  getAsList(eligibleCategories.get(1)), getAsList(eligibleGroups.get(1)), 1200.00));
		this.eligibleProducts.add(new Product("platinum", "Nokia 3652",  getAsList(eligibleCategories.get(2)), getAsList(eligibleGroups.get(2)), 1030.00));
		this.eligibleProducts.add(new Product("gold", "Motorola",  getAsList(eligibleCategories.get(3)), getAsList(eligibleGroups.get(3)), 1030.00));
		this.eligibleProducts.add(new Product("silver", "iPhone Pro Max 12",  getAsList(eligibleCategories.get(4)), getAsList(eligibleGroups.get(4)), 1004.00));
	}

	public void  generateCampaigns(){
		this.eligibleCampaigns.add(new Campaign(1L, "%x indirim kampanyası", "single", new Benefit(1L, "discount by percentage",  new Discount("percent", 10.0))));
		this.eligibleCampaigns.add(new Campaign(2L,  "xTL indirim kampanyası", "single", new Benefit(2L, "discount by cash",  new Discount("cash", 100.0))));

		this.eligibleCampaigns.add(new Campaign(3L, "Seçili ürün kategorilerinde %x indirim kampanyası", "single", new Benefit(3L, "discount by percentage",  new Discount("percent", 15.0))));
		this.eligibleCampaigns.add(new Campaign(4L,  "Seçili ürün kategorilerinde xTL indirim kampanyası", "single", new Benefit(4L, "discount by cash",  new Discount("cash", 40.0))));

		this.eligibleCampaigns.add(new Campaign(5L, "Seçili üründe %x indirim kampanyası", "single", new Benefit(5L, "discount by percentage",  new Discount("percent", 10.0))));
		this.eligibleCampaigns.add(new Campaign(6L,  "Seçili üründe xTL indirim kampanyası", "single", new Benefit(6L, "discount by cash",  new Discount("cash", 20.0))));

		this.eligibleCampaigns.add(new Campaign(7L, "Kredi kartı ödemelerinde %x indirim kampanyası", "single", new Benefit(7L, "discount by percentage",  new Discount("percent", 25.0))));
		this.eligibleCampaigns.add(new Campaign(8L,  "Nakit ödemelerde xTL indirim kampanyası", "single", new Benefit(8L, "discount by cash",  new Discount("cash", 36.0))));

		this.eligibleCampaigns.add(new Campaign(9L, "Seçili ürünlerde x puan indirim kampanyası", "single", new Benefit(9L, "discount by point",  new Discount("point", 40.0))));
		this.eligibleCampaigns.add(new Campaign(10L,  "Seçili ürün kategorilerinde x puan indirim kampanyası", "single", new Benefit(10L, "discount by point",  new Discount("point", 50.0))));

		this.eligibleCampaigns.add(new Campaign(11L,  "xTL üzeri alışverişe özel ytl puan kampanyası", "single", new Benefit(11L, "discount by point",  new Discount("point", 50.0)), 123.0));
		this.eligibleCampaigns.add(new Campaign(12L,  "xTL üzeri alışverişe özel ytl indirim kampanyası", "single", new Benefit(12L, "discount by cash",  new Discount("cash", 125.0)), 250.0));
		this.eligibleCampaigns.add(new Campaign(13L,  "xTL üzeri alışverişe özel %y puan kampanyası", "single", new Benefit(13L, "discount by point",  new Discount("point", 22.0)), 50.0));

		this.eligibleCampaigns.add(new Campaign(14L,  "Seçili ürün gruplarında xTL üzeri alışverişe özel ytl puan kampanyası", "single", new Benefit(14L, "discount by point",  new Discount("point", 55.0)), 123.0));
		this.eligibleCampaigns.add(new Campaign(15L,  "Seçili ürün gruplarında xTL üzeri alışverişe özel ytl indirim kampanyası", "single", new Benefit(15L, "discount by cash",  new Discount("cash", 145.0)), 250.0));
		this.eligibleCampaigns.add(new Campaign(16L,  "Seçili ürün gruplarında xTL üzeri alışverişe özel %y indirim kampanyası", "single", new Benefit(16L, "discount by point",  new Discount("percent", 62.0)), 50.0));


		this.eligibleCampaigns.add(new Campaign(17L,  "xTL üzeri kredi kartı ödemelerine özel yTL indirim kampanyası", "single", new Benefit(17L, "discount by cash",  new Discount("cash", 127.0)), 350.0));
		this.eligibleCampaigns.add(new Campaign(18L,  "xTL nakit ödemelere özel %y indirim kampanyası", "single", new Benefit(18L, "discount by percent",  new Discount("percent", 19.0)), 275.0));



	}

	public void generateCategories(){
		this.eligibleCategories.add(new ProductCategory(1L, "phone"));
		this.eligibleCategories.add(new ProductCategory(2L, "computer"));
		this.eligibleCategories.add(new ProductCategory(3L, "car"));
		this.eligibleCategories.add(new ProductCategory(4L, "house"));
		this.eligibleCategories.add(new ProductCategory(5L, "drone"));
	}

	public void generateGroups(){
		this.eligibleGroups.add(new ProductGroup(1L, "phones"));
		this.eligibleGroups.add(new ProductGroup(2L, "computers"));
		this.eligibleGroups.add(new ProductGroup(3L, "cars"));
		this.eligibleGroups.add(new ProductGroup(4L, "houses"));
		this.eligibleGroups.add(new ProductGroup(5L, "drones"));
	}

	@PostConstruct
	public void initialize(){
		generateCampaigns();
		generateCategories();
		generateGroups();
		generateProducts();
		test();
	}

	public List<Product> getEligibleProducts(){
		return this.eligibleProducts;
	}

	public Double calculate(){
		return 0.0;
	}

	private ArrayList getAsList(Object... objects){
		ArrayList<Object> list = new ArrayList<>(Arrays.asList(objects));
		return list;
	}

	public void test() {
		Order orderObject = new Order();
		Long availableItemSize = orderObject.getOrderItems().stream().filter(orderItem -> this.eligibleGroups.stream().anyMatch(t -> orderItem.getProduct().getGroups().stream().map(ProductGroup::getType).anyMatch(x -> x.equals(((ProductGroup)t).getType())))).count();
		System.out.println(availableItemSize);
	}
}