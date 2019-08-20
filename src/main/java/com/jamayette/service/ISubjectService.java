package com.jamayette.service;

import com.jamayette.model.Subject;

import java.util.List;

public interface ISubjectService {

	List<Subject> findAllSubjects();

	boolean saveSubject(Subject subject);

	Subject findSubjectById(Integer id);

	boolean editSubject(Subject subject);

	Boolean deleteSubject(Integer id);

}
