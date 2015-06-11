package pack.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.Authentication;
import org.springframework.security.AuthenticationException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.security.ui.savedrequest.SavedRequest;
import org.springframework.security.ui.webapp.AuthenticationProcessingFilter;

public class CustomAuthenticationProcessingFilter 
    extends AuthenticationProcessingFilter {	

	    @Override
	    protected String determineTargetUrl(HttpServletRequest request) {
	    	//final Authentication authentication = SecurityContextHolder                                       
            //.getContext().getAuthentication();   
	    	String targetUrl="/register.htm";
	    	GrantedAuthority[] authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();                                       
            //.getContext().getAuthentication()
	    	System.out.println("!!!!!!!!!");
    //if (authentication == null)                                                                       
        //return super.determineTargetUrl(request);
    
    //final GrantedAuthority[] authorities = authentication.getAuthorities();                           
    for (GrantedAuthority authority : authorities) {                                            
        if ("ROLE_ADMIN".equals(authority.toString())) {
        	targetUrl = "/admin_view_new_users.htm";
        	break;
        }
        if ("ROLE_LOW".equals(authority.toString())) {
        	targetUrl = "/start_page.htm";
        	break;
        }  
        else targetUrl = "/start_page.htm";
        System.out.println("!!!!!!!!!"+authority.toString());        
   }
	return targetUrl;  
	}  
   @Override
   protected String determineFailureUrl(HttpServletRequest request, AuthenticationException failed) {
	return "/loginError.jsp";	   
   }
}
