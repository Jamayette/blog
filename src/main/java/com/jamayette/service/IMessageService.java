package com.jamayette.service;

import com.jamayette.model.Message;

import java.util.List;

public interface IMessageService {

	List<Message> findAllMessageHistory();

	boolean saveMessage(Message message);

}
