package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.modal.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return questionDao.findAll();
	}
	
	public List<Question> getAllquestionsByCategory(String category) {
		// TODO Auto-generated method stub
		return questionDao.findBycategory(category);
	}

	public Question addQuestion(Question question) {
		 Integer maxId = questionDao.findMaxId();
	        // Increment the ID
	        question.setId(maxId != null ? maxId + 1 : 1);
	        Question save = questionDao.save(question);
	        return question;
		
	}

}
