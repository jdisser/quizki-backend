package com.haxwell.apps.quizki.services;

import java.util.ArrayList;

import org.springframework.data.domain.Pageable;

import com.haxwell.apps.quizki.dtos.CreateQuestionDTO;
import com.haxwell.apps.quizki.dtos.CreatedQuestionDTO;
import com.haxwell.apps.quizki.exceptions.CreateQuestionDTOException;
import com.haxwell.apps.quizki.exceptions.GetQuestionException;

public interface QuestionService {
	public CreatedQuestionDTO createQuestion(CreateQuestionDTO cqDTO) throws CreateQuestionDTOException;
	public CreatedQuestionDTO getQuestionById(String id) throws GetQuestionException;
	public ArrayList<CreatedQuestionDTO> getQuestions(Pageable pageable) throws GetQuestionException;

}
