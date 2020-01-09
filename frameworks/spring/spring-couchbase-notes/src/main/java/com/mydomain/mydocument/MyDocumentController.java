package com.mydomain.mydocument;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mydocument")
public class MyDocumentController {

  private MyDocumentService service;

  @Autowired
  public MyDocumentController(MyDocumentService service) {
    this.service = service;
  }

  @RequestMapping(method = RequestMethod.POST)
  public MyDocument create(@RequestBody MyDocument myDocument) {
    return this.service.create(myDocument);
  }

  @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
  public MyDocument get(@PathVariable String id) {
    return this.service.findOne(id);
  }

  //====================== Ad Hoc N1QL Queries ======================
  /*
    You MUST create an INDEX before you can use Ad Hoc N1QL Queries otherwise you'll get the following error:
    org.springframework.data.couchbase.core.CouchbaseQueryExecutionException: Unable to execute query due to the
    following n1ql errors: {"msg":"No index available on keyspace my-document that matches your query. Use CREATE INDEX
    or CREATE PRIMARY INDEX to create an index, or check that your expected index is online.","code":4000}
   */

  @RequestMapping(method = RequestMethod.GET)
  public List<MyDocument> search() {
    return this.service.findAll();
  }

  @RequestMapping(value = "/query", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<MyDocument> search(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) String description) {
    if (StringUtils.isNotBlank(name)) {
      return this.service.findByName(name);
    } else if (StringUtils.isNotBlank(description)) {
      return this.service.findByDescription(description);
    }
    return this.service.findAll();
  }
}