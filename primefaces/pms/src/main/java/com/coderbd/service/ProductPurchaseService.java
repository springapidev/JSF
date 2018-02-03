package com.coderbd.service;

import java.util.List;

import com.coderbd.common.CommonService;
import com.coderbd.dao.ProductPurchaseDao;
import com.coderbd.entity.ProductPurchase;

public class ProductPurchaseService extends CommonService<ProductPurchase> implements ProductPurchaseDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductPurchase> findAllProductPurchaseCategory(int id) throws Exception {
		return ((List<ProductPurchase>) getSession().createQuery("SELECT t from ProductPurchase t where productCategory.id='"+id+"'").getResultList());
	}
}
