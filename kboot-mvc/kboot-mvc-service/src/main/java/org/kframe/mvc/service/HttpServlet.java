package org.kframe.mvc.service;

import org.kframe.mvc.api.Context;
import org.kframe.mvc.api.Request;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author fangkun
 * @date 2020/10/24 10:44
 * @description:
 */
public abstract class HttpServlet <C extends Context, RQ extends HttpRequest, RP extends HttpResponse> {

    private C context;

    private RQ request;

    private RP response;

    public void doGet(RQ request) {
        processRequest(request);
    }

    public void doPost(RQ request) {
        processRequest(request);
    }

    public abstract void doService(RQ request);

    public final void processRequest(RQ request) {
        doService(request);
    }

}

