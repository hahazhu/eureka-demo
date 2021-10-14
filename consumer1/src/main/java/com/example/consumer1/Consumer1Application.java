package com.example.consumer1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@RestController
@EnableEurekaClient
@SpringBootApplication
public class Consumer1Application {
    @Autowired
    RestTemplate restTemplate;
    /**
     * 实例化RestTemplate
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }

    /**
     * Rest服务端使用RestTemplate发起http请求,然后得到数据返回给前端----gotoUser是为了区分getUser怕小伙伴晕头
     * @param id
     * @return
     */
    @GetMapping(value = "/gotoUser")
    @ResponseBody
    public Map<String,Object> getUser(@RequestParam Integer id){
        Map<String,Object> data = new HashMap<String,Object>();
        /**
         * 小伙伴发现没有，地址居然是http://service-provider
         * 居然不是http://127.0.0.1:8082/
         * 因为他向注册中心注册了服务，服务名称service-provider,我们访问service-provider即可
         *
         * 注意要容错，当发生错误时重新掉这个接口，防止发生某个服务挂掉，请求失败的情况。
         */
        data = restTemplate.getForObject("http://ai-client1/getUser?id="+id, Map.class);
        return data;
    }

    public static void main(String[] args) {
        SpringApplication.run(Consumer1Application.class, args);
    }

}
