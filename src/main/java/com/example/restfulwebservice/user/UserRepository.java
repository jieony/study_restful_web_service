package com.example.restfulwebservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}



// insert into user values(1001, sysdate(), 'eony1','asdf','111');
// insert into post values(2001, 'My second post', 1001);