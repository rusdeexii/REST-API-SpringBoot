package com.rusdeexii.REST_API.repository;

import com.rusdeexii.REST_API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
