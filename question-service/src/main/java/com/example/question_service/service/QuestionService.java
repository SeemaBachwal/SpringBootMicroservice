package com.example.question_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.question_service.dao.QuestionDao;
import com.example.question_service.model.Question;
import com.example.question_service.model.QuestionWrapper;
import com.example.question_service.model.Response;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {

		try {

			List<Question> list = questionDao.findAll();
			System.out.println("DB Returned: " + list);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {

		try {

			List<Question> list = questionDao.findAll();
			System.out.println("DB Returned: " + list);
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<String> addQuestion(Question question) {

		try {

			questionDao.save(question);
			return new ResponseEntity<String>("Successfully added the question to DB..!!", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Integer>> generateQuestionsForQuiz(String category, Integer numQ) {

		List<Integer> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {

		List<QuestionWrapper> wrappers = new ArrayList<QuestionWrapper>();

		List<Question> questions = new ArrayList<Question>();

		for (Integer id : questionIds) {

			questions.add(questionDao.findById(id).get());
		}

		for (Question question : questions) {

			QuestionWrapper wrapper = new QuestionWrapper();

			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());

			wrappers.add(wrapper);
		}

		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {

		int resultCount = 0;

		for (Response res : responses) {

			Question question = questionDao.findById(res.getId()).get();

			if (res.getUserAnswer().equals(question.getRightAnswer())) {
				resultCount++;
			}

		}

		return new ResponseEntity<Integer>(resultCount, HttpStatus.OK);

	}

}
