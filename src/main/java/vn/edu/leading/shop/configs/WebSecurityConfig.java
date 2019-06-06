package vn.edu.leading.shop.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    public WebSecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                .exceptionHandling()
                .and()
                .authorizeRequests()
                .antMatchers("/register").anonymous()
                .antMatchers("/forgot-password").anonymous()
                .antMatchers("/login").anonymous()
                .antMatchers("/home/**").permitAll()
                .antMatchers("/blogdetail/**").permitAll()
                .antMatchers("/bloghome/**").permitAll()
                .antMatchers("/productDetail/**").permitAll()
                .antMatchers("/contact/**").permitAll()
                .antMatchers("/element/**").permitAll()
                .antMatchers("/about/**").permitAll()
                .antMatchers("/cart/**").permitAll()
                .antMatchers("/menu/**").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/carts/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/api/**").anonymous()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/static/**").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")

//                .defaultSuccessUrl("/")
                .failureUrl("/login?error")//
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .clearAuthentication(true)
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
}
