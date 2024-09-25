package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.modal.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	public List<Question> getAllquestionsByCategory(String category) {
		// TODO Auto-generated method stub
		return questionDao.findBycategory(category);
	}

	public ResponseEntity<Question> addQuestion(Question question) {
		try {
		 Integer maxId = questionDao.findMaxId();
	        // Increment the ID
	        question.setId(maxId != null ? maxId + 1 : 1);
	        Question save = questionDao.save(question);
	        return new ResponseEntity<>(save, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		
	}

}
