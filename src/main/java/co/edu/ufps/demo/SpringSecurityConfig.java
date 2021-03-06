package co.edu.ufps.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import co.edu.ufps.demo.handler.LoginSuccessHandler;

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


	
protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers(
			"/",
			"/index",
			"/index/**",
			"/js/**",
			"/css/**",
			"/img/**").permitAll()
	.antMatchers("/user/**").hasRole("USER")
	.antMatchers("/proyecto/**").hasRole("ADMIN")
	.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
	.invalidateHttpSession(true).clearAuthentication(true)
	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    .logoutSuccessUrl("/login?logout")
    .permitAll();
}

protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
    auth.inMemoryAuthentication()
            .withUser("user").password("{noop}password").roles("USER")
        .and()
            .withUser("admin").password("{noop}password").roles("ADMIN");
}
}
