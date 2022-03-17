package dev.kaira.consumer;

import dev.kaira.model.Quote;
import io.smallrye.reactive.messaging.annotations.Blocking;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class QuotesProcessor {

    private Random random = new Random();


    @Incoming("requests")
    @Broadcast
    @Outgoing("quotes")
    @Blocking
    public Quote process(String quoteRequest) throws InterruptedException {
        Thread.sleep(200);
        return new Quote(quoteRequest, random.nextInt(100));
    }
}
