package utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest
{
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }
    public void mouseHover(By by)
    {
        Actions actions=new Actions(driver);
        WebElement hoverElement=driver.findElement(by);
        actions.moveToElement(hoverElement).build().perform();
    }
    public void verifyTheText(String expText, By by)
    {
        String actualMsg=getTextFromElement(by);
        Assert.assertEquals(expText,actualMsg);
    }
    public void sendTextToElement(By by,String txt)
    {
        driver.findElement(by).sendKeys(txt);
    }
    public void selectFromDropDown(By by, String text)
    {
        //WebElement dropDownValue= driver.findElement(by);
        //Select select=new Select(dropDownValue);
        //select.selectByVisibleText(txt);
        List<WebElement> allOptions= driver.findElements(by);
        for (WebElement option:allOptions)
        {
            if(option.getText().equalsIgnoreCase(text))
            {
                option.click();
            }
        }
    }
    public void listDropDown(By by, String text, By by1)

    {
        List<WebElement> itemList = driver.findElements(by);
        for (WebElement item : itemList) {
            if (item.getText().equalsIgnoreCase(text)) {
                System.out.println(item.getText());
                Assert.assertEquals("Verify", text, item.getText());
                clickOnElement(by1);
            }
        }
    }
}
