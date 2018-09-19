package cn.com.thread.service;

import cn.com.thread.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    ExampleRepository exampleRepository;

    public String getNameByClassId(String id){

        String name = exampleRepository.getNameByClassId(id);

        return name;

    }

}
