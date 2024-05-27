import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest{


        //log in

        //check that there are 6 items on yhe page
        @Test
        public void itemsTest(){
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterValueToUsername("standard_user");
            loginPage.enterValueToPasswordInputField("secret_sauce");
            loginPage.clickOnTheLoginButton();
            ///===============================

            InventoryPage inventoryPage = new InventoryPage(driver);
            assertTrue(inventoryPage.inventoryListIsDisplayed());
            assertEquals(6, inventoryPage.getItemQuantity());
            //все элементы отражаются
            assertTrue(inventoryPage.allItemsAreDisplayed());

            //check that all item names are displayed

            assertTrue(inventoryPage.allItemsNamesAreDisplayed());

            //all item names are NOT empty, что в названии не пустая строчка и есть символы
            assertTrue(inventoryPage.allItemNamesAreNotEmpty());


            //all items name starts with "Sauce Labs"
            assertTrue(inventoryPage.allItemNameStartsSauceLabs());



        }


    }



