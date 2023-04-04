package com.tms.security;

import com.tms.domain.User;
import com.tms.domain.request.JwtAuthRequest;
import com.tms.domain.request.RegistrationUser;
import com.tms.repository.UserRepository;
import com.tms.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class SecurityService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Autowired
    public SecurityService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public String getToken(JwtAuthRequest jwtAuthRequest) {
        Optional<User> user = userRepository.findUserByLogin(jwtAuthRequest.getLogin());
        if (user.isPresent() && passwordEncoder.matches(jwtAuthRequest.getPassword(), user.get().getPassword())) {
            return jwtProvider.createJwtToken(jwtAuthRequest.getLogin());
        }
        return "";
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean registration(RegistrationUser registrationUser) {
        try {
            User user = new User();
            user.setAge(registrationUser.getAge());
            user.setFirstName(registrationUser.getFirstName());
            user.setLastName(registrationUser.getLastName());
            user.setLogin(registrationUser.getLogin());
            user.setPassword(passwordEncoder.encode(registrationUser.getPassword()));

            User savedUser = userRepository.save(user);
            System.out.println();
            //     userRepository.addUserRole(savedUser.getId()); //TODO: CHANGE

            if (savedUser != null) {
                return true;
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return false;
    }
}