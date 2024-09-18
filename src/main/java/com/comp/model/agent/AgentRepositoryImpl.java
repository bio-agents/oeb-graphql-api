/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Agents | Templates
 * and open the template in the editor.
 */
package com.comp.model.agent;

import com.comp.pagination.PaginationFilters;
import com.comp.pagination.PaginationMethods;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author vsundesh
 */
public class AgentRepositoryImpl implements AgentRepositoryCustom{
    
    @Autowired
    private MongoTemplate mt;

    @Override
    public List<Agent> getAgents(AgentFilters agentFilters, PaginationFilters paginationFilters) {
        List <Agent> agents = new ArrayList<>();
         Query query = new Query();
         
        if(paginationFilters != null){
            query = PaginationMethods.paginationQueryBuilder(query, paginationFilters);
        }
         
        if(agentFilters!=null){
            if(agentFilters.getId() !=null){
                query.addCriteria(Criteria.where("_id").is(agentFilters.getId().toUpperCase()));
            }
            if(agentFilters.getCommunity_id() !=null){
                query.addCriteria(Criteria.where("community_ids").in(agentFilters.getCommunity_id().toUpperCase()));
            }
        }
        
        agents = mt.find(query,Agent.class);
        return agents;
    }
    
    
    
    
}
