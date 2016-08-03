package com.softserve.edu.supervisor;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.SupervisorItemManagementPageFilters;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.User;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.LoginPage;
import com.softserve.edu.uipages.ItemManagementPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by istebktc
 */
public class ItemManagementPageTest {


    @BeforeClass
    public static void setUp() {
        RunnerPage.load(UrlRepository.getLocalUrl());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        RunnerPage.stop();
    }

    //TODO Asserts
    @Test
    public void searchProductByFullName() {
        //Setup
        ItemManagementPage itemManagementPage = new LoginPage()
                .successSupervisorLogin(UserRepository.getSupervisorUser())
                .goToItemManagementPage();
        //Test
        itemManagementPage.searchProductWithSearchButton
                (SupervisorItemManagementPageFilters.SupervisorField.PRODUCT_NAME,
                        SupervisorTestDataRepository.FULL_PRODUCT_NAME);
        //Verify if found product equals search query
        Specification specification = Specification.get().
                forElement(itemManagementPage.getFirstProductName()
                        .getText()).valueMatch(SupervisorTestDataRepository.FULL_PRODUCT_NAME).
                next()
        //Verify if number of found products equals search query
                .forElement(itemManagementPage.getProductsFoundCounter().
                        getText()).valueMatch(SupervisorTestDataRepository.PRODUCTS_FOUND).next();
        itemManagementPage.logout();
        specification.check();
    }

    @Test
    public void searchProductByFullDescription() {
        //Setup
        ItemManagementPage itemManagementPage = new LoginPage()
                .successSupervisorLogin(UserRepository.getSupervisorUser())
                .goToItemManagementPage();
        //Test
        itemManagementPage.searchProductWithSearchButton
                (SupervisorItemManagementPageFilters.SupervisorField.DESCRIPTION,
                        SupervisorTestDataRepository.FULL_PRODUCT_DESCRIPTION);
        //Verify if found product equals search query
        Specification specification = Specification.get().
                forElement(itemManagementPage.getFirstProductName()
                        .getText()).valueMatch(SupervisorTestDataRepository.FULL_PRODUCT_DESCRIPTION).
                next()
                        //Verify if number of found products equals search query
                .forElement(itemManagementPage.getProductsFoundCounter().
                        getText()).valueMatch(SupervisorTestDataRepository.PRODUCTS_FOUND).next();
        itemManagementPage.logout();
        specification.check();
    }
}
