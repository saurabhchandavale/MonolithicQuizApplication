package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Question;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	//http://localhost:8003/questions/allquestions
	@GetMapping("/allquestions")
	public List<Question> getAllQuestions() {
		
		return questionService.getAllQuestions();
	}
	
	//http://localhost:8003/questions/category/python
	@GetMapping("/category/{category}")
	public List<Question> getAllquestionsBycategory(@PathVariable String category){
		return questionService.getAllquestionsByCategory(category);
	}
	//http://localhost:8003/questions/addquestion
	@PostMapping("/addquestion")
	public Question addQuestion(@RequestBody Question question) {
		Question addedQuestion = questionService.addQuestion(question);
		return addedQuestion;
	}

}
