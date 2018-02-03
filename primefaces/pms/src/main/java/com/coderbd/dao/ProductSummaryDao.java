package com.coderbd.dao;



import com.coderbd.common.CommonDao;
import com.coderbd.entity.ProductSummary;


public interface ProductSummaryDao extends CommonDao<ProductSummary> {
	public ProductSummary findProductSummaryByProductCode(String productCode) throws Exception;
}
