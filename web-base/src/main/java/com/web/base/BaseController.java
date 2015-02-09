package com.web.base;

import com.web.result.MessageResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class BaseController {
	
	public static final String LOGIN_USER_KEY = "login_user";

    //异步信息队列
    private final static Queue<MessageResult<String>> responseBodyQueue = new ConcurrentLinkedQueue<MessageResult<String>>();

    public Queue<MessageResult<String>> getResponseBodyQueue() {
        return responseBodyQueue;
    }

    public void processMsg(Long userId,String msg) {
        for (MessageResult<String> result : this.responseBodyQueue) {
            if(result.getUserId() == userId){
                result.setResult(msg);
                this.responseBodyQueue.remove(result);
            }
        }
    }

    public String redirect(String url){
		return "redirect:" + url;
	}
}
