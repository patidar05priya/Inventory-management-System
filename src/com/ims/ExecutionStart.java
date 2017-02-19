package com.ims;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import com.ims.model.PickingResult;
import com.ims.model.RestockingResult;
import com.ims.service.InventoryManagementSystem;
import com.ims.service.impl.InventoryManagementSystemImpl;
import com.ims.util.ConfigUtil;


public class ExecutionStart {
	
	private static final Logger LOGGER = Logger.getLogger(ExecutionStart.class.getName());
	
	public static void main(String[] args){	
		Object object = null;
		BufferedReader bufferedReader = null;
		InventoryManagementSystem inventoryManagementSystem = null;
		System.out.println("----------WELCOME TO IMS----------");
		try{
			System.out.println("Available products: "+ConfigUtil.products);
			
			inventoryManagementSystem = new InventoryManagementSystemImpl();
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			boolean bool = true;
			System.out.println("which operation, do you want to perform. ");
			while(bool){
				System.out.println("For pickProduct, press 1.\nFor restockProduct, press 2. ");
				int action = ConfigUtil.convertToInt(bufferedReader.readLine());
				if(action==1){
					System.out.println("Please enter ProductId: ");
					String productId = bufferedReader.readLine();
					System.out.println("How many product, you want to pick ");
					int amountToPick = ConfigUtil.convertToInt(bufferedReader.readLine());
					object = inventoryManagementSystem.pickProduct(productId, amountToPick);
				}else if(action==2){
					System.out.println("Please enter ProductId: ");
					String productId = bufferedReader.readLine();
					System.out.println("How many product, you want to restock ");
					int amountToRestock = ConfigUtil.convertToInt(bufferedReader.readLine());
					object = inventoryManagementSystem.restockProduct(productId, amountToRestock);
				}else{
					System.err.println("You entered wrong value, do you want to continue ");
				}
				System.out.println("Result: "+object.toString());
				System.out.println("Available products: "+ConfigUtil.products);

				System.out.println("Do You want to continue,presss 1 for continue ");
				int con = ConfigUtil.convertToInt(bufferedReader.readLine());
				if(con==1){
					bool = true;
				}else{
					bool = false;
				}
			}	
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			System.out.println("----------YOU ARE LOGGED OUT. THANKYOU----------");
			close(bufferedReader);
			System.exit(0);
		}
	}
	
	private static void close(BufferedReader bufferedReader){
		try{
			if(bufferedReader!=null){
				bufferedReader.close();
			}
		}catch(Exception ex){
		}
	}
}
