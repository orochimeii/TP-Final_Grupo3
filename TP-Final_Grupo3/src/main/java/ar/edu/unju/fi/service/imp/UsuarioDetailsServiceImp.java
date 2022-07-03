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

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.repository.ICiudadanoDAO;
import ar.edu.unju.fi.repository.IEmpleadorDAO;

@Service
public class UsuarioDetailsServiceImp implements UserDetailsService {
	private static final Log LOGGER = LogFactory.getLog(UsuarioDetailsServiceImp.class);
	
	@Autowired
	private IEmpleadorDAO empleadorDao;
	
	@Autowired
	private ICiudadanoDAO ciudadanoDao;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		LOGGER.info(id);
		Empleador empleador = empleadorDao.findByCuit(Long.parseLong(id));
		LOGGER.info(empleador);
		UserBuilder builder = null;
		if(empleador != null) {
			builder = User.withUsername(id);
			builder.disabled(false);
			builder.password(empleador.getContrasenia());
			builder.roles("EMPLEADOR");
			builder.authorities(new SimpleGrantedAuthority("EMPLEADOR"));
		}else {
			LOGGER.info(id);
			Ciudadano ciudadano = ciudadanoDao.findByDni(Long.parseLong(id));
			LOGGER.info(ciudadano);
			if(ciudadano != null) {
				builder = User.withUsername(id);
				builder.disabled(false);
				builder.password(ciudadano.getContrasenia());
				builder.roles("CIUDADANO");
				builder.authorities(new SimpleGrantedAuthority("CIUDADANO"));
			}else {
				throw new UsernameNotFoundException("Usuario no encontrado");
			}
		}
		return builder.build();
	}

}
