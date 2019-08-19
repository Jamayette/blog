package com.jamayette.service.impl;

import com.jamayette.mapper.LifeMapper;
import com.jamayette.model.Life;
import com.jamayette.service.ILifeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LifeServiceImpl implements ILifeService {

	private final LifeMapper lifeMapper;

	@Override
	public List<Life> findAllLife() {
		Example example = new Example(Life.class);
		example.setOrderByClause("create_time desc");
		List<Life> lifeList = lifeMapper.selectByExample(example);
		List<Life> showList = new ArrayList<>();
		if (lifeList != null) {
			for (Life life : lifeList) {
				if (life.getStatus() != 0) {
					showList.add(life);
				}
			}
		}
		return showList;
	}

	@Override
	public Life findLifeByName(String name) {
		Life record = new Life();
		record.setName(name);
		return lifeMapper.selectOne(record);
	}

	@Override
	public boolean saveLife(Life life) {
		try {
			life.setStatus(1);
			lifeMapper.insert(life);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Life findLifeById(Integer id) {
		return lifeMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean editLife(Life life) {
		try {
			lifeMapper.updateByPrimaryKeySelective(life);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean deleteLife(Integer id) {
		try {
			Life life = lifeMapper.selectByPrimaryKey(id);
			life.setStatus(0);
			lifeMapper.updateByPrimaryKey(life);
			return true;
		} catch (Exception ignored) {

		}
		return false;
	}

}
