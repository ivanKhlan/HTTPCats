package http;

import storage.Storage;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public static final String REQUEST = "https://http.cat/${code}.jpg";

    public String getStatusImage(int code) {

        String url = REQUEST.replace("${code}", String.valueOf(code));
            try {

                URL request = new URL(url);

                HttpURLConnection connection = (HttpURLConnection) request.openConnection();

                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (checkValidResponseCode(responseCode)) {
                    throw new Exception();
                }

            } catch (Exception e) {

                try {
                    throw new Exception("invalid code");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

        return url;

    }

    public boolean checkValidResponseCode(int code) {
        return code == 404;
    }
}
