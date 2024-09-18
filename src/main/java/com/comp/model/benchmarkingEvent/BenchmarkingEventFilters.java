/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Agents | Templates
 * and open the template in the editor.
 */
package com.comp.model.benchmarkingEvent;

import org.springframework.stereotype.Component;

/**
 *
 * @author vsundesh
 */
@Component
public class BenchmarkingEventFilters {
    private String id;
    private String community_id;

    public BenchmarkingEventFilters() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }
    
}
