package org.mule.dsl.builder.core

import org.mule.api.MuleContext
import org.mule.api.config.ConfigurationException
import org.mule.dsl.builder.apikit.MessageProcessorBuilder

class GroovyBuilder implements MessageProcessorBuilder<GroovyMessageProcessor> {


    def closure
    def params

    GroovyBuilder(closure) {
        this.closure = closure
        params = []
    }

    @Override
    GroovyMessageProcessor build(MuleContext muleContext) throws ConfigurationException, IllegalStateException {
        return new GroovyMessageProcessor(this.closure,this.params);
    }

    public GroovyBuilder withParam(Object param) {
        params.add(param)
        return this
    }
}
