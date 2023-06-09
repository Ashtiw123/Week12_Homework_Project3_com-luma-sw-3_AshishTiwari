package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

//    /**
//     * This method will click on element
//     */
//    public void clickOnElement(By by) {
//        driver.findElement(by).click();
//    }
//
//    /**
//     * This method will send text to element
//     */
//    public void sendTextToElement(By by, String text) {
//        driver.findElement(by).sendKeys(text);
//    }
//
//    /**
//     * This method will get text from element
//     */
//    public String getTextFromElement(By by) {
//        return driver.findElement(by).getText();
//    }
//
//    public void selectByVisibleTextFromDropDown(By by, String text) {
//        WebElement dropDown = driver.findElement(by);
//        Select select = new Select(dropDown);
//        select.selectByVisibleText(text);
//        //Select by Value
//        // select.selectByValue("");
//        //Select by Index
//        // select.selectByIndex();
//    }
//
//    public void mouseHoverOnElement(By by) {
//        Actions actions = new Actions(driver);
//        WebElement xyz = driver.findElement(by);
//        actions.moveToElement(xyz).build().perform();
//    }

    public void dismiss() {
        dismiss();
    }

    public void alertDismiss() {
        clickOnElement(By.id("alertbtn"));//click on alert button
        Alert alert = driver.switchTo().alert();//Creating alert object reference and Switch to Alert
        System.out.println(alert.getText());
        alert.dismiss();
    }

    //******************************Click, get text, send text & verify text methods**********************************//

    //This method will click on element
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    //This method get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //This method will send to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method verify the expected text
    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText, actualText);
    }

    //*********************************************Alert methods******************************************************//

    //This method will switch to the alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //This method will accept the alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    //**********************************************Select class******************************************************//

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByIndexFromDropDown(By by, int a) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(a);
    }

    public void selectByGetAllOptionFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement element : allOptions
        ) {
            //System.out.println(element.getText());//to print all countries
            if (element.getText().equals(text)) {
                element.click();
            }
        }
    }

    //***********************************************Mouse Hover******************************************************//

    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).build().perform();
    }

    public void clickOnMouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).click().build().perform();
    }
    public void assertProduct(String expectedProduct,int index){
        String expectedProduct1 =expectedProduct;
        String actualProduct1 = getTextFromElement(By.xpath("(//ol//strong//a)["+index+"]"));
        Assert.assertEquals(expectedProduct1, actualProduct1);
    }
    public void assertPrice(String expectedProduct,int index){
        String expectedProduct1 =expectedProduct;
        String actualProduct1 = getTextFromElement(By.xpath("(//div[@class='products wrapper grid products-grid']//span[@class='price'])["+index+"]"));
        Assert.assertEquals(expectedProduct1, actualProduct1);
    }
}