package com.jbk.hibernate;

import java.util.List;
import java.util.Scanner;
import com.jbk.hibernate.entity.Product;
import com.jbk.hibernate.service.ProductService;
import com.jbk.hibernate.utility.ProductUtility;

public class ProductController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch;
		ProductService service = new ProductService();
		do {

			System.out.println("Press 1 for save product");
			System.out.println("Press 2 for get product by id");
			System.out.println("Press 3 for delete product by id ");
			System.out.println("Press 4 for update product");
			System.out.println("Press 5 for get all product");
			System.out.println("Press 6 for get all product By assending order by name");
			System.out.println("Press 7 for get all product By decending order by name");
			System.out.println("Press 8 for get product which hase greater than price");
			System.out.println("Press 9 for get product which hase lesser than price");
			System.out.println("Press 10 for sorting by charecters in product name");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				Product product = ProductUtility.prepareProductData(scanner);
				boolean isAdded = service.saveProduct(product);
				if (isAdded) {
					System.out.println("Product saved!!");

				} else {
					System.out.println("Product already Exist with Id " + product.getProductId());
				}

				break;
			}
			case 2: {
				System.out.println("Enter Product Id");
				long productId = scanner.nextLong();
				Product product = service.getProductById(productId);
				if (product != null) {
					System.out.println(product);
				} else {
					System.out.println("product for this id " + productId + " is not exist");
				}
				break;
			}
			case 3: {
				System.out.println("Enter product Id for delete product");
				long productId = scanner.nextLong();
				boolean isDeleted = service.deleteProductById(productId);
				if (isDeleted) {
					System.out.println("Product is Deleted");
				} else {
					System.out.println("Product is not Exist");
				}
				break;
			}
			case 4: {
				Product product = ProductUtility.prepareProductData(scanner);
				boolean isUpdated = service.updateProduct(product);
				if (isUpdated) {
					System.out.println("Product Updated");
				} else {
					System.out.println("product for this id " + product.getProductId() + " is not exist for update");
				}
				break;
			}
			case 5:{
				List<Product> allProduct = service.getAllProduct();
				if (allProduct.isEmpty() || allProduct==null) {
					System.out.println("Products not exist");
				}else {
					System.out.println("Existing Products are");
					for(Product product:allProduct) {
						System.out.println(product);
					}
				}
				break;
			}
			case 6:{
				List<Product> allAscProduct = service.getAllProductByAsendingOrderByName();
				if (allAscProduct.isEmpty() || allAscProduct==null) {
					System.out.println("Products not exist");
				}else {
					System.out.println("Existing Products by assending order by name");
					for(Product product:allAscProduct) {
						System.out.println(product);
					}
				}
				break;
			}
			case 7:{
				List<Product> allDscProduct = service.getAllProductByDesendingOrderByName();
				if (allDscProduct.isEmpty() || allDscProduct==null) {
					System.out.println("Products not exist");
				}else {
					System.out.println("Existing Products by decending order by name");
					for(Product product:allDscProduct) {
						System.out.println(product);
					}
				}
				break;
			}
			case 8:{
				System.out.println("Enter the Product Value for getting greater than this valus product");
				 double productPrice=scanner.nextDouble();
				List<Product> gTProduct = service.getAllGtProduct(productPrice);
				if (gTProduct.isEmpty() || gTProduct==null) {
					System.out.println("Grater value Products not exist");
				}else {
					System.out.println("Existing Products greater than given Value  of "+ productPrice);
					for(Product product:gTProduct) {
						System.out.println(product);
					}
				}
				break;
			}
			case 9:{
				System.out.println("Enter the Product Value for getting lesser than this valus product");
				 double productPrice=scanner.nextDouble();
				List<Product> lTProduct = service.getAllLtProduct(productPrice);
				if (lTProduct.isEmpty() || lTProduct==null) {
					System.out.println("Lesser value Products not exist");
				}else {
					System.out.println("Existing Products lesser than given Value of "+ productPrice);
					for(Product product:lTProduct) {
						System.out.println(product);
					}
				}
				break;
			}
			case 10:{
				System.out.println("Enter the charectrs which you want to find in product name");
				 String stringChar="%"+scanner.next()+"%";
				List<Product> charProduct = service.getAllCharProduct(stringChar);
				if (charProduct.isEmpty() || charProduct==null) {
					System.out.println("Lesser value Products not exist");
				}else {
					System.out.println("Existing Products having charecters of  "+ stringChar);
					for(Product product:charProduct) {
						System.out.println(product);
					}
				}
				break;
			}

			default:
				break;
			}

			System.out.println("Do you want to continue y/n");
			ch = scanner.next().toLowerCase().charAt(0);
		} while (ch == 'y');
		System.out.println("Terminated");

	}

}// make up=1500
//jense =2000
//dress=1200*3=5000
//blows pice material=1200
//shilai =1000
//crime=300
//top=1000 