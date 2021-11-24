package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

import javax.swing.*;
import java.util.List;

public class TestSuite extends Utility
{
    @Before
    public void setUp()
    {
        openBrowser(url);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder()
    {
        clickOnElement(By.linkText("Computers"));
        clickOnElement(By.linkText("Desktops"));
        selectFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");

        //verifyTheText();
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.linkText("Computers"));
        clickOnElement(By.linkText("Desktops"));
        selectFromDropDownUsingSelectClass(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //clickOnElement(By.linkText("Build your own computer"));
        clickOnElement(By.id("add-to-cart-button-1"));

        Thread.sleep(5000);
        verifyTheText("Build your own computer",By.xpath("//h1[normalize-space()='Build your own computer']"));
        selectFromDropDown(By.xpath("//select[@id='product_attribute_1']"),"2.2 GHz Intel Pentium Dual-Core E2200");
        selectFromDropDownUsingSelectClass(By.id("product_attribute_2"),"8GB [+$60.00]");
        clickOnElement(By.xpath("(//label[normalize-space()='400 GB [+$100.00]'])[1]"));
        clickOnElement(By.xpath("(//label[normalize-space()='Vista Premium [+$60.00]'])[1]"));
        clickOnElement(By.xpath("(//label[normalize-space()='Microsoft Office [+$50.00]'])[1]"));
        clickOnElement(By.xpath("(//label[normalize-space()='Total Commander [+$5.00]'])[1]"));
        verifyTheText("$1,475.00",By.xpath("//span[@id='price-value-1']"));
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        Thread.sleep(5000);
        verifyTheText("The product has been added to your shopping cart",By.xpath("//p[@class]='content']"));
        clickOnElement(By.xpath("//span[@title='Close']"));
        mouseHover(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        verifyTheText("Shopping cart",By.xpath("//h1[normalize-space()='Shopping cart']"));
        sendTextToElement(By.xpath("//input[@id='itemquantity11217']"),"2");
        clickOnElement(By.xpath("//button[normalize-space()='Update shopping cart']"));

        Thread.sleep(4000);
        verifyTheText("$2,950.00",By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,870.00')]"));
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));
        verifyTheText("Welcome, Please Sign In!",By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        //Filling the form
        Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Abc123@yahoo.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"Abc123@yahoo.com");
        selectFromDropDownUsingSelectClass(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Harrow");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"12456378");
        sendTextToElement(By.xpath("BillingNewAddress_PhoneNumber"),"12456378");
        sendTextToElement(By.xpath("BillingNewAddress_PhoneNumber"),"12456378");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //Radio Button
        Thread.sleep(5000);
        clickOnElement(By.xpath("//label[normalize-space()='Next Day Air ($0.00)']"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']//p[@class='back-link']//a[@href='#']"));
        clickOnElement(By.xpath("//label[normalize-space()='Credit Card']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //Selecting master card and filling the details
        Thread.sleep(5000);
        selectFromDropDownUsingSelectClass(By.id("CreditCardType"),"Master card");
        sendTextToElement(By.id("CardholderName"),"Ricky Streich");
        sendTextToElement(By.id("CardNumber"),"4883342685779068");
        selectFromDropDownUsingSelectClass(By.id("ExpireMonth"),"01");
        selectFromDropDownUsingSelectClass(By.id("ExpireYear"),"2025");
        sendTextToElement(By.name("CardCode"),"864");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //Verifying the texts
        Thread.sleep(5000);
        verifyTheText("Payment Method: Credit Card",(By.xpath("//span[normalize-space()='Credit Card']")));
        verifyTheText("Shipping Method: Next Day Air",(By.xpath("//li[@class='shipping-method']")));
        verifyTheText("$2,950.00",(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]")));
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        verifyTheText("Thank you",By.xpath("//h1[normalize-space()='Thank you']"));
        verifyTheText("Your order has been successfully processed!",By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        verifyTheText("Welcome to our store",By.xpath("//h2[normalize-space()='Welcome to our store']"));
    }
    @After
    public void tearDown ()
    {
       closeBrowser();
    }
}



