package com.project.ProjectFlightsSpring.data;

import com.project.ProjectFlightsSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
