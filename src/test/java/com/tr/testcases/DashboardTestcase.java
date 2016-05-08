package com.tr.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tr.pages.DashboardPage;
import com.tr.pages.Loginpage;

public class DashboardTestcase {
// ******************* Declaration Area Begins ***********************************************	
		WebDriver driver;
		WebElement element;
		String url = "http://www.monsterindia.com/"; 
		
		int wait = 30;
		String pagetitle = null;
		String expectedpagetitle = "Monster - Find Jobs with Monsterindia.com. Submit Resume on Monster";
		String expectedusername = "Satish B M";
		String username = null;
		boolean flag = false;
// *********************creating object for the class *****************************************		
		DashboardPage objMyDashboard = null;
		Loginpage objlogin = null;
//********************** Declaration Area ends *************************************************
		// setup class
@BeforeTest
		
		public void setup(){
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
			driver.manage().window().maximize();	
			
			
		}
@Test
		public void verifypage() throws Exception{
			objlogin = new Loginpage(driver);
			objlogin.clicklogin("Satish.muniyappa@gmail.com","Nov17@2008");
			objMyDashboard = new DashboardPage(driver);
			pagetitle = objMyDashboard.pagetitle();
			if (pagetitle.contains(expectedpagetitle)){
				flag = true;
				System.out.println(pagetitle);
			} 
			Assert.assertTrue(flag, "Page Title is not matching the expected");
			Thread.sleep(30000);
			username = objMyDashboard.username();
			if (username.equals(expectedusername)){
				flag = true;
				System.out.println(username);
			}
			Assert.assertTrue(flag, "Username is not matching the expected");
			List<WebElement> tablist = objMyDashboard.jobstab();
			int count = tablist.size();
			for (int i= 0; i<count; i++){
				element = tablist.get(i);
				String tabname = element.getText();
				System.out.println(tabname);
			}
			
		}
		
@AfterTest
		public void teardown(){
		driver.quit();
}	

}
