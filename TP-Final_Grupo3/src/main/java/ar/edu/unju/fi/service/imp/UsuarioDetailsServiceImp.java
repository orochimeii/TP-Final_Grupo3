package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.repository.IEmpleadorDAO;

@Service
public class UsuarioDetailsServiceImp implements UserDetailsService {
	private static final Log LOGGER = LogFactory.getLog(UsuarioDetailsServiceImp.class);
	
	@Autowired
	private IEmpleadorDAO empleadorDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		LOGGER.info(email);
		Empleador empleador = empleadorDao.findByEmail(email);
		LOGGER.info(empleador);
		UserBuilder builder = null;
		if(empleador != null) {
			builder = User.withUsername(email);
			builder.disabled(false);
			builder.password(empleador.getContrasenia());
			builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return builder.build();
	}

}
