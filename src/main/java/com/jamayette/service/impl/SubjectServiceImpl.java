package com.jamayette.service.impl;

import com.jamayette.mapper.SubjectMapper;
import com.jamayette.model.Subject;
import com.jamayette.service.ISubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements ISubjectService {

	private final SubjectMapper subjectMapper;

	@Override
	public List<Subject> findAllSubjects() {
		Example example = new Example(Subject.class);
		example.setOrderByClause("id desc");
		List<Subject> subjectList = subjectMapper.selectByExample(example);
		List<Subject> showList = new ArrayList<>();
		for (Subject subject : subjectList) {
			if (subject.getStatus() != 0) {
				showList.add(subject);
			}
		}
		return showList;
	}

	@Override
	public boolean saveSubject(Subject subject) {
		try {
			subject.setStatus(1);
			subjectMapper.insert(subject);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Subject findSubjectById(Integer id) {
		return subjectMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean editSubject(Subject subject) {
		try {
			subjectMapper.updateByPrimaryKeySelective(subject);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteSubject(Integer id) {
		try {
			Subject subject = subjectMapper.selectByPrimaryKey(id);
			subject.setStatus(0);
			subjectMapper.updateByPrimaryKey(subject);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
