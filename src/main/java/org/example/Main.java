package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver dr = new ChromeDriver();
        dr.get("https://react-shopping-cart-67954.firebaseapp.com/");

        dr.manage().window().maximize();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement star = dr.findElement(By.xpath("//a[text()='Star']"));
        System.out.println(star.getText());

        WebElement text = dr.findElement(By.xpath("//main[@class='sc-ebmerl-4 iliWeY']/p"));
        System.out.println(text.getText());

        WebElement img = dr.findElement(By.xpath("//div[@class='sc-joc36b-1 kCrsLA']/img"));
        System.out.println(img.getAttribute("src"));

        WebElement linkUser = dr.findElement(By.xpath("//div[@class='sc-joc36b-3 jCptDE']/p/a"));
        System.out.println(linkUser.getAttribute("href"));

        WebElement header = dr.findElement(By.xpath("//h4[text()='Work in the Netherlands']"));
        System.out.println(header.getText());

        WebElement follow = dr.findElement(By.xpath("//b[text()='follow me on Linkedin.']"));
        System.out.println(follow.getText());

        WebElement title = dr.findElement(By.xpath("// div[@class='sc-joc36b-3 jCptDE']/p"));
        System.out.println(title.getText());

        List<WebElement> elements = dr.findElements(By.xpath("//span[@class='checkmark']"));
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(element.getText());
        }

        WebElement sizeXS = null;
        for (WebElement element : elements) {
            if (element.getText().equals("XS")) {
                sizeXS = element;
                break;
            }
        }

        sizeXS.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement btnAddToCart = dr.findElement(By.xpath("//button[@class='sc-124al1g-0 jCsgpZ']"));
        btnAddToCart.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement increase = dr.findElement(By.xpath("//button[text()='+']"));
        increase.click();
        System.out.println(increase.getText());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
        WebElement close = dr.findElement(By.xpath("//button[@class='sc-1h98xa9-0 gFkyvN']"));
        close.click();
        System.out.println(close.getText());
//
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sizeXS.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement sizeXXL = null;
        for (WebElement element : elements) {
            if (element.getText().equals("XXL")) {
                sizeXXL = element;
                break;
            }
        }

        sizeXXL.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement product1 = dr.findElement(By.xpath("//div[@class='sc-124al1g-2 dwOYCh']"));
        System.out.println(product1.getText());

        WebElement addToCart1 = dr.findElement(By.xpath("//div[@class='sc-124al1g-2 dwOYCh']/button"));
        addToCart1.click();

        WebElement AddToCart2 = dr.findElement(By.xpath("//div[@class='sc-124al1g-2 ekOVCH']/button"));
        AddToCart2.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement check = dr.findElement(By.xpath("//button[@class='sc-1h98xa9-11 gnXVNU']"));
        check.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alert = dr.switchTo().alert();
        alert.accept();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement del = dr.findElement(By.xpath("//button[@class='sc-11uohgb-5 gBQuHE']"));
        del.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement del1 = dr.findElement(By.xpath("//button[@class='sc-11uohgb-5 gBQuHE']"));
        del1.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement del2 = dr.findElement(By.xpath("//button[@class='sc-11uohgb-5 gBQuHE']"));
        del2.click();

        dr.quit();
    }
}