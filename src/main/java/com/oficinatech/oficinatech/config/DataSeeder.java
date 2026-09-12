package com.oficinatech.oficinatech.config;

import com.oficinatech.oficinatech.model.Usuario;
import com.oficinatech.oficinatech.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.findByEmail("admin@oficinatech.com").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setNome("Administrador");
            admin.setEmail("admin@oficinatech.com");
            admin.setSenha(passwordEncoder.encode("admin123"));
            admin.setPerfil("ADMIN");
            usuarioRepository.save(admin);
            System.out.println(">>> Usuário admin criado: admin@oficinatech.com / senha: admin123");
        }
    }
}