package testCases;

import Pages.ProductPage;
import Pages.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends BaseTests {

    @Test
    public void testAddingItem() throws InterruptedException {
        ProductPage ProductPage =homePage.chooseProduct();
        ProductPage.buildYourOwnComputer();
        ProductPage.clickAddToWishButton();

        String successMessage = ProductPage.successMessageText();
        Assert.assertTrue(successMessage.contains("The product has been added to your"),"Item wasn't successfully Added");


    }
    @Test
    public void testAddItemAndCheckWishListPage() {
        ProductPage ProductPage =homePage.chooseProduct();
        ProductPage.buildYourOwnComputer();
        ProductPage.clickAddToWishButton();
        WishListPage WishListPage =	ProductPage.clickWishListPageButton();

        String expectedProductName = "Build your own computer";
        String actualProductName = WishListPage.productName();
        Assert.assertTrue(actualProductName.contains(expectedProductName),"Incorrect Product name");

        String expectedProductSpecs = "RAM: 4GB [+$20.00]";

        String actualProductSpecs = WishListPage.productSpecifications();
        Assert.assertTrue(actualProductSpecs.contains(expectedProductSpecs),"Incorrect Product specifications");

        String expectedProductQuantity = "3";
        String actualProductQuantity = WishListPage.quantityNumber();
        Assert.assertTrue(actualProductQuantity.contains(expectedProductQuantity),"Incorrect Product quantity");

        String expectedProductPrice = "$1,435.00";
        String actualProductPrice = WishListPage.itemPrice();
        Assert.assertTrue(actualProductPrice.contains(expectedProductPrice),"Incorrect Product price");

        WishListPage.updateWishList();
        String expectedProductsTotalPrice = "$4,305.00";
        String actualProductTotalPrice = WishListPage.totalPrice();
        Assert.assertTrue(actualProductTotalPrice.contains(expectedProductsTotalPrice),"Incorrect total price");
    }

