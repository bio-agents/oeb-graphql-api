/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Agents | Templates
 * and open the template in the editor.
 */
package com.comp.model.agent;

import com.comp.model.utils.AgentAccess;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author vsundesh
 */
@Document (collection="Agent")
public class Agent {
    private String _id;
    private String _schema;
    private String registry_agent_id;
    private String name;
    private List<String> community_ids;
    private String description;
    private Boolean is_automated;
    private List<String> agent_contact_ids;
    private String status;
    private String activation;
    private String deactivation;
    private List<String> references;
    private List<AgentAccess> agent_access;
    private Object _metadata;
    
}
