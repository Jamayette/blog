package com.jamayette.controller;

import com.jamayette.model.Message;
import com.jamayette.service.IMessageService;
import com.jamayette.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Controller
public class MessageController {

	@Autowired
	private IMessageService messageService;

	@RequestMapping("/m/message")
	public String toMessagePage() {
		return "message/message";
	}

	@RequestMapping(value = "/m/message/send", method = RequestMethod.POST)
	@ResponseBody
	public String sendMessage(Message message) throws UnsupportedEncodingException {

		message.setSendTime(new Date());

		boolean sendResult = SmsUtil.Send(message);
		if (sendResult) {
			message.setStatus(1);
		} else {
			message.setStatus(0);
		}

		boolean b = messageService.saveMessage(message);
		if (b) {
			return "success";
		} else {
			return "failed";
		}

	}

}
