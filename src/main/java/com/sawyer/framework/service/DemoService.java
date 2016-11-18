package com.sawyer.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawyer.framework.domain.Demo;
import com.sawyer.framework.mapper.DemoMappper;

@Service
public class DemoService
{
	@Autowired
	private DemoMappper demoMappper;

	public List<Demo> likeName(String name)
	{
		return demoMappper.likeName(name);
	}
}