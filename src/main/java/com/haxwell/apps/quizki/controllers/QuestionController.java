package com.haxwell.apps.quizki.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.haxwell.apps.quizki.dtos.CreateQuestionDTO;
import com.haxwell.apps.quizki.dtos.CreatedQuestionDTO;
import com.haxwell.apps.quizki.exceptions.CreateQuestionDTOException;
import com.haxwell.apps.quizki.exceptions.GetQuestionException;
import com.haxwell.apps.quizki.services.QuestionService;

import org.springframework.data.domain.Pageable;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = {"/api/question"})
public class QuestionController {

	@Autowired
	private QuestionService qs;
	
	public QuestionController (QuestionService qs) {
		this.qs = qs;
	}
	
	@PostMapping
	@ResponseBody
	public CreatedQuestionDTO create(@RequestBody @Valid CreateQuestionDTO cqDTO) throws CreateQuestionDTOException {
		 return qs.createQuestion(cqDTO);
	}
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public CreatedQuestionDTO getQuestionById(@PathVariable String id) throws GetQuestionException {
		return qs.getQuestionById(id);
	}
	
	@GetMapping
	@ResponseBody
	public ArrayList<CreatedQuestionDTO> getQuestions(
			@RequestParam(value = "page", defaultValue = "0") int zeroBasedPageNumber,
			@RequestParam(value = "size", defaultValue = "10") int size) throws GetQuestionException {
		Pageable pageable = PageRequest.of(zeroBasedPageNumber, size);
		return qs.getQuestions(pageable);
	}
	
}
