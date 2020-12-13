package com.javainuse.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javainuse.model.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewelleryShopService {

	private final KieContainer kieContainer;
	private final List<CampaignBody> eligibleCampaigns = new ArrayList<>();
	private final HashMap<String, ProductCategory> categoryHashMap = new HashMap<>();
	private final HashMap<String, Product> productHashMap = new HashMap<>();
	private Long counter = 1L;

	@Autowired
	public JewelleryShopService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Order getProductDiscount(Order order) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		KieSession kieSession2 = kieContainer.newKieSession("rulesSession2");
		KieSession kieSession3 = kieContainer.newKieSession("rulesSession3");
		KieSession kieSession4 = kieContainer.newKieSession("rulesSession4");
		ArrayList<KieSession> sessions = new ArrayList<>();
		sessions.add(kieSession);
		sessions.add(kieSession2);
		sessions.add(kieSession3);
		sessions.add(kieSession4);

//		sessions.forEach(s -> {s.insert(order); s.insert(eligibleCampaigns); s.fireAllRules();});
		sessions.parallelStream().forEach(s -> {s.insert(order); s.insert(eligibleCampaigns); s.fireAllRules();});
		sessions.parallelStream().forEach(KieSession::dispose);
		return order;
	}

//	public void generateProducts(){
//		productHashMap.put("Nokia 3500", new Product("gold", "Nokia 3500", categoryHashMap.get("house") , 100.00));
//		productHashMap.put("Huawei A11", new Product("silver", "Huawei A11",  categoryHashMap.get("house"), 1200.00));
//		productHashMap.put("Nokia 3652", new Product("platinum", "Nokia 3652",  categoryHashMap.get("house"), 1030.00));
//		productHashMap.put("Motorola", new Product("gold", "Motorola",  categoryHashMap.get("house"), 1030.00));
//		productHashMap.put("iPhone Pro Max 12", new Product("silver", "iPhone Pro Max 12",  categoryHashMap.get("house"), 1004.00));
//	}
//
//	public void  generateCampaigns(){
//		HashMap<String, Object> parameters = new HashMap<>();
//		parameters.put("categories", categoryHashMap);
//		parameters.put("products", productHashMap);
//
//		this.eligibleCampaigns.add(new Campaign(1L, "%x indirim kampanyası", "single", new Benefit(1L, "discount by percentage",  new Discount("percent", 10.0))));
//		this.eligibleCampaigns.add(new Campaign(2L,  "xTL indirim kampanyası", "single", new Benefit(2L, "discount by cash",  new Discount("cash", 100.0))));
//
//		this.eligibleCampaigns.add(new Campaign(3L, "Seçili ürün kategorilerinde %x indirim kampanyası", "single", new Benefit(3L, "discount by percentage",  new Discount("percent", 15.0)), parameters));
//		this.eligibleCampaigns.add(new Campaign(4L,  "Seçili ürün kategorilerinde xTL indirim kampanyası", "single", new Benefit(4L, "discount by cash",  new Discount("cash", 40.0)), parameters));
//
//		this.eligibleCampaigns.add(new Campaign(5L, "Seçili üründe %x indirim kampanyası", "single", new Benefit(5L, "discount by percentage",  new Discount("percent", 10.0)), parameters));
//		this.eligibleCampaigns.add(new Campaign(6L,  "Seçili üründe xTL indirim kampanyası", "single", new Benefit(6L, "discount by cash",  new Discount("cash", 20.0)), parameters));
//
//		this.eligibleCampaigns.add(new Campaign(7L, "Kredi kartı ödemelerinde %x indirim kampanyası", "single", new Benefit(7L, "discount by percentage",  new Discount("percent", 25.0))));
//		this.eligibleCampaigns.add(new Campaign(8L,  "Nakit ödemelerde xTL indirim kampanyası", "single", new Benefit(8L, "discount by cash",  new Discount("cash", 36.0))));
//
//		this.eligibleCampaigns.add(new Campaign(9L, "Seçili ürünlerde x puan indirim kampanyası", "single", new Benefit(9L, "discount by point",  new Discount("point", 40.0)), parameters));
//		this.eligibleCampaigns.add(new Campaign(10L,  "Seçili ürün kategorilerinde x puan indirim kampanyası", "single", new Benefit(10L, "discount by point",  new Discount("point", 50.0)), parameters));
//
//		this.eligibleCampaigns.add(new Campaign(11L,  "xTL üzeri alışverişe özel ytl puan kampanyası", "single", new Benefit(11L, "discount by point",  new Discount("point", 50.0)), 123.0));
//		this.eligibleCampaigns.add(new Campaign(12L,  "xTL üzeri alışverişe özel ytl indirim kampanyası", "single", new Benefit(12L, "discount by cash",  new Discount("cash", 125.0)), 250.0));
//		this.eligibleCampaigns.add(new Campaign(13L,  "xTL üzeri alışverişe özel %y puan kampanyası", "single", new Benefit(13L, "discount by point",  new Discount("point", 22.0)), 50.0));
//
//		this.eligibleCampaigns.add(new Campaign(14L,  "Seçili ürün gruplarında xTL üzeri alışverişe özel ytl puan kampanyası", "single", new Benefit(14L, "discount by point",  new Discount("point", 55.0)), 123.0, parameters));
//		this.eligibleCampaigns.add(new Campaign(15L,  "Seçili ürün gruplarında xTL üzeri alışverişe özel ytl indirim kampanyası", "single", new Benefit(15L, "discount by cash",  new Discount("cash", 145.0)), 250.0, parameters));
//		this.eligibleCampaigns.add(new Campaign(16L,  "Seçili ürün gruplarında xTL üzeri alışverişe özel %y indirim kampanyası", "single", new Benefit(16L, "discount by point",  new Discount("percent", 62.0)), 50.0, parameters));
//
//
//		this.eligibleCampaigns.add(new Campaign(17L,  "xTL üzeri kredi kartı ödemelerine özel yTL indirim kampanyası", "single", new Benefit(17L, "discount by cash",  new Discount("cash", 127.0)), 350.0));
//		this.eligibleCampaigns.add(new Campaign(18L,  "xTL nakit ödemelere özel %y indirim kampanyası", "single", new Benefit(18L, "discount by percent",  new Discount("percent", 19.0)), 275.0));
//
//
//
//	}

