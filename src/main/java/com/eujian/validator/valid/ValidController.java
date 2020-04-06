package com.eujian.validator.valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping
@RestController
public class ValidController {


    @PostMapping("/validPost")
    public String validPost(@Valid @RequestBody ReqDto reqDto){
        System.out.println(reqDto);
        return "success";
    }

    @GetMapping("/validGet")
    public String validGet(@Valid ReqDto reqDto){
        System.out.println(reqDto);
        return "success";
    }

    @GetMapping("/validRequestParam")
    public String validRequestParam(@RequestParam Integer id,
                                    @RequestParam String name){
        System.out.println(id);
        System.out.println(name);
        return "success";
    }
    /**
     * 自定义
     */
    @PostMapping("/validCustomize")
    public String validCustomize(@Valid @RequestBody CustomizeDto reqDto){
        System.out.println(reqDto);
        return "success";
    }
}
