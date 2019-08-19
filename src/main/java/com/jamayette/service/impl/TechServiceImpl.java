package com.jamayette.service.impl;

import com.jamayette.mapper.TechMapper;
import com.jamayette.model.Tech;
import com.jamayette.service.ITechService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TechServiceImpl implements ITechService {

	private final TechMapper techMapper;

	@Override
	public List<Tech> findAllTechs() {
		Example example = new Example(Tech.class);
		example.setOrderByClause("create_time desc");
		List<Tech> techList = techMapper.selectByExample(example);
		List<Tech> showList = new ArrayList<>();
		for (Tech tech : techList) {
			if (tech.getStatus() != 0) {
				tech.setContent(null);
				showList.add(tech);
			}
		}
		return showList;
	}

	@Override
	public Tech findTechByName(String name) {
		Tech record = new Tech();
		record.setName(name);
		return techMapper.selectOne(record);
	}

	@Override
	public boolean saveTech(Tech tech) {
		try {
			tech.setStatus(1);
			techMapper.insert(tech);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteTech(Integer id) {
		try {
			Tech tech = techMapper.selectByPrimaryKey(id);
			tech.setStatus(0);
			techMapper.updateByPrimaryKey(tech);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Tech findTechById(Integer id) {
		return techMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean editTech(Tech tech) {
		try {
			techMapper.updateByPrimaryKeySelective(tech);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
