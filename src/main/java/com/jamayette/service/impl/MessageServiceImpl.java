package com.jamayette.service.impl;

import com.jamayette.mapper.MessageMapper;
import com.jamayette.model.Article;
import com.jamayette.model.Message;
import com.jamayette.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	MessageMapper messageMapper;

	@Override
	public List<Message> findAllMessageHistory() {
		Example example = new Example(Article.class);
		example.setOrderByClause("send_time desc");
		return messageMapper.selectByExample(example);
	}

	@Override
	public boolean saveMessage(Message message) {
		try {
			messageMapper.insert(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
