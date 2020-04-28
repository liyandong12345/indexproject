package com.sc.springcgetway.Hystrixs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 如果需要在Zuul网关服务中增加容错处理fallback，需要实现接口ZuulFallbackProvider
 * spring-cloud框架，在Edgware版本(包括)之后，声明接口ZuulFallbackProvider过期失效，
 * 提供了新的ZuulFallbackProvider的子接口 - FallbackProvider
 * 在老版本中提供的ZuulFallbackProvider中，定义了两个方法。
 *  - String getRoute()
 *    当前的fallback容错处理逻辑处理的是哪一个服务。可以使用通配符‘*’代表为全部的服务提供容错处理。
 *    如果只为某一个服务提供容错，返回对应服务的spring.application.name值。
 *  - ClientHttpResponse fallbackResponse()
 *    当服务发生错误的时候，如何容错。
 * 新版本中提供的FallbackProvider提供了新的方法。
 *  - ClientHttpResponse fallbackResponse(Throwable cause)
 *    如果使用新版本中定义的接口来做容错处理，容错处理逻辑，只运行子接口中定义的新方法。也就是有参方法。
 *    是为远程服务发生异常的时候，通过异常的类型来运行不同的容错逻辑。
 */
@Component
public class FallBbackProvider implements FallbackProvider {

    /**
     * return - 返回fallback处理哪一个服务。返回的是服务的名称
     * 推荐 - 为指定的服务定义特性化的fallback逻辑。
     * 推荐 - 提供一个处理所有服务的fallback逻辑。
     * 好处 - 服务某个服务发生超时，那么指定的fallback逻辑执行。如果有新服务上线，未提供fallback逻辑，有一个通用的。
     */
    public String getRoute() {
        return "user-service";
    }

    /**
     * fallback逻辑。在早期版本中使用。
     * Edgware版本之后，ZuulFallbackProvider接口过期，提供了新的子接口FallbackProvider
     * 子接口中提供了方法ClientHttpResponse fallbackResponse(Throwable cause)。
     * 优先调用子接口新定义的fallback处理逻辑。
     */
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        System.out.println("ClientHttpResponse fallbackResponse()");

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", "服务正忙，请稍后重试");
        result.add(data);

        ObjectMapper mapper = new ObjectMapper();

        String msg;
        try {
            msg = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            msg = "";
        }

        return this.executeFallback(HttpStatus.OK, msg
        );
    }

    /**
     * 具体处理过程。
     * @param status 容错处理后的返回状态，如200正常GET请求结果，201正常POST请求结果，404资源找不到错误等。
     *  使用spring提供的枚举类型对象实现。HttpStatus
     * @param contentMsg 自定义的响应内容。就是反馈给客户端的数据。
     * @return ClientHttpResponse 就是响应的具体内容。
     *  相当于一个HttpServletResponse。
     */
    private ClientHttpResponse executeFallback(final HttpStatus status,
                                               final String contentMsg) {
        return new ClientHttpResponse() {

            /**
             * 设置响应的头信息
             */
            public HttpHeaders getHeaders() {
                HttpHeaders header = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("utf-8"));
                header.setContentType(mt);
                return header;
            }

            /**
             * 设置响应体
             * zuul会将本方法返回的输入流数据读取，并通过HttpServletResponse的输出流输出到客户端。
             */
            public InputStream getBody() throws IOException {
                String content = contentMsg;
                return new ByteArrayInputStream(content.getBytes());
            }

            /**
             * ClientHttpResponse的fallback的状态码 返回String
             */
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            /**
             * ClientHttpResponse的fallback的状态码 返回HttpStatus
             */
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            /**
             * ClientHttpResponse的fallback的状态码 返回int
             */
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            /**
             * 回收资源方法
             * 用于回收当前fallback逻辑开启的资源对象的。
             * 不要关闭getBody方法返回的那个输入流对象。
             */
            public void close() {
            }
        };
    }
}
