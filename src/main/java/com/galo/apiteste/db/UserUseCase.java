package com.galo.apiteste.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Service
public class UserUseCase {
  private final UserRepository userRepository;

  public UserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  @Scheduled(fixedRate = 6000)
  private void createUsers() throws InterruptedException {
    for(int i = 0; i < 3; i++) {
      UserEntity user = new UserEntity();
      user.setEmail("email" + i);
      user.setPassword("password" + i);
      user.setName("User " + i);
      this.createUser(user);
    }
  }


  public void createUser(UserEntity request) throws InterruptedException {
    log.info("createUser user with email: {}", request.getEmail());
    if (userRepository.existsByEmail(request.getEmail())) {
      throw new IllegalArgumentException("Email already registered");
    }
    UserEntity save = userRepository.save(request);
    log.info("User created with id: {}", save.getId());
    //Esperar 2s para deletar
    Thread.sleep(2000);

    deleteUserById(save.getId());
  }

  public void deleteUserById(@PathVariable Long id) {
    userRepository.deleteById(id);
    log.info("Delete user id: {}", id);
  }
}
