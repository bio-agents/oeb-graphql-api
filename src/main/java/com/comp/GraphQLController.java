/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Agents | Templates
 * and open the template in the editor.
 */
package com.comp;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionInput;
import graphql.GraphQL;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vsundesh
 */
@RestController
public class GraphQLController {
    private final GraphQL graphql;
    private final ObjectMapper objectMapper;

    @Autowired
    public GraphQLController(GraphQL graphql, ObjectMapper objectMapper) {
        this.graphql = graphql;
        this.objectMapper = objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    @RequestMapping(value = "/graphql", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Map<String, Object> graphqlGET(@RequestParam("query") String query,
                                          @RequestParam(value = "operationName", required = false) String operationName,
                                          @RequestParam(value = "variables", required = false) String variablesJson
    ) throws IOException {
        Map<String, Object> variables = new LinkedHashMap<>();
        if (variablesJson != null) {
            variables = objectMapper.readValue(variablesJson, new TypeReference<Map<String, Object>>() {
            });
        }
        return executeGraphqlQuery(query, operationName, variables);
    }


    @RequestMapping(value = "/graphql", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Map<String, Object> graphql(@RequestBody Map<String, Object> body) {
        
        String query = (String) body.get("query");
        if (query == null) {
            query = "";
        }
        String operationName = (String) body.get("operationName");
        Map<String, Object> variables = (Map<String, Object>) body.get("variables");
        if (variables == null) {
            variables = new LinkedHashMap<>();
        }
        return executeGraphqlQuery(query, operationName, variables);
    }

    private Map<String, Object> executeGraphqlQuery(String query, String operationName, Map<String, Object> variables) {
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(query)
                .operationName(operationName)
                .variables(variables)
                .build();
        return this.graphql.execute(executionInput).toSpecification();
    }
}
