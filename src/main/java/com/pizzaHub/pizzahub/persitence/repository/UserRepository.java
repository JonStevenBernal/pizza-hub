package com.pizzaHub.pizzahub.persitence.repository;

import com.pizzaHub.pizzahub.persitence.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
