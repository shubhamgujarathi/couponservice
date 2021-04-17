package com.trinadh.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trinadh.springcloud.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
