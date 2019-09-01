package com.blogs.filter;

import com.blogs.common.util.JwtUtils;
import com.blogs.config.FilterProperties;
import com.blogs.config.JwtProperties;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName:AuthorizedFilter
 * Package:com.leyou.filter
 * Description:
 *
 * @date:2019/7/21 18:40
 * @author: 574986060@qq.com
 */
@Component
@EnableConfigurationProperties({FilterProperties.class, JwtProperties.class})
public class AuthorizedFilter extends ZuulFilter {

    @Autowired
    private FilterProperties filterProperties;

    @Autowired
    private JwtProperties jwtProperties;

    //
//    @Value("${token.headerName}")
    private final static String headerName = "Authorization";


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        //是 列表里的就放行
        //不是就不放行
        return !allowPath();
    }

    private Boolean allowPath() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();

        Boolean flag = false;

        List<String> notAllowPaths = filterProperties.getNotAllowPaths();
        for (String notAllowPath : notAllowPaths) {
            if (uri.startsWith(notAllowPath)) {
                flag = false;
                break;
            }
        }

        List<String> allowPaths = filterProperties.getAllowPaths();
        for (String allowPath : allowPaths) {
            if (uri.startsWith(allowPath)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public Object run() {
        //获取token
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //获取ip 如果地址变了 立马给不通过
//        String ipAddress = IpUtil.getIpAddress(request);

        String header = request.getHeader(headerName);


        try {
            JwtUtils.getInfoFromToken(header, jwtProperties.getPublicKey());
        } catch (Exception e) {
            ctx.setSendZuulResponse(false);
            //失败则返回 403
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }

//        String ip = userInfo.getIp();
//
//        if (!ipAddress.equals(ip)) {
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
//        }
        return null;
    }
}
