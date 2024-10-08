/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Agents | Templates
 * and open the template in the editor.
 */
package com.comp.model.dataset;

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
public class DatasetRepositoryImpl implements DatasetRepositoryCustom {
    
    @Autowired
    private MongoTemplate mt;

    @Override
    public List<Dataset> getDatasets(DatasetFilters datasetFilters, PaginationFilters paginationFilters) {
         List <Dataset> datasets = new ArrayList<>();
         Query query = new Query();
         
         if(paginationFilters != null){
            query = PaginationMethods.paginationQueryBuilder(query, paginationFilters);
        }
         
        if(datasetFilters!=null){
            if(datasetFilters.getId() !=null){
                query.addCriteria(Criteria.where("_id").is(datasetFilters.getId().toUpperCase()));
            }
            if(datasetFilters.getVisibility()!=null){
                query.addCriteria(Criteria.where("visibility").is(datasetFilters.getVisibility()));
            }
            if(datasetFilters.getCommunity_id()!=null){
                query.addCriteria(Criteria.where("community_ids").in(datasetFilters.getCommunity_id().toUpperCase()));
            }
            if(datasetFilters.getChallenge_id()!=null){
                query.addCriteria(Criteria.where("challenge_ids").in(datasetFilters.getChallenge_id().toUpperCase()));
            }
            if(datasetFilters.getType()!=null){
                query.addCriteria(Criteria.where("type").is(datasetFilters.getType()));
            }
        }
        
        datasets = mt.find(query,Dataset.class);
        return datasets;
    }
}
