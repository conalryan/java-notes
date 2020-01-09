package com.mydomain.mydocument;

import com.couchbase.client.java.repository.annotation.Field;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * To create a document:
 * 1. Market class with @Document annotation.
 * 2. Specify @Id on a field. Either springframework.data.annotaiton.Id or Couchbase SDK, but spring takes precedence.
 *    - Note that @Id merely represents the document key and is not necessarily part of the stored JSON unless marked
 *    with the @Field annotation.
 * 3. Specify JSON document attributes with @Field
 *
 * Example JSON:
 * {
 *   "name": "my name",
 *   "desc": "my description",
 *   "created": 1457193705667,
 *   "_class": "com.mydomain.mydocument.MyDocument"
 * }
 *
 * Spring Data automatically adds to each document an attribute containing the full class name of the entity. By
 * default, this attribute is named “_class”, although you can override that in your Couchbase configuration
 * class by overriding the typeKey() method.
 *
 * Change the name "_class" to "dataType":
 * @Override
 * public String typeKey() {
 *   return "dataType";
 * }
 *
 * Or you can use an alternate provided by Spring:
 * @Override
 * public String typeKey() {
 *   // use "javaClass" instead of "_class"
 *   return MappingCouchbaseConverter.TYPEKEY_SYNCGATEWAY_COMPATIBLE;
 * }
 */
@Document
public class MyDocument {

  @Id
  private String id;

  @Field
  @NotNull
  private String name;

  @Field("desc") // change the JSON entity name.
  private String description;

  @Field
  @NotNull
  private DateTime created;

  @Field
  private DateTime updated;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DateTime getCreated() {
    return created;
  }

  public void setCreated(DateTime created) {
    this.created = created;
  }

  public DateTime getUpdated() {
    return updated;
  }

  public void setUpdated(DateTime updated) {
    this.updated = updated;
  }
}
