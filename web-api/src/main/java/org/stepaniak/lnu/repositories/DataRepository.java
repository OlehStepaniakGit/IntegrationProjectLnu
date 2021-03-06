package org.stepaniak.lnu.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.stepaniak.lnu.entities.Data;

import java.util.Optional;

@Repository
public interface DataRepository extends MongoRepository<Data,String> {
    Optional<Data> findById(String id);
}
