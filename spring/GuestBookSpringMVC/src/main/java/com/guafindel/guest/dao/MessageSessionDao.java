package com.guafindel.guest.dao;

import java.util.List;
import java.util.Map;

import com.guafindel.guest.domain.Message;

public interface MessageSessionDao {

	public int insert(Message message);
	
	public int selectCount();
	
	public List<Message> selectList(Map<String, Object> params);
	
	public Message select(int messageId);
	
	public int deleteMessage(int messageId);
	
}