//	public void generateCategories(){
//		categoryHashMap.put("phone", new ProductCategory(1L, "phone"));
//		categoryHashMap.put("computer", new ProductCategory(2L, "computer"));
//		categoryHashMap.put("car", new ProductCategory(3L, "car"));
//		categoryHashMap.put("house", new ProductCategory(4L, "house"));
//		categoryHashMap.put("drone", new ProductCategory(5L, "drone"));
//	}

//	private Campaign bodyToCampaign(CampaignBody campaignBody){
//		return new Campaign(counter, campaignBody.getName(), "single",
//				new Benefit(
//						counter, campaignBody.getBenefitType().toString(),
//						new Discount(campaignBody.getBenefitType().toString(),
//								campaignBody.getBenefitAmount())
//				),
//				campaignBody.getLimit(), campaignBody.getPaymentMethod(),campaignBody.getParameters()
//				);
//	}

	public CampaignBody createCampaign(CampaignBody campaignBody){
		campaignBody.setId(counter);
		campaignBody.getParameters().put("products", campaignBody.getParameters().get("products").stream().map(o -> new ObjectMapper().convertValue(o, Product.class)).collect(Collectors.toList()));
		campaignBody.getParameters().put("categories", campaignBody.getParameters().get("categories").stream().map(o -> new ObjectMapper().convertValue(o, ProductCategory.class)).collect(Collectors.toList()));
		campaignBody.getParameters().put("attributes", campaignBody.getParameters().get("attributes").stream().map(o -> new ObjectMapper().convertValue(o, ProductAttribute.class)).collect(Collectors.toList()));
		eligibleCampaigns.add(campaignBody);
		counter++;
		return campaignBody;
	}

//	@PostConstruct
//	public void initialize(){
//		generateCategories();
//		generateProducts();
//		generateCampaigns();
//	}
}