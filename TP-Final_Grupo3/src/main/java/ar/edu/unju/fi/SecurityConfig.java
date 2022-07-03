package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ar.edu.unju.fi.service.imp.UsuarioDetailsServiceImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private AutenticacionSuccessHandler autenticacion;

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**",
			"/webjars/**", "/images/**" };

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/login/*").permitAll().antMatchers("/", "/inicio","/login/*", "/empleador/registro", "/ciudadano/registro").permitAll().antMatchers(resources).permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").permitAll().successHandler(autenticacion)
				.failureUrl("/login?error=true").usernameParameter("id").passwordParameter("password").and().logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/login/ciudadano")
				.permitAll();

		http.headers().frameOptions().sameOrigin();

		return http.build();
	}

	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}

	@Autowired
	UsuarioDetailsServiceImp userDetailsService;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}


