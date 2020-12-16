package com.mor.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mor.selenium.Main.driver;

public class CartManagment {

    Map<Items, WebElement> allItems  = new HashMap<Items, WebElement>() {{
        put(Items.BACKPACK, driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")));
        put(Items.BIKE_LIGHT, driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")));
        put(Items.BOLT_T_SHIRT, driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button")));
        put(Items.JACKET, driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[3]/button")));
        put(Items.ONESIE, driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[5]/div[3]/button")));
        put(Items.RED_T_SHIRT, driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[3]/button")));
    }};

    public enum Items{
        BACKPACK,
        BIKE_LIGHT,
        BOLT_T_SHIRT,
        JACKET,
        ONESIE,
        RED_T_SHIRT;
    }
    public void addingItems(List<Items> selectedItems){
        selectedItems.forEach(item ->{
            allItems.get(item).click();
        });
    }
    public void removeItems(List<Items> selectedItems){
        selectedItems.forEach(item -> {
            allItems.get(item).click();
        });
    }
}
