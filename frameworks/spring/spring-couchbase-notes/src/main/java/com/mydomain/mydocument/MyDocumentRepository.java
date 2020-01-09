package com.mydomain.mydocument;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MyDocumentRepository extends CrudRepository<MyDocument, String> {

  List<MyDocument> findByName(String firstName);

  List<MyDocument> findByDescription(String description);
}
