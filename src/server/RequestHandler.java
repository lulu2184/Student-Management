package server;


import java.io.*;

/**
 * Created by LU on 15/12/13.
 */
public class RequestHandler {
    private static final String FAILED = "FAILED\r\n";
    private static final String OK = "OK\r\n";
    private static final String dirPath = "/Users/LU/Desktop/SS/data/";
    private static final String filePrefix = "SMS_";

    private String request;

    public RequestHandler(String request) {
        this.request = request;
    }

    public String getResponse() {
        String[] items = request.split("\n", 2);
        if (items.length == 0) {
            return(FAILED);
        }
        if (items[0].equals("ADD")) {
            return items.length < 2 ? FAILED : addStudent(items[1]);
        } else if (items[0].equals("DELETE")) {
            return items.length < 2 ? FAILED : deleteStudent(items[1]);
        } else if (items[0].equals("GET_LIST")) {
            return getStudentList();
        } else if (items[0].equals("GET_INFO")) {
            return items.length < 2 ? FAILED : getStudentInfo(items[1]);
        } else {
            return(FAILED);
        }
    }

    private String addStudent(String content) {
        if (content.startsWith("Number:")) {
            String path = content.substring("Number:".length()).split("\\|")[0];
            if (!path.matches("^\\d*$")) return FAILED;
            path = dirPath + filePrefix + path;
            File file = new File(path);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                    FileWriter writer = new FileWriter(file);
                    writer.write(content);
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return FAILED;
            }
            return OK;
        } else {
            return FAILED;
        }
    }

    private String deleteStudent(String content) {
        if (content.startsWith("Number:")) {
            String path = dirPath + content.substring("Number: ".length());
            File file = new File(path);
            if (file.isFile() && file.exists()) {
                file.delete();
                return OK;
            }
        }
        return FAILED;
    }

    private String getStudentList() {
        File dirFile = new File(dirPath);
        if (!dirFile.isDirectory() || !dirFile.exists()) {
            return FAILED;
        }
        File[] fileList = dirFile.listFiles();
        String result = new String();
        Boolean flag = false;
        for (File file : fileList) {
            if (!file.getName().startsWith(filePrefix)) continue;
            if (flag) result += "|";
            result += file.getName().substring(filePrefix.length());
            flag = true;
        }
        return OK + result;
    }

    private String getStudentInfo(String content) {
        if (content.startsWith("Number:")) {
            String path = dirPath + content.substring("Number: ".length());
            try {
                FileReader file = new FileReader(path);
                String result = new String();
                BufferedReader buffer = new BufferedReader(file);
                String str;
                while ((str = buffer.readLine()) != null) {
                    result += str + "\r\n";
                }
                buffer.close();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                return FAILED;
            }
        }
        return FAILED;
    }
}
