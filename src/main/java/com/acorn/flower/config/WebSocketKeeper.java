package com.acorn.flower.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class WebSocketKeeper {
	Map<String, WebSocketSession> map = new HashMap<String, WebSocketSession>();
	
	public void add(String id, WebSocketSession session) {
		map.put(id, session);
		System.out.println("추가됨");
	}
	
	public void delete(String id) {
		map.remove(id);
		System.out.println("삭제됨");
	}
	
	public WebSocketSession find(String id) {
		return map.get(id);
	}
}
