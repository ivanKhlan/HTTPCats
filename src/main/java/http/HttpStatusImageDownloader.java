package http;

import storage.Storage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws IOException {

        String urlDownload = new HttpStatusChecker().getStatusImage(code);
        URL request = new URL(urlDownload);
        HttpURLConnection connection = (HttpURLConnection) request.openConnection();

        InputStream inputStream = connection.getInputStream();
        String saveFilePath = "D:/HTTPCats" + File.separator + code + " cat.png";

        FileOutputStream outputStream = new FileOutputStream(saveFilePath);

        int bytesRead;
        byte[] buffer = new byte[4096];
        while ((bytesRead = inputStream.read(buffer)) != -1) {

            outputStream.write(buffer, 0, bytesRead);

        }
        outputStream.close();
        inputStream.close();
    }
}
