/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Agents | Templates
 * and open the template in the editor.
 */
package com.comp.model.community;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vsundesh
 */
@Repository
public interface CommunityRepository extends CommunityRepositoryCustom, MongoRepository<Community, String>{

    
    
}
