package com.mor.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.mor.selenium.Main.driver;

public class FinishOrder {
    WebElement finish_btn = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]"));
    WebElement confirmationNumber = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]"));
    WebElement ponyImg;

    public String completeOrder(){
        String confirmNumber = confirmationNumber.getText();
        finish_btn.click();
        ponyImg = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/img"));
        if(ponyImg.isDisplayed()) {
            return confirmNumber;
        }else{
            return "-1";
        }
    }
}
