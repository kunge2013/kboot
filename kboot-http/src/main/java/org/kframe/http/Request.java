package org.kframe.http;

import java.net.HttpCookie;

/**
 * @author fangkun
 * @date 2020/9/29 14:46
 * @description: 请求
 */
public  class Request<T> {

    /**
     * POSt GET
     */
    protected String method;

    /**
     * http websocket
     */
    protected String protocol;

    /**
     *  请求url
     */
    protected String requestURI;

    /**
     *  查询 字节
     */
    protected byte[] queryBytes;

    /**
     * 长度
     */
    protected long contentLength = -1;

    /**
     * 格式  FORM-  JSON -
     */
    protected String contentType;

    /**
     * 请求主机
     */
    protected String host;

    /**
     * 连接状态
     */
    protected String connection;

    /**
     *  cookie 内容
     */
    protected String cookie;

    /**
     * HttpCookie 对象
     */
    protected HttpCookie[] cookies;

    /**
     * sessionid 新的
     */
    protected String newsessionid;

    /**
     * 连接对象
     */
    protected  T channel;


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public byte[] getQueryBytes() {
        return queryBytes;
    }

    public void setQueryBytes(byte[] queryBytes) {
        this.queryBytes = queryBytes;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public HttpCookie[] getCookies() {
        return cookies;
    }

    public void setCookies(HttpCookie[] cookies) {
        this.cookies = cookies;
    }

    public String getNewsessionid() {
        return newsessionid;
    }

    public void setNewsessionid(String newsessionid) {
        this.newsessionid = newsessionid;
    }

    public T getChannel() {
        return channel;
    }

    public void setChannel(T channel) {
        this.channel = channel;
    }

    public Request(T channel) {
        this.channel = channel;
    }

    public Request() {
    }
}
