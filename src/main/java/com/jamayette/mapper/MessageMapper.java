package com.jamayette.mapper;

import com.jamayette.model.Message;
import com.jamayette.util.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageMapper extends MyMapper<Message> {

}