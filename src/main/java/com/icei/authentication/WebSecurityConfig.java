package com.icei.authentication;

/**
 * security配置
 * @author:LordMasterKing
 * @date:2018年4月26日
 */
/*@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration*/
public class WebSecurityConfig {
/*	//完成自定义认证实体注入
    @Bean
    UserDetailsService userService(){
        return new UserService();
    }
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    
    @Autowired
    private MyAuthenticationFailedHandler myAuthenticationFailedHandler;
    
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
      return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
    
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable()
         .authorizeRequests()
             .antMatchers("/login").permitAll()  
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login")
             .defaultSuccessUrl("/hello")
             .successHandler(myAuthenticationSuccessHandler)
             .failureHandler(myAuthenticationFailedHandler)
             .permitAll()
             .and()
         .logout()
             .permitAll();
	}*/
}
