package org.stepaniak.lnu.service;

import org.springframework.stereotype.Service;
import org.stepaniak.lnu.entities.Data;
import org.stepaniak.lnu.repositories.DataRepository;

import java.util.List;

@Service
public class DataService {
    private DataRepository repository;

    public DataService(DataRepository repository) {
        this.repository = repository;
    }

    public List<Data> findAll(){
        return repository.findAll();
    }
}
