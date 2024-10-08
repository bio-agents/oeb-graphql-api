/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Agents | Templates
 * and open the template in the editor.
 */
package com.comp.model.benchmarkingEvent;

import com.comp.model.challenge.Challenge;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 *
 * @author vsundesh
 */
@Document (collection="BenchmarkingEvent")
@Component
public class BenchmarkingEvent {
    
    private String _id;
    private String _schema;
    private String orig_id;
    private String name;
    private Boolean is_automated;
    private Dates dates;
    private String url;
    private String community_id;
    private List<String> bench_contact_ids;
    private List<String> references;
    private Object _metadata;

    public BenchmarkingEvent() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getSchema() {
        return _schema;
    }

    public void setSchema(String _schema) {
        this._schema = _schema;
    }

    public String getOrig_id() {
        return orig_id;
    }

    public void setOrig_id(String orig_id) {
        this.orig_id = orig_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIs_automated() {
        return is_automated;
    }

    public void setIs_automated(Boolean is_automated) {
        this.is_automated = is_automated;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public List<String> getBench_contact_ids() {
        return bench_contact_ids;
    }

    public void setBench_contact_ids(List<String> bench_contact_ids) {
        this.bench_contact_ids = bench_contact_ids;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }
    
    
}
