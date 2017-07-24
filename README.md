# spring-es-sample
Small example of Spring-Es integration (Spring Boot + Elasticsearch 5.4.0 + MongoDb)
 
Application shows how to use [spring-es](https://github.com/chirkovd/spring-es) project: store data in MongoDB, add index to Elasticsearch.
 Results loading with active filters and limits is implemented by ES engine, after that results are fetched from MongoDb by id and merged with ES results.
  
Spring Data for Elasticsearch is not used, because it doesn't support ES 5.* version now. 
