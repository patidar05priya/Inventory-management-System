package com.ims.service.impl;
import java.util.logging.Logger;

import com.ims.exception.ProductNotFoundException;
import com.ims.exception.ProductOutOfStockException;
import com.ims.model.PickingResult;
import com.ims.model.Product;
import com.ims.model.RestockingResult;
import com.ims.service.InventoryManagementSystem;
import com.ims.util.ConfigUtil;


public class InventoryManagementSystemImpl implements InventoryManagementSystem{

	private static final Logger LOGGER = Logger.getLogger(InventoryManagementSystemImpl.class.getName());
	
	
	@Override
	public PickingResult pickProduct(String productId, int amountToPick) throws Exception {
		LOGGER.info("Inside @class InventoryManagementSystemImpl @method pickProduct @param productId: "+productId+" amountToPick: "+amountToPick);		
		PickingResult pickingResult = null;
		pickingResult = new PickingResult();
		String msg="";
		try{
			int productId1 = getProjectIdAsInt(productId);
			Product product = findById(productId1);
			if(product.getLevel()==0){
				throw new ProductOutOfStockException();
			}
			
			if(product.getLevel()>=amountToPick){
				product.setLevel(product.getLevel()-amountToPick);
				update(product);
				msg=" "+amountToPick+" product are picked for "+productId;
			}else{
				msg=" Only "+product.getLevel()+" Product are available";
			}
			pickingResult.setProduct(product);
			pickingResult.setMsg(msg);
		}catch(ProductNotFoundException pnfe){
			pickingResult.setMsg("No Product Found for Id "+productId);
			LOGGER.severe("No Product Found for Id "+productId);
		}catch(ProductOutOfStockException poose){
			pickingResult.setMsg("Product out of Stock ");
			LOGGER.severe("Product out of Stock "+productId);
		}catch(Exception ex){
			throw ex;
		}
		return pickingResult;
	}

	public void update(Product product){
		try{
			ConfigUtil.products.set(product.getProductId(), product);
		}catch(Exception ex){
			throw ex;
		}
	}
	
	@Override
	public RestockingResult restockProduct(String productId, int amountToRestock) throws Exception  {
		LOGGER.info("Inside @class InventoryManagementSystemImpl @method restockProduct @param productId: "+productId+" amountToRestock: "+amountToRestock);
		RestockingResult restockingResult = null;
		restockingResult = new RestockingResult();
		Product product = null;
		try{
			if(amountToRestock>0){
				int productId1 = getProjectIdAsInt(productId);
				product = findById(productId1);
				product.setLevel(product.getLevel()+amountToRestock);
				update(product);
				restockingResult.setProduct(product);
				restockingResult.setMsg(amountToRestock+" quantities are added for id: "+productId);
			}
		}catch(ProductNotFoundException pnfe){
			restockingResult.setMsg("No Product Found for Id "+productId);
			LOGGER.severe("No Product Found for Id "+productId);
		}catch(Exception ex){
			throw ex;
		}
		return restockingResult;
	}
	
	private int getProjectIdAsInt(String productId){
		if(productId==null){
			throw new NullPointerException("Product Id Is Null");
		}
		return ConfigUtil.convertToInt(productId);
	}
	
	private Product findById(int productId1) throws ProductNotFoundException{
		Product product = null;
		try{
			if(ConfigUtil.products.size()>productId1){
				product = ConfigUtil.products.get(productId1);				
			}
		if(product==null){
			throw new ProductNotFoundException();
		}
		}catch(Exception ex){
			LOGGER.severe("Error occured Inside @class InventoryManagementSystemImpl @method findById "+ex);
			throw ex;
		}
		return product;
	}
	
}
