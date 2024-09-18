/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Agents | Templates
 * and open the template in the editor.
 */
package com.comp.model.challenge;

import com.comp.pagination.PaginationFilters;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vsundesh
 */
@Repository
public interface ChallengeRepositoryCustom {
    public List<Challenge> getChallenges(ChallengeFilters challengeFilters, PaginationFilters pagination);
}
