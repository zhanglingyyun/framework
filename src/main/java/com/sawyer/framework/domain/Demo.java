package com.sawyer.framework.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Demo
{
	private long id;

	private DemoInfo demoInfo;
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	private String content;
	
	@NotBlank
	private String name;

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public DemoInfo getDemoInfo()
	{
		return demoInfo;
	}

	public void setDemoInfo(DemoInfo demoInfo)
	{
		this.demoInfo = demoInfo;
	}
	
	

}
