package com.uft.taskey.resources;

import com.uft.taskey.entities.User;
import com.uft.taskey.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    // GET /users - lista todos
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // GET /users/{id} - busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    // POST /users - cria novo usuário
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        User newObj = service.insert(obj);
        URI uri = URI.create("/users/" + newObj.getId());
        return ResponseEntity.created(uri).body(newObj);
    }

    // PUT /users/{id} - atualiza usuário
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        User updatedObj = service.update(id, obj);
        return ResponseEntity.ok().body(updatedObj);
    }

    // DELETE /users/{id} - deleta usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
