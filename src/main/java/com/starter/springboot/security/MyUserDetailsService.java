package com.starter.springboot.security;
import com.starter.springboot.entity.User;
import com.starter.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String identifiers) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(identifiers)
                .or(() -> userRepository.findByEmail(identifiers))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with this :" + identifiers));

        return new MyUserDetails(user);
    }

}
