package com.trinadh.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trinadh.springcloud.model.Coupon;
import com.trinadh.springcloud.repo.CouponRepo;

@RestController
@RequestMapping("/couponsapi")
public class Controller {
	
	@Autowired
	CouponRepo repo;
	
	@PostMapping("/coupon")
	public Coupon create(@RequestBody Coupon coupon)
	{
		if(coupon==null)
		{
		
			throw new IllegalArgumentException("Coupon is Required");
		}
			return repo.save(coupon);
	}

	@GetMapping("/coupon/{code}")
	public Coupon getCoupon(@PathVariable("code") String code)
	{
		return repo.findByCode(code);
	}
}
