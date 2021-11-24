package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopMenuTest extends Utility
{
    public void selectMenu(String menu)
    {
        switch (menu)
        {
            case "Computers":
                openBrowser(url);
                clickOnElement(By.xpath("//a[contains(text(),'Computers')]"));
                verifyTheText("Computers",By.xpath("//a[contains(text(),'Computers')]"));
                break;
            case "Electronics":
                openBrowser(url);
                clickOnElement(By.xpath("//a[contains(text(),'Electronics')]"));
                verifyTheText("Electronics",By.xpath("//a[contains(text(),'Electronics')]"));

                break;
            case "Apparel":
                openBrowser(url);
                clickOnElement(By.xpath("//a[contains(text(),'Apparel')]"));
                verifyTheText("Apparel",By.xpath("//a[contains(text(),'Apparel')]"));

                break;
            case "Digital downloads":
                openBrowser(url);
                clickOnElement(By.xpath("//a[contains(text(),'Digital downloads')]"));
                verifyTheText("Digital downloads",By.xpath("//a[contains(text(),'Digital downloads')]"));

                break;
            case "Books":
                openBrowser(url);
                clickOnElement(By.xpath("//a[contains(text(),'Books')]"));
                verifyTheText("Books",By.xpath("//a[contains(text(),'Books')]"));

                break;
            case "Jewelry":
                openBrowser(url);
                clickOnElement(By.xpath("//a[contains(text(),'Jewelry')]"));
                verifyTheText("Jewelry",By.xpath("//a[contains(text(),'Jewelry')]"));

                break;
            case "Gift Cards":
                openBrowser(url);
                clickOnElement(By.xpath("//a[contains(text(),'Gift Cards')]"));
                verifyTheText("Gift Cards",By.xpath("//a[contains(text(),'Gift Cards')]"));
                break;
            default:
                System.out.println("Invalid entry....");
        }
    }
    @Test
    public void verifyPageNavigation() throws InterruptedException
    {
        ArrayList<String> array = new ArrayList<>();
        array.add("Computers");
        array.add("Electronics");
        array.add("Apparel");
        array.add("Digital downloads");
        array.add("Books");
        array.add("Jewelry");
        array.add("Gift Cards");
        for (String print : array)
        {
            selectMenu(print);
            Thread.sleep(4000);
        }
    }
    /*public void selectMenu(String menu)
    {

        for (WebElement option:items)
        {
            if(option.getText().equalsIgnoreCase(txt))
            {
                option.click();
            }
        }
    }*/
    /*@Test
    public void verifyPageNavigation()
    {
        ArrayList<String> array = new ArrayList<>();
        array.add("Computers");
        array.add("Electronics");
        array.add("Apparel");
        array.add("Digital downloads");
        array.add("Books");
        array.add("Jewelry");
        array.add("Gift Cards");
        for (String print : array)
        {
            openBrowser(url);
            selectMenu(By.xpath("//ul[@class='top-menu notmobile']/child::li"),print);
        }
    }*/

    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
