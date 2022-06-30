package com.foodmarket.app.statistic.model;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foodmarket.app.product.model.WorkProduct;
import com.foodmarket.app.shopcar.entity.OrderItem;

public interface StatisticProductRepository extends JpaRepository<WorkProduct, Long> {

	//@Query(value="select sum(sales=:sales) as aaaa, productName=:productName from productStatistic group by productName", nativeQuery = true)
	//public List<productStatistic> getStatisticCount(@Param(value="productName") String productName, @Param(value="sales") Integer sales);

	public WorkProduct findByproductid(Long productid);

	//如果要改productStatistic檔名要注意大小寫，原生SQL好像不管大小寫
}