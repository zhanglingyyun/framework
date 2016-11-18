package com.sawyer.framework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sawyer.framework.core.Configuration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationTest {

	@Autowired
	private Configuration configuration;
	
    @Test
    public void testConfig() throws Exception {
    	System.out.println(configuration.getAa());
    }
}