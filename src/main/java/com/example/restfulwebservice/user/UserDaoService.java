package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "eony1", new Date(), "pass1", "101010-1111111"));
        users.add(new User(2, "eony2", new Date(), "pass2", "101010-2222222"));
        users.add(new User(3, "eony3", new Date(), "pass3", "101010-3333333"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }

    public User updateUser(User newUser) {

        int newId = newUser.getId();

        for (int i =0; i<users.size();i++) {
            int id = users.get(i).getId();
            if (id == newId) {
                users.set(i, newUser);
                return newUser;
            }
        }
        return null;
    }

}
