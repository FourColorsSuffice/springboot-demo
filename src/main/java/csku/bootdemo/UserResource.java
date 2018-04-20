package csku.bootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {

    @Autowired
    private UserReposity userReposity;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userReposity.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        Optional<User> user = userReposity.findById(id);
        return user.get();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userReposity.deleteById(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        User savedUser = userReposity.save(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable int id) {
        Optional<User> a = userReposity.findById(id);

        user.setId(id);
        userReposity.save(user);
    }
}
