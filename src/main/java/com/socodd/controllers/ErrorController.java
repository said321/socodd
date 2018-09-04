package com.socodd.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@RequestMapping(value = "/errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
         
        ModelAndView errorPage = new ModelAndView("error/errorPage");
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);
 
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            }
        }
        errorPage.addObject("errorMsg", errorMsg);
        errorPage.addObject("errorCode", httpErrorCode);
        
        return errorPage;
    }
     
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
          .getAttribute("javax.servlet.error.status_code");
    }
    
    @RequestMapping(value = "500Error", method = RequestMethod.GET)
    public void throwRuntimeException() {
        throw new NullPointerException("Throwing a null pointer exception");
    }
    
    
  //for 403 access denied page
  	@RequestMapping(value = "/403", method = RequestMethod.GET)
  	public ModelAndView accesssDenied() {

  	  ModelAndView model = new ModelAndView();
  		
  	  //check if user is login
  	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  	  if (!(auth instanceof AnonymousAuthenticationToken)) {
  		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
  		model.addObject("username", userDetail.getUsername());
  	  }
  		
  	  model.setViewName("403");
  	  return model;

  	}

    
    
}
