package org.kframe.mvc.api;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangkun
 * @date 2020/10/24 12:05
 * @description:
 */
public class HandlerExecutionChain {

    private final Object handler;

    private HandlerInterceptor[] interceptors;

    private List<HandlerInterceptor> interceptorList;

    public HandlerExecutionChain(Object handler, HandlerInterceptor[] interceptors, List<HandlerInterceptor> interceptorList) {
        this.handler = handler;
        this.interceptors = interceptors;
        this.interceptorList = interceptorList;
    }


    public HandlerExecutionChain(Object handler) {
        this.handler = handler;
    }

      HandlerExecutionChain(Object handler,  HandlerInterceptor... interceptors) {
          if (handler instanceof HandlerExecutionChain) {
              HandlerExecutionChain originalChain = (HandlerExecutionChain) handler;
              this.handler = originalChain.getHandler();
              this.interceptorList = new ArrayList<>();
              for (HandlerInterceptor interceptor : originalChain.getInterceptors()) {
                  this.interceptorList.add(interceptor);
              }
              for (HandlerInterceptor interceptor : interceptors) {
                  this.interceptorList.add(interceptor);
              }

          }
          else {
              this.handler = handler;
              this.interceptors = interceptors;
          }
      }

    public Object getHandler() {
        return this.handler;
    }

    public HandlerInterceptor[] getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(HandlerInterceptor[] interceptors) {
        this.interceptors = interceptors;
    }

    public List<HandlerInterceptor> getInterceptorList() {
        return interceptorList;
    }

    public void setInterceptorList(List<HandlerInterceptor> interceptorList) {
        this.interceptorList = interceptorList;
    }
}
