package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class TopMenuTest extends Utility
{
    @Before
    public void setUp()
    {
        openBrowser(url);
    }
    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully()
    {
        clickOnElement(By.linkText("Shipping"));
        verifyTheText("Shipping",By.xpath("//h1[contains(text(),'Shipping')]"));
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully()
    {
        clickOnElement(By.linkText("New!"));
        verifyTheText("New arrivals",By.xpath("//h1[@id='page-title']"));
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully()
    {
        clickOnElement(By.linkText("Coming soon"));
        verifyTheText("Coming soon",By.xpath("//h1[@class='title']"));
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully()
    {
        clickOnElement(By.linkText("Contact us"));
        verifyTheText("Contact us",By.xpath("//h1[contains(text(),'Contact us')]"));
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
