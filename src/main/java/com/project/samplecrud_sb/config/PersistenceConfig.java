package com.project.samplecrud_sb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class PersistenceConfig {

    private static class AuditorAwareImpl implements AuditorAware<String>{

        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.of("anonymousUser");
        }
    }

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}
