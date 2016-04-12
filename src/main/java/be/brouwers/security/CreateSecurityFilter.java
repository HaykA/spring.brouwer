package be.brouwers.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CreateSecurityFilter extends WebSecurityConfigurerAdapter {
	
	private static final String ADMINISTRATOR = "administrator";
	private static final String USER = "user";
	
	private static final String SQL_USERS
		= "select username, password, enabled from users"
		+ " where username = ?";
	
	private static final String SQL_AUTHORITIES
		= "select users.username, authorities.name as authorities from users"
		+ " inner join userauthorities on users.id = userauthorities.userid"
		+ " inner join authorities on authorities.id = userauthorities.authorityid"
		+ " where username = ?";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(SQL_USERS)
			.authoritiesByUsernameQuery(SQL_AUTHORITIES)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring()
			.antMatchers("/browser/**")
			.antMatchers("/images/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		http.formLogin().loginPage("/login").and().logout()
		.logoutSuccessUrl("/").and().authorizeRequests()
		.antMatchers("/brouwers/toevoegen").hasAuthority(ADMINISTRATOR)
		.antMatchers("/brouwers", "/brouwers/beginnaam", "/brouwers/opalfabet")
		.hasAnyAuthority(ADMINISTRATOR, USER);
		http.httpBasic();
	}
}
