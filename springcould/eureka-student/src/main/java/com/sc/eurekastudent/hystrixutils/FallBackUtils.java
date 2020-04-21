package com.sc.eurekastudent.hystrixutils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FallBackUtils {
    /**
     * fallback方法。本地定义的。用来处理远程服务调用错误时，返回的基础数据。
     */
    public List<Map<String, Object>> downgradeFallback(){
        List<Map<String, Object>> result = new ArrayList<>();

        Map<String, Object> data = new HashMap<>();
        data.put("id", -1);
        data.put("name", "downgrade fallback datas");
        data.put("age", 0);
        result.add(data);
        return result;
    }
}
