package com.woniuxy.vlife.user.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class Result {

    private boolean success;

    private String message;

    private Map<String,Object> data = new HashMap<>();

    public void add(String k,Object v){
        data.put(k,v);
    }

    public Object get(String k){
        return data.get(k);
    }

}
