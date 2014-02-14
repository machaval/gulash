package org.mule.dsl.builder.core;

import groovy.lang.Closure;
import org.mule.api.MuleContext;
import org.mule.api.config.ConfigurationException;
import org.mule.dsl.builder.apikit.MessageProcessorBuilder;

import java.util.ArrayList;
import java.util.List;


public class GroovyBuilder implements MessageProcessorBuilder<GroovyMessageProcessor> {


    Closure closure;
    List params;

    GroovyBuilder(Closure closure) {
        this.closure = closure;
        params = new ArrayList();
    }

    @Override
    public GroovyMessageProcessor build(MuleContext muleContext) throws ConfigurationException, IllegalStateException {
        return new GroovyMessageProcessor(this.closure,this.params);
    }

    public GroovyBuilder withParam(Object param) {
        params.add(param);
        return this;
    }
}
