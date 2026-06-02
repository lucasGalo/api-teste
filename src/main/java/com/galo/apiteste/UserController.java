package com.galo.apiteste;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

  private final Map<Long, String> users = new HashMap<>();

  @GetMapping
  public List<String> getAllUsers() {
    return new ArrayList<>(users.values());
  }

  @GetMapping("/{id}")
  public String getUserById(@PathVariable Long id) {
    return users.getOrDefault(id, "Usuário não encontrado");
  }

  @PostMapping
  public String createUser(@RequestBody String name) {
    long id = users.size() + 1;
    users.put(id, name);
    return "Usuário criado com ID: " + id;
  }

  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable Long id) {
    users.remove(id);
    return "Usuário removido com ID: " + id;
  }
}
