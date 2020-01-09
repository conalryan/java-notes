# _spring_couchbase_notes

## Run App for the First Time
1. Start Couchbase.
2. Create a new Bucket:
  - Go to http://127.0.0.1:8091/ui/index.html#/buckets.
  - Click "Create New Data Bucket".
  - Enter Bucket Name: "my-document".
3. Start Spring.
4. Create a Document to POST in Couchbase
  - Using Postman:
  localhost:8080/api/mydocument
  ```json
  {
      "id": "123",
      "name": "Mr.Tester",
      "desc": "I'm trying to test this thing"
  }
  ```
 5. Retrieve the Document you created in step 4 from Couchbase
  - localhost:8080/api/mydocument/id/123
  ```json
  {
      {"id":"123","name":"Mr.Tester","created":{"centuryOfEra":20,"yearOfEra":2017,"yearOfCentury":17,"weekyear":2017,"monthOfYear":10,"weekOfWeekyear":42,"hourOfDay":12,"minuteOfHour":3,"secondOfMinute":44,"millisOfSecond":781,"millisOfDay":43424781,"secondOfDay":43424,"minuteOfDay":723,"dayOfYear":291,"dayOfWeek":3,"dayOfMonth":18,"year":2017,"era":1,"chronology":{"zone":{"fixed":false,"uncachedZone":{"cachable":true,"fixed":false,"id":"America/New_York"},"id":"America/New_York"}},"zone":{"fixed":false,"uncachedZone":{"cachable":true,"fixed":false,"id":"America/New_York"},"id":"America/New_York"},"millis":1508342624781,"beforeNow":true,"equalNow":false,"afterNow":false},"updated":null,"desc":"I'm trying to test this thing"}
  }
  ```
  
## Ad Hoc N1QL Queries
1. You **MUST** create an **INDEX** before using the Ad Hoc N1QL queries otherwise you'll get the following error: 
      
      org.springframework.data.couchbase.core.CouchbaseQueryExecutionException: Unable to execute query due to the following n1ql errors: 
      {"msg":"No index available on keyspace my-document that matches your query. Use CREATE INDEX or CREATE PRIMARY INDEX to create an index, or check that your expected index is online.","code":4000}
2. Create an INDEX:
- The CREATE PRIMARY INDEX statement allows you to create a primary index. Primary indexes contain a full set of keys in a given bucket. Primary indexes are optional and are only required for running ad hoc queries on a bucket that is not supported by a secondary index.
```
CREATE PRIMARY INDEX [index_name]
    ON named_keyspace_ref
    [ USING GSI | VIEW ]
    [ WITH {"nodes": ["node_name"], "defer_build":true|false} ];
```
- USING GSI | VIEW:
  - The USING clause specifies the index type to use. Primary indexes can be created as global secondary indexes (GSI) or views (VIEW). If the USING clause is not specified, by default GSI is used as the indexer.
  
```
CREATE PRIMARY INDEX `my-document-primary-index` ON `my-document` USING GSI;
SELECT * FROM system:indexes WHERE name="my-document-primary-index";
```
3. Retrieve using ad hoc queries
- localhost:8080/api/mydocument/query?name=Mr.Tester
- localhost:8080/api/mydocument/query?description=I'm trying to test this thing
