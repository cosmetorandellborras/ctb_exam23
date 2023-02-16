package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .requiresChannel(channel ->
                        channel.anyRequest().requiresSecure())
                .authorizeRequests(authorize ->
                        authorize.anyRequest().permitAll())
                .build();
    }

}
/*S' ha creat un certificat SSL que s'empra per validar la conexio entrant

Per un altre lloc, es crea un fitxer application.yml que conte el port per el cual es processaran les peticions https,
aquest fitxer conte la configuració que s empra per tal d acceptar les peticions HTTPS a mes de la referencia al fitxer SSL creat, del cual fa us

Per finalitzar, es crea la clase SecurityConfig per recopilar les politiques de seguretat y configurar un canal per a que la aplicacio sigui
segura per a totes les solicituds.

 */