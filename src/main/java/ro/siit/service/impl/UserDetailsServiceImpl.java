package ro.siit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.siit.domain.User;
import ro.siit.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String ROLE_PREFIX = "ROLE_";

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) {

        // username is a closure - because we use it inside the anonymous class
        // (or the lambda expression)
        final Optional<User> optionalUser = userRepository.findByEmail(username);
        final User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException(username));

        final Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        // the role in the DB is 'administrator' but Spring Security needs 'ROLE_administrator'
        // so we add that prefix here, where we add the user's authorities to the GrantedAuthority list
        grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + user.getRole()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                grantedAuthorities);
    }
}
