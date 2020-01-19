package com.example.batch.process.BatchProcess.batch;

import com.example.batch.process.BatchProcess.entities.User;
import com.example.batch.process.BatchProcess.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class UserItemWriter implements ItemWriter<User> {

    @Autowired
    private
    UserRepository userRepository;

    @Override
    public void write(List<? extends User> users) {
        userRepository.saveAll(users);
    }
}
