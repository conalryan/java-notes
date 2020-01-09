package com.mydomain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;

/**
 * Configure Couchbase
 * Specify one or more nodes of the Couchbase cluster and the name and password of the bucket in which we will
 * store our documents.
 */
@Configuration
@EnableCouchbaseRepositories(basePackages={"com.mydomain"})
public class MyCouchbaseConfig extends AbstractCouchbaseConfiguration {

  @Override
  protected List<String> getBootstrapHosts() {
    return Arrays.asList("localhost");
  }

  @Override
  protected String getBucketName() {
    return "my-document";
  }

  @Override
  protected String getBucketPassword() {
    return "";
  }
}