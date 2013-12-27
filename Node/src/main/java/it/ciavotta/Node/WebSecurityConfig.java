package it.ciavotta.Node;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
@EnableWebSecurity
@Order(Ordered.LOWEST_PRECEDENCE - 6)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers("/login")
        		.permitAll()
        		.antMatchers("/logout")
        		.permitAll()
                .antMatchers("/**").hasRole("USER")
                .anyRequest().authenticated()
        		.and()
		        .formLogin()
			  //      .loginProcessingUrl("/j_spring_security_check")
			  //      .loginPage("/lo")
			  //      .permitAll()
			    .and()
		        .logout()
			        .permitAll();
		        http.httpBasic().realmName("Node API");
 
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.inMemoryAuthentication()
                .withUser("Launcher").password("Launcher").roles("USER");
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
         return super.authenticationManagerBean();
    }
    
}
