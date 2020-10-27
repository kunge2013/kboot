package org.kframe.mvc.service;

import org.kframe.mvc.api.HandlerExecutionChain;
import org.kframe.mvc.api.HandlerMapping;

import java.net.http.HttpRequest;
import java.util.List;

/**
 * @author fangkun
 * @date 2020/10/24 10:42
 * @description:
 */
public class DispatcherServlet extends HttpServlet {

    private List<HandlerMapping> handlerMappings;

    @Override
    public void doService(HttpRequest request) {
        logRequest(request);
        setReqAttribute(request);
    }

    /**
     * 請求日志打印
     * @param request
     */
    private void logRequest(HttpRequest request) {

    }

    private void setReqAttribute(HttpRequest request) {

    }

    private void doDispatch(HttpRequest request) {

    }

    private HandlerExecutionChain parseHandler(HttpRequest request) {
        for (HandlerMapping handlerMapping : handlerMappings) {
            //handlerMapping.getHandler(request);
        }
        return null;
    }



}
