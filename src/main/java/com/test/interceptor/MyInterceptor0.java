package com.test.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * springmvc的拦截器是针对HandlerMapping（处理器映射器）进行拦截设置，
 * 比如在某个HandlerMapping中配置拦截，经过该HandlerMapping映射成功的handler
 * 最终使用该拦截器
 */
public class MyInterceptor0 implements HandlerInterceptor{

    /**
     * 在业务处理器（Handler）处理请求之前被调用
     * 应用场景：身份认证、身份授权......
     *
     * 执行原理：
     * return false：
     *        从当前的拦截器往回执行所有拦截器的afterCompletion()，在退出拦截器链
     * return true：
     *        当前拦截器放行请求，接着执行下一个拦截器的preHandle()，知道所有的拦截器的preHandle()都执行完；
     *        然后执行被拦截的处理器（叫Handler或者Controller）；
     *        再然后在生成视图之前，进入拦截器链，从最后一个往回执行所有的postHandle()；
     *        到前端控制器处理完这次请求之后再进入拦截器链，从最后一个拦截器往回执行所有的afterCompletion()
     */
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {

        System.out.println("拦截器0---preHandle()");


        // return false：表示拦截，不向下执行
        // return true：表示放行
        return true;
    }

    /**
     * 在业务处理器处理完请求后，生成视图（渲染模板）之前被调用
     * 应用场景：从modelAndView出发，将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里统一指定视图
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器0---postHandle()");
    }

    /**
     * 在前端控制器完全处理完请求之后调用
     * 应用场景：清理资源，统一异常处理，统一日志处理，注意统一异常处理和统一日志处理还可以放在自定义的异常处理类中（实际的开发中多是这样的）
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("拦截器0---afterCompletion()");
    }
}

