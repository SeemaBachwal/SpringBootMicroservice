package com.example.quiz_service.service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quiz_service.dao.QuizDao;
import com.example.quiz_service.feign.QuizInterface;
import com.example.quiz_service.model.QuestionWrapper;
import com.example.quiz_service.model.Quiz;
import com.example.quiz_service.model.Response;




@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;



	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

		List<Integer> questionIds = quizInterface.generateQuestionsForQuiz(category, numQ).getBody();
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questionIds);
		quizDao.save(quiz);

		return new ResponseEntity<String>("SUCESS", HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

		Quiz quiz = quizDao.findById(id).get();
		
		List<Integer> questionIds = quiz.getQuestionIds();

		List<QuestionWrapper> questionsForUser = quizInterface.getQuestionsFromId(questionIds).getBody();
		
		return new ResponseEntity<List<QuestionWrapper>>(questionsForUser, HttpStatus.OK);

	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

		ResponseEntity<Integer> score = quizInterface.getScore(responses);

		return score;
	}

}
