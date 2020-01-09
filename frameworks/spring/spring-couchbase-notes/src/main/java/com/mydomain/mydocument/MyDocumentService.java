package com.mydomain.mydocument;

import java.util.List;

public interface MyDocumentService {

  List<MyDocument> findAll();

  MyDocument findOne(String id);

  List<MyDocument> findByName(String name);

  List<MyDocument> findByDescription(String description);

  MyDocument create(MyDocument myDocument);

  void update(MyDocument myDocument);

  void delete(MyDocument myDocument);
}
