/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Agents | Templates
 * and open the template in the editor.
 */
package com.comp.model.agent;

import com.comp.pagination.PaginationFilters;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vsundesh
 */
@Repository
public interface AgentRepositoryCustom {
    public List<Agent> getAgents(AgentFilters agentFilters, PaginationFilters pagination);
}
