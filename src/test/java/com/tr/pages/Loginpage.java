package com.tr.pages;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	WebDriver driver;
	WebElement element;
	By signin = By.xpath("//a[@class ='lft usersignin']");
	By username = By.xpath("//input[@id ='username_login']");
	By password = By.xpath("//input[@id ='passwd_temp']");
	By login = By.xpath("//input[@id ='button']");

	public Loginpage( WebDriver driver){
		this.driver = driver;
	}
	public Object clicklogin(String txtusername, String txtpassword) throws InterruptedException{
		element= driver.findElement(signin);
		element.click();
		Thread.sleep(3000);
		element = driver.findElement(username);
		element.click();
		element.sendKeys(txtusername);
		element = driver.findElement(password);
		//element.click();
		element.sendKeys(txtpassword);
		element = driver.findElement(login);
		element.click();
		return new DashboardPage(driver);
	}

}
