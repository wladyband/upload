package br.com.arm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.arm.secutiry.AppUserDetailsService;

@EnableWebSecurity
@ComponentScan(basePackageClasses = AppUserDetailsService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 auth.inMemoryAuthentication().withUser("joao").password("joao").roles("PESQUISAR_VINHO").and().withUser("maria")
//		 .password("proxy7").roles("CADASTRAR_PRODUTO", "PESQUISAR_PRODUTO");

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/layout/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// .antMatchers("/hidraulicos").hasRole("PESQUISAR_VINHO")
//				.antMatchers("/home/**").hasRole("CADASTRAR_PRODUTO").anyRequest().authenticated().and().formLogin()
//				.loginPage("/login").permitAll().and().logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
			.antMatchers("/hidraulicos/**").hasRole("CADASTRAR_HIDRAULICO")
			.antMatchers("/usuarios/**").hasRole("CADASTRAR_USUARIO")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
		.and()
			.exceptionHandling()
			.accessDeniedPage("/403")
		.and()
		.csrf().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
