package com.mor.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

import static com.mor.selenium.Main.driver;

public class Summary {
    WebElement checkOut_btn;
    WebElement firstName;
    WebElement lastName;
    WebElement zipCode;
    WebElement continue_btn;

    public void customerDetails (String fName, String lName, String zip){
        checkOut_btn = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]"));
        checkOut_btn.click();
        firstName = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        lastName = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        zipCode = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        continue_btn = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input"));
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        this.zipCode.sendKeys(zip);
        continue_btn.click();

    }
}
