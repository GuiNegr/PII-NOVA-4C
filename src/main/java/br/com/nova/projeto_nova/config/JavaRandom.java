package br.com.nova.projeto_nova.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
@Configuration
public class JavaRandom {
    @Bean
    public Random JavaRandom(){
        return new Random();
    }
}