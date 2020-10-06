package com.buzhovych.repository;

import com.buzhovych.models.Notebook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookRepository extends MongoRepository<Notebook, Long> {

    List<Notebook> findByUsed(Boolean used);

    List<Notebook> findByMemoryGbGreaterThanEqual(int memoryGb);
}
