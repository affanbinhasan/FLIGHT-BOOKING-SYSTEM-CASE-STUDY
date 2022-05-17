package co.flight.bookms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //set your configuration on the auth object

        auth.inMemoryAuthentication()
            .withUser("affan")
            .password("affan")
            .roles("USER")
            .and()
            .withUser("Amit")
            .password("mentor")
            .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
            .antMatchers("/booking/**").hasRole("ADMIN")
            .antMatchers("/swagger-ui.html").hasRole("ADMIN")
            .antMatchers("/booking/getflight/**").hasRole("USER")
            .antMatchers("/").permitAll()
            .and().formLogin();
    }
}
