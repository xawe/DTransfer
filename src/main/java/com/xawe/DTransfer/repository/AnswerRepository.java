package com.xawe.dtransfer.repository;

import java.util.List;

import com.xawe.dtransfer.model.Answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{
    List<Answer> findByQuestionId(Long questionId);
}
