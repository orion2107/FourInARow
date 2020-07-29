package Events;

public enum EventsEnum {

    QUIT(1, "Bye Bye"),
    PLAYER_MOVED(2, "player made move"),
    PLAYER_NAME_CHANGED(4, "Player name changed"),
    GAME_MODE_CHANGED(5, "Game Mode Changed"),
    GAME_QUIT(6, "Game quit"),
    WINNER(7, "We Have a winner");

    private final Integer key;
    private final String value;

    EventsEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
