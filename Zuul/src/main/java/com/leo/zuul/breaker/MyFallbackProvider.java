package com.leo.zuul.breaker;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class MyFallbackProvider implements ZuulFallbackProvider {

    /**
     * getRoute()方法，用于指定熔断功能应用于哪些路由的服务。
     * 如果需要所有的路由服务都加熔断功能，只需要在getRoute()方法上返回"*"的匹配符，
     */
    @Override
    public String getRoute() {
        return "*"; //所有路由服务都增加熔断。
    }

    /**
     * fallbackResponse()为进入熔断功能时执行的逻辑
     */
    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            //设置响应的HTTP状态码（HttpStatus中的enum值）
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.SERVICE_UNAVAILABLE;
            }

            //设置响应的HTTP状态码(数字，可以是非标准的状态码)
            @Override
            public int getRawStatusCode() throws IOException {
                return 503;
            }

            //设置响应的HTTP状态文本信息
            @Override
            public String getStatusText() throws IOException {
                return "Service_Fallbcak";
            }

            //关闭响应，用于释放资源
            @Override
            public void close() {

            }

            //以输入流的形式返回响应体的信息
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("您好，服务出现故障，请重试。".getBytes("utf-8"));
            }

            //返回响应头的信息
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}