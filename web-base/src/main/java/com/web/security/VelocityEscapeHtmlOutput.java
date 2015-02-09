package com.web.security;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.util.RuntimeServicesAware;
import org.springframework.web.util.HtmlUtils;

/**
 * Created by ivan on 15-2-9.
 * HTML转移，防止XSS攻击
 */
public class VelocityEscapeHtmlOutput
        implements ReferenceInsertionEventHandler, RuntimeServicesAware {
    private RuntimeServices rs = null;

    public Object referenceInsert(String reference, Object value) {
        // 以$!{或者${开头的内容直接返回，不做XSS过滤
        if (reference.startsWith("$!{") || reference.startsWith("${")) {
            return value;
        }
        // 其它默认转义
        return escapeHtml(value);
    }

    public void setRuntimeServices(RuntimeServices rs) {
        this.rs = rs;
    }

    protected RuntimeServices getRuntimeServices() {
        return this.rs;
    }

    /**
     * 转义HTML字符串
     *
     * @return
     */
    private static Object escapeHtml(Object value) {
        if (value == null) {
            return null;
        }

        if (!(value instanceof String)) {
            return value;
        }

        return HtmlUtils.htmlEscape(value.toString());
    }
}
