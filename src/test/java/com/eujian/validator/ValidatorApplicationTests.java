package com.eujian.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ValidatorApplicationTests {


    @Autowired
    private MockMvc mvc;

    @Test
    public void validPost() throws Exception {
        String url = "/validPost";
        String reqBody= "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"eujian\",\n" +
                "    \"money\": 11\n" +
//                "    \"money\": -1\n" +
                "}";
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .post(url)
                .content(reqBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
                .andReturn();// 返回执行请求的结果
        System.out.println("-----------------返回执行请求的结果--------------------------------");
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void validGet() throws Exception {
        String url = "/validGet";
        String reqBody= "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"eujian\",\n" +
//                "    \"name\": \"eujianeujianeujianeujian\",\n" +
                "    \"money\": 1\n" +
                "}";
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get(url)
                .content(reqBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
                .andReturn();// 返回执行请求的结果
        System.out.println("-----------------返回执行请求的结果--------------------------------");
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void validRequestParam() throws Exception {
        String url = "/validRequestParam";
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get(url)
                .param("id","1")
                .param("name","1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
                .andReturn();// 返回执行请求的结果
        System.out.println("-----------------返回执行请求的结果--------------------------------");
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void validCustomize() throws Exception {
        String url = "/validCustomize";
        String reqBody= "{\n" +
                "    \"customize\": 1\n" +
                "}";
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .post(url)
                .content(reqBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
                .andReturn();// 返回执行请求的结果
        System.out.println("-----------------返回执行请求的结果--------------------------------");
        System.out.println(result.getResponse().getContentAsString());
    }
}
