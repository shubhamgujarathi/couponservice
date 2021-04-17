package com.trinadh.springcloud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.trinadh.springcloud.controller.Controller;
import com.trinadh.springcloud.model.Coupon;
import com.trinadh.springcloud.repo.CouponRepo;

@SpringBootTest
class CouponserviceApplicationTests {

	private static final String PRABHAS = "PRABHAS";
	@Mock
	private CouponRepo repo;
	@InjectMocks
	private Controller controller;

	@Test
	public void testCreate() {
		
		Coupon coupon=new Coupon();
		coupon.setCode(PRABHAS);
		when(repo.save(coupon)).thenReturn(coupon);
		Coupon couponCreated = controller.create(coupon);
		verify(repo).save(coupon);
		assertNotNull(couponCreated);
		assertEquals(PRABHAS, coupon.getCode());
	}
	
	@Test
	public void testCreate_WHEN_COUPON_IS_NULL_THROWN_EXCEPTION()
	{
		assertThrows(IllegalArgumentException.class, ()->{
			controller.create(null);	
		});
	 
	}
	
	@Test
	public void testGetCoupon()
	{
		Coupon coupon=new Coupon();
		coupon.setId(123l);
		coupon.setCode(PRABHAS);
		coupon.setDiscount(new BigDecimal(10));
		when(repo.findByCode(PRABHAS)).thenReturn(coupon);
		Coupon couponResponse = controller.getCoupon(PRABHAS);
		verify(repo).findByCode(PRABHAS);
		assertNotNull(couponResponse);
		assertEquals(new BigDecimal(10), couponResponse.getDiscount());
		
	}

}
