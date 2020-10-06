package com.buzhovych.service;

import com.buzhovych.models.Notebook;
import com.buzhovych.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotebookService {
    private final NotebookRepository notebookRepository;
    private List<Notebook> notebooks = new ArrayList<>();

    @Autowired
    public NotebookService(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    public void addNotebookList(List<Notebook> notebook) {
        notebookRepository.saveAll(notebook);
    }

    public List<Notebook> getAllNotebooks() {
        notebooks.clear();
        notebooks.addAll(notebookRepository.findAll());
        return notebooks;
    }

    public List<Notebook> getSortedBy(String columnName) {
        notebooks.clear();
        notebooks.addAll(notebookRepository.findAll(Sort.by(columnName).descending()));
        return notebooks;
    }

    public List<Notebook> getAllWithMemoryMoreThan(int memoryCapacity) {
        return new ArrayList<>(notebookRepository.findByMemoryGbGreaterThanEqual(memoryCapacity));
    }

    public List<Notebook> getAllUsed() {
        notebooks.clear();
        notebooks.addAll(notebookRepository.findByUsed(true));
        return notebooks;
    }
}
