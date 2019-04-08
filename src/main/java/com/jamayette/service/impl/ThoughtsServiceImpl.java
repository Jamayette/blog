package com.jamayette.service.impl;

import com.jamayette.mapper.ThoughtsMapper;
import com.jamayette.model.Thoughts;
import com.jamayette.service.IThoughtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThoughtsServiceImpl implements IThoughtsService {

	@Autowired
	ThoughtsMapper thoughtsMapper;

	@Override
	public List<Thoughts> findAllThoughts() {
		Example example = new Example(Thoughts.class);
		example.setOrderByClause("create_time desc");
		List<Thoughts> thoughtsList = thoughtsMapper.selectByExample(example);
		List<Thoughts> showList = new ArrayList<>();
		if (thoughtsList != null) {
			for (Thoughts thoughts : thoughtsList) {
				if (thoughts.getStatus() != 0) {
					showList.add(thoughts);
				}
			}
		}
		return showList;
	}

	@Override
	public Thoughts findThoughtsByName(String name) {
		Thoughts record = new Thoughts();
		record.setName(name);
		return thoughtsMapper.selectOne(record);
	}

	@Override
	public boolean saveThoughts(Thoughts thoughts) {
		try {
			thoughts.setStatus(1);
			thoughtsMapper.insert(thoughts);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Thoughts findThoughtsById(Integer id) {
		return thoughtsMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean editThoughts(Thoughts thoughts) {
		try {
			thoughtsMapper.updateByPrimaryKeySelective(thoughts);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean deleteThoughts(Integer id) {
		try {
			Thoughts thoughts = thoughtsMapper.selectByPrimaryKey(id);
			thoughts.setStatus(0);
			thoughtsMapper.updateByPrimaryKey(thoughts);
			return true;
		} catch (Exception ignored) {

		}
		return false;
	}

}
