package Events;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EventsHandlerTest {

    @Test
    void getInstance() {
        EventsHandler event = EventsHandler.getInstance();
        Assertions.assertEquals(event,EventsHandler.getInstance());
    }

}