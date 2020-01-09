package com.spring.rest.template.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.template.service.MyAsyncService;
import com.spring.rest.template.service.MyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/resttemplate")
public class MyController {

    @Autowired
    private MyService myService;
    @Autowired
    private MyAsyncService myAsyncService;
    
    /**
     * Go to 
     * http://localhost:8080/api/resttemplate/someId
     * http://localhost:8080/swagger-ui.html
     * @param id
     * @return {@code String}
     */
    //@PreAuthorize("hasRole('')")    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "get", nickname = "get")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized"), 
            @ApiResponse(code = 500, message = "Failure") })
    public String get(@PathVariable String id) {
      return myService.get(id);   
    }
    
    //@PreAuthorize("hasAnyRole('')")
    @RequestMapping(value = "/async/{id}", method = RequestMethod.GET)    
    @ApiOperation(value = "Aysnc testing")
    @ResponseStatus(HttpStatus.OK)
    public String getAsync(@PathVariable String id) throws InterruptedException, ExecutionException {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick off multiple, asynchronous lookups
        Future<String> result1 = myAsyncService.get("result1 " + id);
        Future<String> result2 = myAsyncService.get("result2 " + id);
        Future<String> result3 = myAsyncService.get("result3 " + id);

        // Wait until they are all done
        while (!(result1.isDone() && result2.isDone() && result3.isDone())) {
            Thread.sleep(10); // 10-millisecond pause between each check
        }

        // Print results, including elapsed time
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());
        return id;
    }
    
    //@PreAuthorize("hasAnyRole('')")
    @RequestMapping(value = "/async/session/{id}", method = RequestMethod.GET)    
    @ApiOperation(value = "Aysnc Session Testing")
    @ResponseStatus(HttpStatus.OK)
    public String getSession(@PathVariable String id) throws InterruptedException, ExecutionException {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick off multiple, asynchronous lookups
        Future<String> result1 = myAsyncService.getSession("result1 " + id);
        Future<String> result2 = myAsyncService.getSession("result2 " + id);
        Future<String> result3 = myAsyncService.getSession("result3 " + id);

        // Wait until they are all done
        while (!(result1.isDone() && result2.isDone() && result3.isDone())) {
            Thread.sleep(10); // 10-millisecond pause between each check
        }

        // Print results, including elapsed time
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());
        return id;
    }
}