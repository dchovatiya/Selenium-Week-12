package electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

import java.time.Duration;
import java.util.Random;

public class ElectronicsTest extends Utility
{
    @Before
    public void SetUp()
    {
        openBrowser(url);

    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    {
        //Cell phones
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        mouseHover(By.linkText("Cell phones"));
        clickOnElement(By.xpath("//a[contains(text(),'Cell phones ')]/parent::li"));
        verifyTheText("Cell phones",By.xpath("//h1[normalize-space()='Cell phones']"));
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //Cell phones
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        mouseHover(By.linkText("Cell phones"));
        clickOnElement(By.xpath("//a[contains(text(),'Cell phones')]/parent::li"));
        verifyTheText("Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));
        clickOnElement(By.xpath("//a[normalize-space()='List']"));

        //Nokia lumia
        Thread.sleep(5000);
        //clickOnElement(By.linkText("Nokia Lumia 1020"));
        //clickOnElement(By.xpath("//img[@alt='Picture of Nokia Lumia 1020']/parent::a"));
        //clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]/ancestor::div"));
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]/parent::h2/ancestor::div"));
        //clickOnElement(By.linkText("Nokia Lumia 1020"));
       //verifyTheText("Nokia Lumia 1020",By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]/parent::div[@class='product-name']/ancestor::div[@class='overview']"));
        //verifyTheText("Nokia Lumia 1020",By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]/parent::div[@class='product-name']"));
        verifyTheText("Nokia Lumia 1020",By.xpath("//h1[normalize-space()='Nokia Lumia 1020']/ancestor::div"));
        verifyTheText("$349.00",By.id("price-value-20"));
        sendTextToElement(By.id("product_enteredQuantity_20"),"2");
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        verifyTheText("The product has been added to your shopping cart", By.xpath("//a[normalize-space()='shopping cart']/parent::p"));
        clickOnElement(By.xpath("//span[@title='Close']"));

        Thread.sleep(5000);
        mouseHover(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        verifyTheText("Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]/ancestor::div"));
        verifyTheText("2",By.id("itemquantity11227"));
        //verifyTheText("2",By.xpath("//input[@id='itemquantity11227']"));
        verifyTheText("$698.00",By.xpath("//span[@class='product-subtotal']/parent::td"));


        Thread.sleep(5000);
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        verifyTheText("Welcome, Please Sign In!",By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']/ancestor::div"));
        clickOnElement(By.className("button-1 register-button"));
        verifyTheText("Register",By.xpath("//h1[normalize-space()='Register']/ancestor::div"));


        //Filling the form
        clickOnElement(By.id("gender-female"));
        sendTextToElement(By.id("FirstName"),"ABCD");
        sendTextToElement(By.id("LastName"),"Patel");
        selectFromDropDownUsingSelectClass(By.name("DateOfBirthDay"),"01");
        selectFromDropDownUsingSelectClass(By.name("DateOfBirthMonth"),"01");
        selectFromDropDownUsingSelectClass(By.name("DateOfBirthYear"),"1985");
        sendTextToElement(By.id("Email"),"abcd123@yahoo.com");
        sendTextToElement(By.name("Company"),"Prime Testing");
        clickOnElement(By.name("Newsletter"));
        sendTextToElement(By.id("Password"),"**********");
        sendTextToElement(By.id("ConfirmPassword"),"**********");
        clickOnElement(By.id("register-button"));
        verifyTheText("Your registration completed",By.xpath("//div[@class='result']"));
        clickOnElement(By.xpath("//a[normalize-space()='Continue']/parent::div"));
        verifyTheText("Shopping cart",By.xpath("//h1[normalize-space()='Shopping cart']/ancestor::div"));
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));

        //Filling the form
        Thread.sleep(5000);
        sendTextToElement(By.id("FirstName"),"ABCDEF");
        sendTextToElement(By.id("LastName"),"Patel");
        sendTextToElement(By.id("BillingNewAddress_Email"),"abcd123@yahoo.com");
        sendTextToElement(By.id("BillingNewAddress_Company"),"Prime Testing");
        selectFromDropDownUsingSelectClass(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        selectFromDropDownUsingSelectClass(By.id("BillingNewAddress_StateProvinceId"),"Other");
        sendTextToElement(By.id("BillingNewAddress_City"),"London");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"abcd");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"00111");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"1234567890");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']/parent::div"));

        //Radio button
        clickOnElement(By.id("shippingoption_2"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //Radio button of credit card
        clickOnElement(By.xpath("//label[normalize-space()='Credit Card']"));

        //Filling details of visa credit card
        Thread.sleep(5000);
        selectFromDropDownUsingSelectClass(By.id("CreditCardType"),"Visa");
        sendTextToElement(By.id("CardholderName"),"Karley Ledner");
        sendTextToElement(By.id("CardNumber"),"4716042186127287");
        selectFromDropDownUsingSelectClass(By.id("ExpireMonth"),"03");
        selectFromDropDownUsingSelectClass(By.id("ExpireYear"),"2024");
        sendTextToElement(By.name("CardCode"),"912");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //Verifying the texts
        Thread.sleep(5000);
        verifyTheText("Payment Method: Credit Card",(By.xpath("//span[normalize-space()='Credit Card']")));
        verifyTheText("Shipping Method: 2nd Day Air",(By.xpath("//span[normalize-space()='2nd Day Air']")));
        verifyTheText("$698.00",(By.xpath("//span[@class='product-subtotal']")));
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //Verifying the texts
        Thread.sleep(5000);
        verifyTheText("Thank you",By.xpath("//h1[normalize-space()='Thank you']"));
        verifyTheText("Your order has been successfully processed!",By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        verifyTheText("Welcome to our store",By.xpath("//h2[normalize-space()='Welcome to our store']"));
        clickOnElement(By.className("ico-logout"));
        verifyTheText("https://demo.nopcommerce.com/",By.linkText("https://demo.nopcommerce.com/"));
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }
}


