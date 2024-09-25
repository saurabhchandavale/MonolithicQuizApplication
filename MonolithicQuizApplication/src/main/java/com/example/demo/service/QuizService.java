package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.dao.QuizDao;
import com.example.demo.modal.Question;
import com.example.demo.modal.QuestionWrapper;
import com.example.demo.modal.Quiz;
import com.example.demo.modal.Response;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<Quiz> createQuiz(String category, int noOfQuestions, String title) {
		System.out.println("*****");
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, noOfQuestions);
		System.out.println("SCE32");
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		Quiz quizCreated = quizDao.save(quiz);
		return new ResponseEntity<>(quizCreated, HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
		Optional<Quiz> question = quizDao.findById(id);
		List<Question> questionFromDB = question.get().getQuestions();
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		for(Question q : questionFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getCategory(), q.getDifficultylevel(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionForUser.add(qw);
		}
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculate(int id, List<Response> response) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> question = quiz.get().getQuestions();
		int right = 0;
		int i = 0;
		
		for(Response r : response) {
			if(r.getResponse().equals(question.get(i).getRightAnswer())) {
				right++;
			}
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
		
	}

}
