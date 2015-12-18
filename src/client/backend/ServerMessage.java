package client.backend;

/**
 * Created by LU on 15/12/18.
 */
public class ServerMessage {
    public boolean success;
    public String message;

    public ServerMessage(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ServerMessage(boolean success) {
        this.success = success;
        this.message = "";
    }
}
