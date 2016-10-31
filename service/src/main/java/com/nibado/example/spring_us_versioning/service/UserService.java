package com.nibado.example.spring_us_versioning.service;

import com.nibado.example.spring_us_versioning.service.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserService {
    private Map<UUID, User> users = new HashMap<>();

    public void add(final User user) {
        users.put(user.getId(), user);
    }

    public Optional<User> get(final UUID id) {
        return Optional.ofNullable(users.get(id));
    }

    public Collection<User> getAll() {
        return users.values();
    }

    @PostConstruct
    public void init() {
        add(new User(new UUID(0, 0), "Jack", "Johnson", "jack@example.com"));
        add(new User(new UUID(0, 1), "Jill", "Johnson", "jill@example.com"));
    }
}
