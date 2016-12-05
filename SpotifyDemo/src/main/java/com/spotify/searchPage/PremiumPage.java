package com.spotify.searchPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.spotify.utils.Utils;



public class PremiumPage 
{
	WebDriver driver;

	public PremiumPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("Elements initialized");
		System.out.println("ppppppp");
	}

	Utils util	= new Utils(driver);
	Logger	log		= Logger.getLogger(PremiumPage.class);

	public void verifyTitlePremiumPage() throws Exception
	{
		
		util = new Utils(driver);
		util.waitForElement(3000);
		try
		{
			driver.getTitle().contains("Go");
			
			System.out.println("Title verified");
			
		}catch(Exception e ){
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
}
