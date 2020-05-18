package org.stepaniak.lnu.resolvers.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.stepaniak.lnu.entities.Data;
import org.stepaniak.lnu.service.DataService;

@Component
public class DataMutationResolver implements GraphQLMutationResolver {
    private final DataService service;

    public DataMutationResolver(DataService service) {
        this.service = service;
    }

    public Data createOne(String content){
        return service.createOne(content);
    }

    public Data updateOne(String id,String content){
        return service.updateById(id,content);
    }
}
