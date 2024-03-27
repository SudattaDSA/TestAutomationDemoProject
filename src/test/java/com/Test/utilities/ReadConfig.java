package com.Test.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationUrl() {
		String URL = pro.getProperty("baseURL");
		return URL;
	}
	public String getUsername() {
		String Username = pro.getProperty("username");
		return Username;
	}
	public String getPassword() {
		String Password = pro.getProperty("password");
		return Password;
	}
	public String getChromeDriverPath() {
		String chromeDriverPath = pro.getProperty("chromeDriverPath");
		return chromeDriverPath;
	}
	public String getGeckoDriverPath() {
		String GeckoDriverPath = pro.getProperty("geckoDriverPath");
		return GeckoDriverPath;
	}
	public String getEdgeDriverPath() {
		String EdgeDriverPath = pro.getProperty("edgeDriverPath");
		return EdgeDriverPath;
	}
}
