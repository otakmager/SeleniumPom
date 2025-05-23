package utils;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch {

    public String getPageTitle() {
        return BaseTest.driver.getTitle();
    }

    public WebElement getWebElement(String identifierType, String identifierValue) {
        return switch (identifierType) {
            case "XPATH" -> BaseTest.driver.findElement(By.xpath(identifierValue));
            case "CSS" -> BaseTest.driver.findElement(By.cssSelector(identifierValue));
            case "ID" -> BaseTest.driver.findElement(By.id(identifierValue));
            case "NAME" -> BaseTest.driver.findElement(By.name(identifierValue));
            case "CLASS" -> BaseTest.driver.findElement(By.className(identifierValue));
            case "LINK" -> BaseTest.driver.findElement(By.linkText(identifierValue));
            case "TAGNAME" -> BaseTest.driver.findElement(By.tagName(identifierValue));
            default -> null;
        };
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        return switch (identifierType) {
            case "XPATH" -> BaseTest.driver.findElements(By.xpath(identifierValue));
            case "CSS" -> BaseTest.driver.findElements(By.cssSelector(identifierValue));
            case "ID" -> BaseTest.driver.findElements(By.id(identifierValue));
            case "NAME" -> BaseTest.driver.findElements(By.name(identifierValue));
            case "CLASS" -> BaseTest.driver.findElements(By.className(identifierValue));
            case "LINK" -> BaseTest.driver.findElements(By.linkText(identifierValue));
            case "TAGNAME" -> BaseTest.driver.findElements(By.tagName(identifierValue));
            default -> null;
        };
    }

}
