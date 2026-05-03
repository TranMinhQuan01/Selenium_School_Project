package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;


public class Test {
   static ChromeDriver dr;
   static WebDriverWait wait;
    public static void main(String[] args) {
       setup();

       loadpage();
       addtocart();
       removeitems();
       verifytotalprice();

       shutdown();
    }
    public static void setup() {
       dr = new ChromeDriver();
       dr.get("https://react-shopping-cart-67954.firebaseapp.com/");
       dr.manage().window().maximize();
       wait = new WebDriverWait(dr, Duration.ofSeconds(10));
    }
    public static void loadpage() {
       //Flow check products
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-uhudcz-0 iZZGui']")));
       WebElement ProductsList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main[@class='sc-ebmerl-4 iliWeY']/p")));
       try {
          wait.until(webDriver -> {
             String text = ProductsList.getText();
             int number = Integer.parseInt(text.split(" ")[0]);
             return number > 0;
          });
          System.out.println("Pass: Có sản phẩm");
       } catch (Exception e) {
          System.out.println("Fail: Không có sản phẩm");
       }
    }
    public static void addtocart() {
       //Flow add product and verify product in pocked
       WebElement AddToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sc-124al1g-2 dwOYCh']/button")));
       AddToCart.click();

       WebElement NumberOfProducts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-1h98xa9-2 fMfPui']")));
       try {
          wait.until(webDriver -> {
             String text = NumberOfProducts.getText();
             int number = Integer.parseInt(text);
             return number > 0;
          });
          System.out.println("Pass: Có sản phẩm trong giỏ hàng");
       } catch (Exception e) {
          System.out.println("Fail: Không có sản phẩm trong giỏ hàng");
       }
    }
    public static void removeitems() {
       //Flow remove item
       WebElement RemoveItems = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sc-11uohgb-0 hDmOrM']/button")));
       RemoveItems.click();
       WebElement VerifyRemove = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-1h98xa9-3 VLMSP']")));
       try {
          wait.until(webDriver -> {
             int number = Integer.parseInt(VerifyRemove.getText());
             return number == 0;
          });
          System.out.println("Pass: Sản phẩm không còn trong giỏ hàng");
       } catch (Exception e) {
          System.out.println("Fail: Sản phẩm còn trong giỏ hàng");
       }
    }
    public static void verifytotalprice() {
       //Add 2 items
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-uhudcz-0 iZZGui']")));
       WebElement Sp1 = dr.findElement(By.xpath("//div[@class='sc-124al1g-2 dwOYCh']/button"));
       Sp1.click();
       WebElement Sp2 = dr.findElement(By.xpath("//div[@class='sc-124al1g-2 bCLaRj']/button"));
       Sp2.click();
       //Print 2 prices
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-1h98xa9-4 hzlwTK']")));
       List<WebElement> prices = dr.findElements(By.xpath("//div[@class='sc-11uohgb-4 bnZqjD']/p"));
       for (WebElement price: prices){
          System.out.println(price.getText());
       }
       //Total prices
       double total = 0;
       for (WebElement price : prices){
          String text = price.getText();
          text = text.replace("$","").trim();
          double value = Double.parseDouble(text); total += value;
       } System.out.println("$ " + total);
       //Checkout
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-1h98xa9-8 bciIxg']/p")));
       WebElement Checkout = dr.findElement(By.xpath("//button[@class='sc-1h98xa9-11 gnXVNU']"));
       Checkout.click();
       Alert alert = wait.until(ExpectedConditions.alertIsPresent());
       alert.accept();
    }

    public static void shutdown(){
       dr.quit();
    }
}
