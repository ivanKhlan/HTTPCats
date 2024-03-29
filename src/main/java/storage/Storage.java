package storage;

import http.HttpStatusChecker;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

public class Storage {

    public static final Storage INSTANCE = new Storage();

    private int code;
    private HttpURLConnection httpURLConnection;
    private Storage() {

        String url = HttpStatusChecker.REQUEST.replace("${code}", String.valueOf(getCode()));

        try {
            URL request = new URL(url);
            httpURLConnection = (HttpURLConnection) request.openConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public HttpURLConnection getHttpURLConnection() {
        return httpURLConnection;
    }

    public static Storage getInstance() {
        return INSTANCE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
