package victor.sistemaCriticaFilmes.letsCode.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import lombok.RequiredArgsConstructor;
import victor.sistemaCriticaFilmes.letsCode.filter.CustomAuthorizationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/usuarios/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/filmes").hasAnyRole("LEITOR", "BASICO", "AVANCADO", "MODERADOR");
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/filmes/avaliacoes").hasAnyRole("LEITOR", "BASICO", "AVANCADO", "MODERADOR");
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/filmes/comentarios").hasAnyRole("BASICO", "AVANCADO", "MODERADOR");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/filmes/comentarios/**").hasAnyRole("LEITOR", "BASICO", "AVANCADO", "MODERADOR");
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/filmes/comentarios/**").hasAnyRole("BASICO", "AVANCADO", "MODERADOR");
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/filmes/citacoes/comentario/**").hasAnyRole("AVANCADO", "MODERADOR");
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/filmes/like/comentario/**").hasAnyRole("AVANCADO", "MODERADOR");
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilterBefore(new CustomAuthorizationFilter(), BasicAuthenticationFilter.class);
	}
	
}
