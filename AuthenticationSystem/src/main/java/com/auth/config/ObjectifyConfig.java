package com.auth.config;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.auth.entities.User;
import com.googlecode.objectify.ObjectifyService;

public class ObjectifyConfig implements ServletContextListener{
	Logger log = Logger.getLogger("ObjectifyConfig");
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ObjectifyService.init();
        ObjectifyService.register(User.class);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
