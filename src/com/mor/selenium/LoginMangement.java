package com.mor.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.mor.selenium.Main.driver;

public class LoginMangement {
    WebElement username = driver.findElement(By.id("user-name"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement login = driver.findElement(By.id("login-button"));

    public Boolean login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
        try {
            //Checking home anchor label - validating that login succeed
            return driver.findElement(By.xpath("//*[text()='Products']")).isDisplayed();
        }catch (Exception e){
            System.out.println("login failed");
            return false;
        }
    }
}
