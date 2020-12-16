package com.mor.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static WebDriver driver = null;

    public static void main(String[] args) {


        List<User> users = new ArrayList<>();
        users.add(new User("standard_user","secret_sauce"));
        users.add(new User("problem_user","secret_sauce"));
        users.add(new User("locked_out_user","secret_sauce"));
        users.add(new User("performance_glitch_user","secret_sauce"));

        users.forEach(user -> {
            initWebDriver();
            //Validate login
            if(new LoginMangement().login(user.getUsername(), user.getPassword())) {

                new CartManagment().addingItems(List.of(
                        CartManagment.Items.ONESIE,
                        CartManagment.Items.BIKE_LIGHT,
                        CartManagment.Items.BOLT_T_SHIRT,
                        CartManagment.Items.BACKPACK));
                //remove osesie from the cart
                new CartManagment().removeItems(List.of(CartManagment.Items.ONESIE));

                //go to summery and enter customer details
                WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
                cart.click();
                new Summary().customerDetails("Mor", "Aroesti", "49559");
                String finishStatus = new FinishOrder().completeOrder();
                if (!finishStatus.equals("-1")) {
                    System.out.println("Order completed for user: " + user.getUsername() +
                            " with the confirmation number: " + finishStatus);
                }
            }else{
                System.out.println("Login failed");
            }
            driver.close();
        });







    }

    private static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
    }
}
