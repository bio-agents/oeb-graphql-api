/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Agents | Templates
 * and open the template in the editor.
 */
package com.comp.model.benchmarkingEvent;

import com.comp.model.utils.*;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

/**
 *
 * @author vsundesh
 */
@Component
public class Dates {
    private String creation;
    private String modification;    
    @Field("public")
    private String _public;
    private String benchmark_start;
    private String benchmark_stop;
    
    
}
