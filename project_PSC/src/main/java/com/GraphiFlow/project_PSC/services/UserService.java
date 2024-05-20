package com.GraphiFlow.project_PSC.services;

import com.GraphiFlow.project_PSC.entities.User;
import com.GraphiFlow.project_PSC.repositories.UserRepository;
import com.GraphiFlow.project_PSC.services.exceptions.DatabaseException;
import com.GraphiFlow.project_PSC.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        };
    }

    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setIdade(obj.getIdade());
        entity.setSenha(obj.getSenha());
    }

    public User authenticate(String email, String senha) {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                return user;
            }
        }
        throw new ResourceNotFoundException("Email ou senha inválida");
    }
}
