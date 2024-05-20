package com.GraphiFlow.project_PSC.services;

import com.GraphiFlow.project_PSC.entities.UserAdm;
import com.GraphiFlow.project_PSC.repositories.UserAdmRepository;
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
public class UserAdmService {

    @Autowired
    private UserAdmRepository repository;

    public List<UserAdm> findAll() {
        return repository.findAll();
    }

    public UserAdm findById(Long id) {
        Optional<UserAdm> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public UserAdm insert(UserAdm obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UserAdm update(Long id, UserAdm obj) {
        try {
            UserAdm entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(UserAdm entity, UserAdm obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setSenha(obj.getSenha());
    }

}
