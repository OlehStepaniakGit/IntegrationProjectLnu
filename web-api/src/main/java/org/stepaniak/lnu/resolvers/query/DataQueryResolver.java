package org.stepaniak.lnu.resolvers.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import org.stepaniak.lnu.entities.Data;
import org.stepaniak.lnu.service.DataService;

import java.util.List;

@Component
public class DataQueryResolver implements GraphQLQueryResolver {
    private final DataService service;

    public DataQueryResolver(DataService service) {
        this.service = service;
    }

    public List<Data> findAll() {
        List<Data> find = this.service.findAll();
        return this.service.findAll();
    }

    public Integer findLength(){
        return this.service.getDataBaseLength();
    }
}
