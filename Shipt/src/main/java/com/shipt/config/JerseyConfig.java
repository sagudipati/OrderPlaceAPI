package com.shipt.config;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.shipt.controller.OrderResource;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig()
    {
        register(OrderResource.class);
       // System.out.println("Im here");
    }

}
