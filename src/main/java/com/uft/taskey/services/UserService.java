package com.uft.taskey.services;

import com.uft.taskey.entities.User;
import com.uft.taskey.repositories.UserRepository;
import com.uft.taskey.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // Listar todos os usuários
    public List<User> findAll() {
        return repository.findAll();
    }

    // Buscar usuário por ID
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. ID: " + id));
    }

    // Salvar novo usuário
    public User insert(User obj) {
        return repository.save(obj);
    }

    // Atualizar usuário
    public User update(Long id, User obj) {
        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado. ID: " + id));
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        entity.setPassword(obj.getPassword());
        return repository.save(entity);
    }

    // Deletar usuário
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado. ID: " + id);
        }
        repository.deleteById(id);
    }
}
