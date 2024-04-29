package testCases;

import Pages.ProductPage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTests {
    @Test
    public void testAddingItem() throws InterruptedException {
        ProductPage ProductPage =homePage.chooseProduct();
        ProductPage.buildYourOwnComputer();
        ProductPage.clickAddToCartButton();

        String successMsg = ProductPage.successMessageText();
        Assert.assertTrue(successMsg.contains("The product has been added to your"),"Item wasn't successfully Added");

    }
    @Test
    public void testAddItemAndCheckCartPage() {
        ProductPage ProductPage =homePage.chooseProduct();
        ProductPage.buildYourOwnComputer();
        ProductPage.clickAddToCartButton();
        ShoppingCartPage ShoppingCartPage =	ProductPage.clickCartPageButton();

        String expectedProductName = "Build your own computer";
        String actualProductName = ShoppingCartPage.productName();
        Assert.assertTrue(actualProductName.contains(expectedProductName),"Incorrect Product name");

        String expectedProductSpecs = "RAM: 4GB [+$20.00]";

        String actualProductSpecs = ShoppingCartPage.productSpecifications();
        Assert.assertTrue(actualProductSpecs.contains(expectedProductSpecs),"Incorrect Product specifications");

        String expectedProductQuantity = "3";
        String actualProductQuantity = ShoppingCartPage.quantityNumber();
        Assert.assertTrue(actualProductQuantity.contains(expectedProductQuantity),"Incorrect Product quantity");

        String expectedProductPrice = "$1,435.00";
        String actualProductPrice = ShoppingCartPage.itemPrice();
        Assert.assertTrue(actualProductPrice.contains(expectedProductPrice),"Incorrect Product price");

        ShoppingCartPage.updateCartPage();
        String expectedProductsTotalPrice = "$4,305.00";
        String actualProductTotalPrice = ShoppingCartPage.totalPrice();
        Assert.assertTrue(actualProductTotalPrice.contains(expectedProductsTotalPrice),"Incorrect total price");
    }

}
