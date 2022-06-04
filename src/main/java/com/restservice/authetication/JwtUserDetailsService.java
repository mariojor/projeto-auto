package com.restservice.authetication;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

//JWTUserDetailsService implementa a interface Spring Security UserDetailsService.
// Ele substitui o loadUserByUsername para buscar detalhes do usuário do banco de dados usando o nome de usuário.
// O Spring Security Authentication Manager chama esse método para obter os detalhes do
// usuário do banco de dados ao autenticar os detalhes do usuário fornecidos pelo usuário.
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if ("JavaInUse".equals(username)) {
            return new User("JavaInUse",
                    "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTY1NDI1NzE2NywiaWF0IjoxNjU0MjU3MTY3fQ.Kwx4bgWZzlfP2NxGOxOW8dkVHEdmjloazwi5Z6-dN7w",
                    List.of());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
