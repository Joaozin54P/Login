package com.fatec.login.service;

import com.fatec.login.model.login;
import com.fatec.login.repository.loginRepository;
import com.fatec.login.security.jwtService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class loginService {

    private final loginRepository loginRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final jwtService jwtService;

    public loginService(loginRepository loginRepository,
                        BCryptPasswordEncoder passwordEncoder,
                        jwtService jwtService) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public login salvar(login login) {
        login novoLogin = new login(
                login.id(),
                login.username(),
                passwordEncoder.encode(login.password()),
                login.role(),
                login.email(),
                null
        );

        return loginRepository.save(novoLogin);
    }

    public List<login> listar() {
        return loginRepository.findAll();
    }

    public Optional<login> buscarPorId(String id) {
        return loginRepository.findById(id);
    }

    public void deletar(String id) {
        loginRepository.deleteById(id);
    }

    public login atualizar(String id, login novo) {
        return loginRepository.findById(id)
                .map(loginExistente -> new login(
                        loginExistente.id(),
                        novo.username(),
                        passwordEncoder.encode(novo.password()),
                        novo.role(),
                        novo.email(),
                        null
                ))
                .map(loginRepository::save)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public String realizarLogin(String username, String password) {
        Optional<login> user = loginRepository.findByUsername(username);

        if (user.isPresent() && passwordEncoder.matches(password, user.get().password())) {
            return jwtService.gerarToken(
                    user.get().username(),
                    user.get().role()
            );
        }

        throw new RuntimeException("Credenciais inválidas");
    }
}