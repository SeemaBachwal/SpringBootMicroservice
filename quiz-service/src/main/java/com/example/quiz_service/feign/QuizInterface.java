package com.example.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.quiz_service.model.QuestionWrapper;
import com.example.quiz_service.model.Response;



@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	
		// generateQuiz
		@GetMapping("question/generate")
		public ResponseEntity<List<Integer>> generateQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numQuestions);
		
		// getQuestions(id)
		@PostMapping("question/getQuestions")
		public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
		
		// calculate the score
		@PostMapping("question/getScore")
		public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
	
	

}
