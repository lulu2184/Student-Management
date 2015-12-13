package client.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by LU on 15/12/13.
 */
public class ClientTalker {
    public static String request(String content) {
        Socket socket = null;
        String result = null;
        try {
            socket = new Socket("127.0.0.1", 5858);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(content);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str;
            result = new String();
            while ((str = reader.readLine()) != null) {
                result += str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
