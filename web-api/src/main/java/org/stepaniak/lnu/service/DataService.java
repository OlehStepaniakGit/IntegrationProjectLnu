package org.stepaniak.lnu.service;

import org.springframework.stereotype.Service;
import org.stepaniak.lnu.entities.Data;
import org.stepaniak.lnu.repositories.DataRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DataService {
    private DataRepository repository;

    public DataService(DataRepository repository) {
        this.repository = repository;
    }

    public List<Data> findAll(){
        return repository.findAll();
    }

    public int getDataBaseLength(){
        return this.findAll().size();
    }

    public Data createOne(String content){
        Data data =  new Data(content);
        repository.save(data);
        return data;
    }

    public Data updateById(String id,String content){
        Optional<Data> find =  repository.findById(id);

        if (!find.isPresent()){
            return this.createOneWithId(id , content);
        }

        Data data = find.get();
        data.setContent(content);
        repository.save(data);
        return data;
    }

    private Data createOneWithId(String id, String content){
        Data data =  new Data(id,content, LocalDateTime.now().toString());
        repository.save(data);
        return data;
    }

}
