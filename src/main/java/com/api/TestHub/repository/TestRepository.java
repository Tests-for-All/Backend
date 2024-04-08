package com.api.TestHub.repository;

import com.api.TestHub.domain.Test;
import com.api.TestHub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByUser(User user);
}
