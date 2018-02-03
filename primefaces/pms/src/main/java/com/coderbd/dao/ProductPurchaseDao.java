package com.coderbd.dao;

import java.util.List;

import com.coderbd.common.CommonDao;
import com.coderbd.entity.ProductPurchase;


public interface ProductPurchaseDao extends CommonDao<ProductPurchase>{
	public List<ProductPurchase> findAllProductPurchaseCategory(int id) throws Exception;
}
