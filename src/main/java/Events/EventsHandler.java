package Events;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventsHandler {
    private Map<EventsEnum, Map<Long, List<EventsListener>>> eventListenersMap;
    private static EventsHandler eventsHandler = null;

    private EventsHandler() {
        eventListenersMap = new HashMap<EventsEnum, Map<Long, List<EventsListener>>>();
    }

    public static EventsHandler getInstance(){
        if(eventsHandler == null){
            synchronized (EventsHandler.class) {
                if(eventsHandler == null){
                    eventsHandler = new EventsHandler();
                }
            }
        }
        return eventsHandler;
    }

    public void registerEvent(Long gameId, EventsEnum event, EventsListener listener) {

        if (eventListenersMap.get(event) == null) {
            List<EventsListener> eventListener = new ArrayList<EventsListener>();
            eventListener.add(listener);
            Map<Long, List<EventsListener>> gameEventsMap = new HashMap<Long, List<EventsListener>>();
            gameEventsMap.put(gameId, eventListener);
            eventListenersMap.put(event, gameEventsMap);
        }else {
            if (eventListenersMap.get(event).get(gameId) == null){
                List<EventsListener> eventListener = new ArrayList<EventsListener>();
                eventListener.add(listener);
                eventListenersMap.get(event).put(gameId, eventListener);
            }else {
                eventListenersMap.get(event).get(gameId).add(listener);
            }
        }
    }

    public void notifyEvent(Long gameId, EventsEnum event) {
        for (EventsListener listener: eventListenersMap.get(event).get(gameId)) {
            listener.update(event);
        }
    }
}
