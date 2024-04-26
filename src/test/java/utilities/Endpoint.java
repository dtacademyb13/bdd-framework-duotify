package utilities;

public enum Endpoint {

    USER ("/user"),
    USERS ("/users"),

    PLAYLISTS ("/playlists"),

    LOGIN ("/login");


    private final String value;

    Endpoint(String value) {
       this.value = value;
    }

    public String getValue() {
        return value;
    }
}
