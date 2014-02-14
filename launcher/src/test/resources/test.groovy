import org.mule.api.MuleEvent
import org.mule.dsl.builder.core.StartListener
import org.mule.dsl.builder.core.GroovyCore



mule.declare(
                flow("Hello")
                        .chain(logger().withMessage("#[payload]"))
                        .chain(GroovyCore.groovy(
                            {MuleEvent event , payload ->
                                println("function called");
                                println(payload)
                                return event
                            }).withParam("must evaluate #[payload]"))
        );

mule.onStart(
    { mule ->
        def result = mule.callFlow("Hello", "Hello");
        def payload = result.getMessage().getPayload()
        println "payload = $payload"
    } as StartListener)
