package com.example.batch.process.BatchProcess.batch;

import com.example.batch.process.BatchProcess.entities.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
class UserItemProcesser implements ItemProcessor<User, User> {

    private final static Map<String, String> departmentMap = new HashMap<>();

    static {
        departmentMap.put("100", "Computer");
        departmentMap.put("101", "Hello");
        departmentMap.put("102", "Hi");
    }
    @Override
    public User process(User user) {
        user.setDepartment(departmentMap.get(user.getDepartment()));
        return user;
    }
}
