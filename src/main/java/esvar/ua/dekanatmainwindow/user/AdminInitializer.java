package esvar.ua.dekanatmainwindow.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Bean
    CommandLineRunner initializeAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> userRepository.findByUsername("admin")
                .orElseGet(() -> userRepository.save(new User("admin", passwordEncoder.encode("admin"), "ADMIN")));
    }
}
