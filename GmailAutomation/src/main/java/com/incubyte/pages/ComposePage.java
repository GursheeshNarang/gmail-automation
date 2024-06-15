package com.incubyte.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.manager.SeleniumManager;

import java.time.Duration;
import java.util.List;

public class ComposePage {
    WebDriver driver;
    WebDriverWait wait;

    public ComposePage() {
        // Use Selenium Manager to get the path to the ChromeDriver binary
        String chromeDriverPath = SeleniumManager.getInstance().getDriverPath("chromedriver");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login() {
        driver.get("https://mail.google.com/");
        
        // Enter username
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId")));
        emailField.sendKeys("emaildemoincubyte@gmail.com");
        WebElement nextButton = driver.findElement(By.cssSelector("#identifierNext > div > button > span"));
        nextButton.click();
        
        // Enter password
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
        passwordField.sendKeys("demoPassword123");
        WebElement passwordNextButton = driver.findElement(By.id("passwordNext"));
        passwordNextButton.click();
        
        // Wait until the inbox is loaded
        wait.until(ExpectedConditions.titleContains("Inbox"));
    }

    public void openComposeWindow() {
        WebElement composeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Compose']")));
        composeButton.click();
    }

    public void enterSubject(String subject) {
        WebElement subjectField = wait.until(ExpectedConditions.elementToBeClickable(By.name("subjectbox")));
        subjectField.sendKeys(subject);
    }

    public void enterBody(String body) {
        WebElement bodyField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Message Body']")));
        bodyField.sendKeys(body);
    }

    public void enterRecipient() {
        WebElement toField = wait.until(ExpectedConditions.elementToBeClickable(By.name("to")));
        toField.sendKeys("gursheeshnarang2001@gmail.com");
    }

    public void clickSend() {
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Send']")));
        sendButton.click();
    }

    public void verifyEmailSent() {
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":b\"]/div/div/div[2]/span/span[1]")));
        if (confirmation.isDisplayed()) {
            System.out.println("Email sent confirmation displayed.");
        } else {
            throw new AssertionError("Email sent confirmation not displayed.");
        }
    }

    public void verifyEmailInSentItems(String subject) {
        WebElement sentItemsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sent")));
        sentItemsLink.click();
        
        List<WebElement> sentEmails = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='bog' and text()='" + subject + "']")));
        if (!sentEmails.isEmpty()) {
            System.out.println("Email found in Sent items.");
        } else {
            throw new AssertionError("Email not found in Sent items.");
        }
    }
}
