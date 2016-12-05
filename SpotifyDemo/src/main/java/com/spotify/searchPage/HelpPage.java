package com.spotify.searchPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spotify.utils.Utils;

public class HelpPage 
{

	 WebDriver driver;
	
	public HelpPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("h444");
	}

	Utils	util;
	Logger	log	= Logger.getLogger(HelpPage.class);
	
	
	@FindBy(xpath = "//input[@id='search']")
	WebElement	searchBox;
	
	@FindBy(xpath = "//div[@class='list-article navigation-list']/h2")
	WebElement	searchingVerification;
	
	public void searchProduct() throws IOException, Exception
	{
		util = new Utils(driver);
		util.waitForElement(2000);
		
		util.handleElement(searchBox).sendKeys("free spotify");
		
		log.info("Entered free spotify on the Search box");
		util.waitForElement(3000);
		
		util.handleElement(searchBox).sendKeys(Keys.ENTER);
		
		log.info("Clicked on the search button");
		
		util.verify(searchingVerification);
		
		
		
	}
	

}
