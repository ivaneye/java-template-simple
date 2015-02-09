package com.web.result;

import org.springframework.web.context.request.async.DeferredResult;

/**
 * 自定义异步返回信息类型
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 2013-05-12 12:45
 */
public class MessageResult<T> extends DeferredResult<T> implements Comparable {

    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public MessageResult(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageResult that = (MessageResult) o;

        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (userId ^ (userId >>> 32));
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) return 1;
        MessageResult r = (MessageResult) o;
        if(this.getUserId() > r.getUserId()) return 1;
        if(this.getUserId() < r.getUserId()) return -1;
        return 0;
    }
}
