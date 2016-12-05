package com.spotify.ui.test;

import org.testng.annotations.Test;

import com.spotify.loginPage.LogInScenarioSpotify;
import com.spotify.searchPage.HelpPage;
import com.spotify.searchPage.PremiumPage;
import com.spotify.searchPage.Scenario;
import com.spotify.searchPage.SpotifyPlayPage;


public class SmokeTest extends BaseTest
{
	Scenario sce;
	PremiumPage prP;
	HelpPage hp;
	SpotifyPlayPage sp;
	LogInScenarioSpotify ls;
	@Test
	public void spotifyPageTest() throws Throwable{
		sce = new Scenario(driver);
		sp = sce.spoty();
		Thread.sleep(1000);
		sp.loginWithFacebook();
		//sp.run();	
	}
	@Test 
	public void loginPageTest() throws Throwable 
	{
	 	sce= new Scenario(driver);
		Thread.sleep(2000);		
		ls = sce.loginPage();
		ls.validInvalidLogin();		
	}
	@Test 
	public void helpPageTest() throws Throwable 
	{
		
	 	sce= new Scenario(driver);
	 	ls = sce.loginPage();
	 	ls.validLogin();
		Thread.sleep(2000);		
		hp= sce.search();	
		hp.searchProduct();
	}

	@Test 
	public void premiumPageTest() throws Exception
	{
		sce= new Scenario(driver);
		prP = sce.prem();
		Thread.sleep(2000);
		prP.verifyTitlePremiumPage();
	}
}
