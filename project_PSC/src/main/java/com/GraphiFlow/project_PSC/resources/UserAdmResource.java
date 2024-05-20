package com.GraphiFlow.project_PSC.resources;

import com.GraphiFlow.project_PSC.entities.UserAdm;
import com.GraphiFlow.project_PSC.services.UserAdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/useradm")
public class UserAdmResource {

    @Autowired
    private UserAdmService service;

    @GetMapping
    public ResponseEntity<List<UserAdm>> findAll() {
        List<UserAdm> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserAdm> findById(@PathVariable Long id) {
        UserAdm obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<UserAdm> insert(@RequestBody UserAdm obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserAdm> update(@PathVariable Long id, @RequestBody UserAdm obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
