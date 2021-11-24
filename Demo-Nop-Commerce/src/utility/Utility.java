package utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

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
    public void verifyTheText(String expText,By by)
    {
        String actualMsg=getTextFromElement(by);
        Assert.assertEquals(expText,actualMsg);
    }
    public void sendTextToElement(By by,String txt)
    {
        driver.findElement(by).sendKeys(txt);
        Random random=new Random();
        int randomInt=random.nextInt(100);
        //emailTxt.sendKeys("Dimple"+randomInt+"@yahoo.com");
    }
    public void selectFromDropDown(By by,String txt)
    {
        List<WebElement> items= driver.findElements(by);
        for (WebElement option:items)
        {
            if(option.getText().equalsIgnoreCase(txt))
            {
                option.click();
            }
        }
    }

    public void selectFromDropDownUsingSelectClass(By by, String text)
    {
        WebElement dropDown= driver.findElement(by);
        Select select=new Select(dropDown);
        List <WebElement> elements=select.getOptions();
        for (WebElement item:elements)
        {
            System.out.println(item.getText());
            if(item.getText().equalsIgnoreCase(text))
            {
                select.selectByVisibleText(text);
                item.click();
            }
        }
    }
}
