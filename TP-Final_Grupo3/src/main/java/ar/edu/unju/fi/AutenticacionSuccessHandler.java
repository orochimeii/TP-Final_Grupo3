package ar.edu.unju.fi;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Component
public class AutenticacionSuccessHandler implements AuthenticationSuccessHandler {
	
	private static final Log LOGGER = LogFactory.getLog(AutenticacionSuccessHandler.class);

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		boolean tipoAdmin = false;
		boolean tipoEmpleador = false;
		boolean tipoCiudadano = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ADMIN")) {
				tipoAdmin = true;
				break;
			} else {
				if (grantedAuthority.getAuthority().equals("EMPLEADOR")) {
					tipoEmpleador = true;
					break;
				} else {
					tipoCiudadano = true;
					break;
				}
			}
		}
		if (tipoAdmin) {
			redirectStrategy.sendRedirect(request, response, "/inicio");
			LOGGER.info(response);
		} else {
			if (tipoEmpleador) {
				if (!(authentication instanceof AnonymousAuthenticationToken)) {
				    Collection<? extends GrantedAuthority> currentUserName = authentication.getAuthorities();
				    for(GrantedAuthority c: currentUserName) {
				    LOGGER.info(c);
				    }
				}
				redirectStrategy.sendRedirect(request, response, "/ofertas");
		} else {
			if (tipoCiudadano) {
				if (!(authentication instanceof AnonymousAuthenticationToken)) {
				    Collection<? extends GrantedAuthority> currentUserName = authentication.getAuthorities();
				    for(GrantedAuthority c: currentUserName) {
				    LOGGER.info(c);
				    }
				}
				redirectStrategy.sendRedirect(request, response, "/inicio");
			} else {
				throw new IllegalStateException();	
			}
		}			
		}

	}

}
