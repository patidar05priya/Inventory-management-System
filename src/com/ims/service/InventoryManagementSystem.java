package com.ims.service;
import com.ims.model.PickingResult;
import com.ims.model.RestockingResult;

/**
 * Copyright (c) 1999-2016 Commerce Technologies Inc. All rights reserved.
 * Implementations of this interface including access to shared data must be
thread-safe.
 **/
public interface InventoryManagementSystem {
	/**
	 * Deduct 'amountToPick' of the given 'productId' from inventory.
	 * @param productId The ID of the product to pick
	 * @param amountToPick The quantity of the product to pick
	 * @return TODO: to be implemented
	 */
	PickingResult pickProduct(String productId, int amountToPick) throws Exception;
	/**
	 * Add 'amountToRestock' of the given productId to inventory.
	 * @param productId The ID of the product to restock
	 * @param amountToRestock The quantity of the product to restock
	 * @return TODO: to be implemented
	 */
	RestockingResult restockProduct(String productId, int amountToRestock) throws Exception;
}