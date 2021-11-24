package shopping;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

import java.util.List;

public class ShoppingTest extends Utility
{
    @Before
    public void setUp()
    {
        openBrowser(url);

    }
    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHover(By.linkText("Sale"));
        clickOnElement(By.linkText("Sale"));
        verifyTheText("Sale",By.xpath("//h1[contains(text(),'Sale')]"));

        Thread.sleep(5000);
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        selectFromDropDown(By.xpath("//span[@class='sort-by-value']"),"Name A-Z");
        //mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        //selectFromDropDown(By.xpath("//span[@class='sort-by-label']"));

        //Product procedure
        //mouseHover(By.xpath("//a[@class='product-thumbnail next-previous-assigned']"));
        //clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-16']//span[contains(text(),'Add to cart')]//a[contains(text(),'Avengers: Fabrikations Plush [Related Products]')]"));
        //clickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]/ancestor::div"));
        //clickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]"));
        //clickOnElement(By.linkText("Avengers: Fabrikations Plush [Related Products]"));
        //Product procedure
        //clickOnElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[2]/div[4]/div[1]/button[1]/span[1]"));
        //verifyTheText("Product has been added to your cart",By.xpath("//div[@id='status-messages']//ul"));
        //clickOnElement(By.xpath("//a[contains(@class,'close')]"));
        clickOnElement(By.linkText("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        //clickOnElement(By.xpath("//a[@class='regular-button cart']/parent::div"));

        Thread.sleep(5000);
        verifyTheText("Your shopping cart - 1 item",By.xpath("//h1[contains(@id,'page-title')]"));
        sendTextToElement(By.xpath("//input[@id='amount16']"),"2");
        verifyTheText("Your shopping cart - 2 item",By.xpath("//h1[contains(@id,'page-title')]"));

        //Verify the total (expected 39.98,real=29.98)
        verifyTheText("39.98",By.xpath("//span[starts-with(text(),'29')]"));

        //Verify the total (expected 46.18,real=37.03)
        verifyTheText("46.18",By.xpath("//span[starts-with(text(),'37')]"));
        clickOnElement(By.xpath("//span[normalize-space()='Go to checkout']"));

        //Verifty login to your account
        Thread.sleep(5000);
        verifyTheText("Log in to your account",(By.xpath("//h1[contains(@id,'page-title')]")));
        sendTextToElement(By.id("email"),"dchovatiya@yahoo.com");
        clickOnElement(By.xpath("//span[contains(text(),'Continue')]"));
        verifyTheText("Secure Checkout",By.xpath("//h1[contains(@id,'page-title')]"));

        //Filling the form
        Thread.sleep(5000);
        sendTextToElement(By.id("shippingaddress-firstname"),"ABC");
        sendTextToElement(By.id("shippingaddress-lastname"),"Patel");
        sendTextToElement(By.id("shippingaddress-street"),"Unknown");
        sendTextToElement(By.id("shippingaddress-city"),"Unknown");

        Thread.sleep(5000);
        WebElement dropBtn=driver.findElement(By.id("shippingaddress-country-code"));
        Select select=new Select(dropBtn);
        select.selectByValue("GB");
        List <WebElement>allOptions= select.getOptions();
        System.out.println(allOptions.size());
        for (WebElement option:allOptions)
        {
            System.out.println(option.getText());
            if(option.getText().equalsIgnoreCase("United Kingdom"))
            {
                option.click();
            }
        }
        Thread.sleep(5000);
        sendTextToElement(By.id("shippingaddress-custom-state"),"Unknown");
        sendTextToElement(By.id("shippingaddress-zipcode"),"unknown");
        sendTextToElement(By.name("email"),"abc123@yahoo.com");
        clickOnElement(By.className("subbox create checkbox"));
        sendTextToElement(By.id("password"),"abc1234");

        Thread.sleep(5000);
        clickOnElement(By.className("rate-title"));
        clickOnElement(By.className("payment-title"));
        verifyTheText("$47.22",(By.xpath("part-integer")));
        clickOnElement(By.xpath("//span[normalize-space()='Place order: $37.03']"));
        verifyTheText("Thank you for your order",By.xpath(""));
        //clickOnElement(By.xpath("//h1[@class='fn title']"));
        //clickOnElement(By.xpath("//h1[@class='fn title']"));
        //clickOnElement(By.xpath("//a[contains(text(),'Avengers: Fabrikations Plush [Related Products')]"));
        //clickOnElement(By.className("add-to-cart-button"));
        //clickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]"));
        //String actualMessage=getTextFromElement(By.className("info"));
        //verifyTheText("Product has been added to your cart",actualMessage);*/
    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHover(By.linkText("Bestsellers"));
        clickOnElement(By.linkText("Bestsellers"));
        verifyTheText("Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        selectFromDropDown(By.xpath("//span[@class='sort-by-label']"), "Name A-Z");

        Thread.sleep(4000);
        clickOnElement(By.xpath("//a[normalize-space()='Vinyl Idolz: Ghostbusters']"));
        clickOnElement(By.xpath("//button[contains(@type,'submit')]//span[contains(text(),'Add to cart')]"));
        verifyTheText("Product has been added to your cart",By.xpath("//div[@id='status-messages']//ul"));
        clickOnElement(By.xpath("//a[@title='Close']"));

        Thread.sleep(4000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));
        verifyTheText("Your shopping cart - 1 item",By.xpath("//h1[@id='page-title']"));

        Thread.sleep(4000);
        clickOnElement(By.xpath("//a[normalize-space()='Empty your cart']"));

        Thread.sleep(4000);
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        Thread.sleep(4000);
        verifyTheText("Item(s) deleted from your cart",(By.xpath("//div[@id='status-messages']//ul")));
        verifyTheText("Your cart is empty",By.xpath("//h1[@id='page-title']"));
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }

}
