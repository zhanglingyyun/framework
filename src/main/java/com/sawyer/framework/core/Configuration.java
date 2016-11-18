package com.sawyer.framework.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config", locations = "classpath:config/config.properties")
public class Configuration
{
	private String aa;
	private String bb;

	public String getAa()
	{
		return aa;
	}

	public void setAa(String aa)
	{
		this.aa = aa;
	}

	public String getBb()
	{
		return bb;
	}

	public void setBb(String bb)
	{
		this.bb = bb;
	}

}
