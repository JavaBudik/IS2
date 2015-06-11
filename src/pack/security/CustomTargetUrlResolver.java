package pack.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.ui.TargetUrlResolver;
import org.springframework.security.ui.savedrequest.SavedRequest;

public class CustomTargetUrlResolver implements TargetUrlResolver {
	private static final String ADMIN_ROLE_TARGET_URL = "/admin_view_users.htm";
	private static final String IMPORTER_ROLE_TARGET_URL = "/admin_view_users.htm";
	private static final String CUSTOMER_ROLE_TARGET_URL = "/customer_catalog.htm";
	private static final String AUDITOR_ROLE_TARGET_URL = "/registerAuditor.htm";
	private final TargetUrlResolver defaultSpringSecurityUrlResolver;
   
	public CustomTargetUrlResolver(
            final TargetUrlResolver fallbackTargetUrlResolver) {
        defaultSpringSecurityUrlResolver = fallbackTargetUrlResolver;
    }
	
	public String determineTargetUrl(SavedRequest savedRequest, HttpServletRequest currentRequest,
		Authentication auth) {
		if (containsAdminAuthority(auth)) {
	        return ADMIN_ROLE_TARGET_URL;
	    }
		if (containsImporterAuthority(auth)) {
	        return IMPORTER_ROLE_TARGET_URL;
	    }
		if (containsCustomerAuthority(auth)) {
	        return CUSTOMER_ROLE_TARGET_URL;
	    }
		
		if (containsAuditorAuthority(auth)) {
	        return AUDITOR_ROLE_TARGET_URL;
	    }

	    return defaultSpringSecurityUrlResolver.determineTargetUrl(
	            savedRequest, currentRequest, auth);
}

	private boolean containsAdminAuthority(Authentication auth) {
		 for (final GrantedAuthority grantedAuthority : auth.getAuthorities()) {
	            if (grantedAuthority.getAuthority().equals(
	                    "ADMIN_ROLE")) {
	                return true;
	            }
	        }
	        return false;
	}
	private boolean containsImporterAuthority(Authentication auth) {
		for (final GrantedAuthority grantedAuthority : auth.getAuthorities()) {
            if (grantedAuthority.getAuthority().equals(
                    "IMPORTER_ROLE")) {
                return true;
            }
        }
        return false;
	}
	private boolean containsCustomerAuthority(Authentication auth) {
		for (final GrantedAuthority grantedAuthority : auth.getAuthorities()) {
            if (grantedAuthority.getAuthority().equals(
                    "CUSTOMER_ROLE")) {
                return true;
            }
        }
        return false;
	}
	private boolean containsAuditorAuthority(Authentication auth) {
		for (final GrantedAuthority grantedAuthority : auth.getAuthorities()) {
            if (grantedAuthority.getAuthority().equals(
                    "AUDITOR_ROLE")) {
                return true;
            }
        }
        return false;
	}

}
