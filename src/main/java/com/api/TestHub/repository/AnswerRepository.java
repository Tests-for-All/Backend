package com.api.TestHub.repository;

import com.api.TestHub.domain.Answer;
import com.api.TestHub.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
