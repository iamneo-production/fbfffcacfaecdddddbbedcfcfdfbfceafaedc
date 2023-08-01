package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ServiceClass {
    @Autowired
    private Respository rep;

    public ModelTask addTask(ModelTask mv) {
        return rep.save(mv);
    }

    public Optional<ModelTask> getTaskById(int id) {
        return rep.findById(id);
    }

    public List<ModelTask> findAllTask() {
        return rep.findAll();
    }

    public void deleteTask(int id) {
        rep.deleteById(id);
    }

    public ModelTask findByName(String name) {
        List<ModelTask> list = rep.findAll();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).getTaskHolderName();
            if (str.equals(name)) {
                return list.get(i);
            }
        }
        return null;
    }
}