package com.example.question_service.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.question_service.model.Question;
import com.example.question_service.model.QuestionWrapper;
import com.example.question_service.model.Response;
import com.example.question_service.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	Environment environment;

	
	// get all questions from DB
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {

		return questionService.getAllQuestions();

	}

	// getQuestion by category name
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategoty(@PathVariable String category) {

		return questionService.getQuestionsByCategory(category);
	}

	
	// addQuestion
	@PostMapping("addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {

		return questionService.addQuestion(question);
	}
	
	
	// generateQuiz
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> generateQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numQuestions){
		
		return questionService.generateQuestionsForQuiz(category, numQuestions);
	}
	
	
	// getQuestions(id)
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
		
		// to check the load balancer call, by creating 2 instances of QuestionServiceApplication
		System.out.println(environment.getProperty("local.server.port"));
		
		return questionService.getQuestionsFromId(questionIds);
	}
	
	// calculate the score
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		
		return questionService.getScore(responses);
	}

}
