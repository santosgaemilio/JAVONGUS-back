//package generation.javongus.html.model;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/public/**").permitAll()
//                .antMatchers("/secure/**").authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/secure/dashboard")
//                .and()
//            .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/public")
//                .and()
//            .csrf()
//                .disable();
//    }
//
//    @Bean
//    public HttpSessionSecurityContextRepository httpSessionSecurityContextRepository() {
//        return new HttpSessionSecurityContextRepository();
//    }
//}

