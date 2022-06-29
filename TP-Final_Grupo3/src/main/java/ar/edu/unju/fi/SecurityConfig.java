package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import ar.edu.unju.fi.service.imp.UsuarioDetailsServiceImp;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
//	@Bean
//    public UserDetailsService userDetailsService() throws Exception {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").password(encoder().encode("userPass")).roles("USER").build());
//        manager.createUser(User.withUsername("admin").password(encoder().encode("adminPass")).roles("ADMIN").build());
//        return manager;
//    }
    
    @Bean
    public static BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)
    public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {

        public App1ConfigurationAdapter() {
            super();
        }
        @Autowired
    	private UsuarioDetailsServiceImp userDetailService;
        
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        	auth.userDetailsService(userDetailService).passwordEncoder(encoder());
//        	 auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("admin")).roles("ADMIN");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
//            http.antMatcher("/empleador*").authorizeRequests().anyRequest().hasRole("EMPLEADOR")
//                    // log in
//                    .and().formLogin().loginPage("/login/empleador").loginProcessingUrl("/login/empleador").failureUrl("/login/empleador?error=loginError").defaultSuccessUrl("/empleador/empleadores")
//                    // logout
//                    .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login/empleador").deleteCookies("JSESSIONID").and().exceptionHandling().accessDeniedPage("/403").and().csrf().disable();
        	http.authorizeRequests().antMatchers("/","/**","/resources/**","/auth/**","/public/**","/css/**","/js/**").permitAll().anyRequest().authenticated()
    		.and()
    		.formLogin().loginPage("/login/empleador").defaultSuccessUrl("/empleadores", true).failureUrl("/login/empleador?error=true")
    		.loginProcessingUrl("/login/empleador").permitAll()
    		.usernameParameter("id")
    		.passwordParameter("password")
    		.and()
    		.logout().logoutUrl("/logout").logoutSuccessUrl("/");
        }
    }

    @Configuration
    @Order(2)
    public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {

        public App2ConfigurationAdapter() {
            super();
        }

        @Autowired
    	private UsuarioDetailsServiceImp userDetailService;
        
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        	auth.userDetailsService(userDetailService).passwordEncoder(encoder());
        	//auth.inMemoryAuthentication().withUser("user").password(encoder().encode("user")).roles("USER");
        }

        protected void configure(HttpSecurity http) throws Exception {
//            http.antMatcher("/ciudadano*").authorizeRequests().anyRequest().hasRole("CIUDADANO")
//                    // log in
//                    .and().formLogin().loginPage("/login/ciudadano").loginProcessingUrl("/login/ciudadano").failureUrl("/login/ciudadano?error=loginError").defaultSuccessUrl("/inicio")
//                    // logout
//                    .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login/ciudadano").deleteCookies("JSESSIONID").and().exceptionHandling().accessDeniedPage("/403").and().csrf().disable();
        	http.authorizeRequests().antMatchers("/","/**","/resources/**","/auth/**","/public/**","/css/**","/js/**").permitAll().anyRequest().authenticated()
    		.and()
    		.formLogin().loginPage("/login/ciudadano").defaultSuccessUrl("/inicio", true).failureUrl("/login/ciudadano?error=true")
    		.loginProcessingUrl("/login/empleador").permitAll()
    		.usernameParameter("id")
    		.passwordParameter("password")
    		.and()
    		.logout().logoutUrl("/logout").logoutSuccessUrl("/");
        }
    }

}


