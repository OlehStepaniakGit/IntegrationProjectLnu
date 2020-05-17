package org.stepaniak.lnu.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;
import org.stepaniak.lnu.entities.Data;
import org.stepaniak.lnu.service.DataService;

import java.util.List;

@Component
public class DataResolver implements GraphQLResolver {
    private final DataService dataService;

    public DataResolver(DataService dataService) {
        this.dataService = dataService;
    }

    public List<Data> getAllNews() {
        return this.dataService.findAll();
    }
}
