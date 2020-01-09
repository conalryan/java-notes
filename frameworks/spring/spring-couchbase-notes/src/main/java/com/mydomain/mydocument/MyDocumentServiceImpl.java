package com.mydomain.mydocument;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MyDocumentServiceImpl implements MyDocumentService {

  private MyDocumentRepository repo;

  @Autowired
  public MyDocumentServiceImpl(MyDocumentRepository repo) {
    this.repo = repo;
  }

  @Override
  public List<MyDocument> findAll() {
    List<MyDocument> documents = new ArrayList<>();
    Iterable<MyDocument> foundDocs = repo.findAll();
    Iterator<MyDocument> it = repo.findAll().iterator();
    while (it.hasNext()) {
      documents.add(it.next());
    }
    return documents;
  }

  @Override
  public MyDocument findOne(String id) {
    return repo.findOne(id);
  }

  @Override
  public List<MyDocument> findByName(String name) {
    return repo.findByName(name);
  }

  @Override
  public List<MyDocument> findByDescription(String description) {
    return repo.findByDescription(description);
  }

  @Override
  public MyDocument create(MyDocument myDocument) {
    myDocument.setCreated(DateTime.now());
    repo.save(myDocument);
    return repo.findOne(myDocument.getId());
  }

  @Override
  public void update(MyDocument myDocument) {
    myDocument.setUpdated(DateTime.now());
    repo.save(myDocument);
  }

  @Override
  public void delete(MyDocument myDocument) {
    repo.delete(myDocument);
  }
}