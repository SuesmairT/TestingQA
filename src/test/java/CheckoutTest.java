import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BaseTest{
    @Test
    public void successCheckout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnAddLightToCart();
        inventoryPage.clickOnAddTShirtToCart();
        inventoryPage.clickOnShoppingCartIcon();

        CartPage cartPage = new CartPage(driver);

        cartPage.clickOnCheckoutButton();

        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);

        checkoutStepOne.enterFirstName("Anna");
        checkoutStepOne.enterLastName("Smith");
        checkoutStepOne.enterPostalCode("44228");

        checkoutStepOne.clickToContinueButton();

        CheckoutStepTwo checkoutStepTwo = new CheckoutStepTwo(driver);
        checkoutStepTwo.clickToFinishButton();

        SucccheckoutCompleteessPage succcheckoutCompleteessPage = new SucccheckoutCompleteessPage(driver);
        assertEquals("Thank you for your order!", succcheckoutCompleteessPage.successCheckoutText());

        sleep(5000);
    }
}
