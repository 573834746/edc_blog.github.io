package com.blog.servicezuul.filter.pre;

import com.blog.servicezuul.pojo.UsersVo;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/**
 *  Zuul 的前置过滤器
 */
public class PreZuulFilter extends ZuulFilter {

    @Resource
    RedisTemplate<String,UsersVo> redisTemplate;
    

    private static Logger log = LoggerFactory.getLogger(PreZuulFilter.class);

    /**
     * 前置过滤器。
     *
     * 但是在 zuul 中定义了四种不同生命周期的过滤器类型：
     *
     *      1、pre：可以在请求被路由之前调用；
     *
     *      2、route：在路由请求时候被调用；
     *
     *      3、post：在route和error过滤器之后被调用；
     *
     *      4、error：处理请求时发生错误时被调用；
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的优先级，数字越大，优先级越低。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器。
     *
     * true：说明需要过滤；
     *
     * false：说明不要过滤；
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。
     *
     * @return
     */

    String arr[] = {"ask","insert","ask_list","insertAsk","delete","update"};//填写需要拦截的请求字段
    List<String> list =  Arrays.asList(arr);

    @SuppressWarnings("unchecked")
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));


        StringBuffer requestURL = request.getRequestURL();
        String[] split = requestURL.toString().split("/");
        String compare = split[split.length - 1];

        Cookie cookie = WebUtils.getCookie(request, "user_name");

        //满足条件的被拦截，否则放行
        if (list.contains(compare)) {
            log.info("—————————————————————————— " + compare + " 请求被拦截 ——————————————————————————");
            if (cookie != null) {
                String uuid = cookie.getValue();
                redisTemplate.setKeySerializer(new StringRedisSerializer());
                redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(UsersVo.class));
                Object o = redisTemplate.opsForValue().get(uuid);
                UsersVo usersVo;
                if(o!=null){
                    usersVo = (UsersVo) o;
                }else{
                    usersVo = null;
                }
                if (usersVo != null) {
                    System.out.println("—————————————————————————— 用户已登录 ——————————————————————————");
                    System.out.println("账号："+usersVo.getUsername());

                    ctx.setSendZuulResponse(true);// 对该请求进行路由
                    ctx.setResponseStatusCode(200);
                    ctx.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态
                    return null;
                }
                ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
                ctx.setResponseStatusCode(401);// 返回错误码
                try {
                    response.sendRedirect("/api-a/xuran/login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ctx.set("isSuccess", false);
                return null;
            }else{
                ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
                ctx.setResponseStatusCode(401);// 返回错误码
                try {
                    response.sendRedirect("/api-a/xuran/login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ctx.set("isSuccess", false);
                return null;
            }
        }else {
            return null;
        }
    }
}