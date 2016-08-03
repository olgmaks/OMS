package com.softserve.edu.orderingpage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.uipages.CustomerHomePage;
import com.softserve.edu.uipages.LoginPage;
import com.softserve.edu.uipages.OrderDetailsPage;
import com.softserve.edu.uipages.OrderingPage;

/**
 * 
 * @author rromaniktc
 *
 */
public class OrderingPageSmokeTest {
	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		RunnerPage.stop();
	}

	@Test
	public void checkLinksOnOrderingPage() {
		// go to ordering page of OMS application
		OrderingPage orderingPage = new LoginPage().successCustomerLogin(
				UserRepository.getCustomerUser()).goToOrderingPage();

		// go to OrderDetails page and back to OrderingPage
		OrderDetailsPage orderDetailsPage = orderingPage.goToOrderDetailsPage();
		orderingPage = orderDetailsPage.goToOrderingPage();

		// go to HomePage (CustomerHomePage) and back to OrderingPage
		CustomerHomePage customerHomePage = orderingPage.goToCusomerHomePage();
		orderingPage = customerHomePage.goToOrderingPage();

		// refresh OrderingPage by clicking Ordering Link
		orderingPage = orderingPage.clickOrderingTab();

		// logout from OrderingPage
		// LoginPage loginPage =
		orderingPage.logout();
	}

}
