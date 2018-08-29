package com.socodd.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoggingController {


		private static final Logger logger = Logger.getLogger(LoggingController.class);

		@RequestMapping(value = "/logging", method = RequestMethod.GET)
		public ModelAndView getLogging() {

			//logs debug message
			if(logger.isDebugEnabled()){
				logger.debug("getLogging is executed!");
			}
			
	        logger.debug("This is a debug message");
	        logger.info("This is an info message");
	        logger.warn("This is a warn message");
	        logger.fatal("This is a fatal message");
			
			//logs exception
			logger.error("This is Error message", new Exception("Testing"));
	        
			ModelAndView model = new ModelAndView("blank/logging");
			model.addObject("msg", "Hello Spring MVC +++	 Log4j");
			return model;

		}

	}
