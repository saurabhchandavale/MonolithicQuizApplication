package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modal.Question;
import com.example.demo.modal.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
	

}
