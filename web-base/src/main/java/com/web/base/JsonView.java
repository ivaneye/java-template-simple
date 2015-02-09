package com.web.base;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JsonView extends MappingJackson2JsonView {
    public static final String DEFAULT_CONTENT_TYPE = "application/json";

    public JsonView(String contentType) {
        if (contentType == null) {
            setContentType(DEFAULT_CONTENT_TYPE);
        } else {
            setContentType(contentType);
        }
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
                                           HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        super.renderMergedOutputModel(model, request, response);
    }


}
