package com.softserve.edu.supervisor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.controls.Runner;
import com.softserve.edu.data.SupervisorItemManagementPageFilters.SupervisorField;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.ItemManagementPage;
import com.softserve.edu.uipages.LoginPage;

public class AddProductTest {
	
	private static final String productName = "testName";
	private static final String productDescription = "testDescription";
	private static final float productPrice = 1132.32F;
	
	
	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}
	
	@Test
	public void testAddingProduct() {
		ItemManagementPage itemManagementPage = new LoginPage().successSupervisorLogin(UserRepository.getSupervisorUser())
			.goToItemManagementPage().goToAddProductPage()
			.createNewProduct(productName, productDescription, productPrice);
		
		itemManagementPage.searchProductWithSearchButton(SupervisorField.PRODUCT_NAME, "testName");
		itemManagementPage = new ItemManagementPage();
		
        Specification specification = Specification.get()
        		.forElement(itemManagementPage.getFirstProductName().getText()).valueMatch("testName")
                .next()
                .forElement(itemManagementPage.getProductsFoundCounter().getText()).valueMatch("1")
                .next();
        
        specification.check();
	}
	
	@AfterClass
	public static void tearDown() {
		RunnerPage.stop();
	}

}
