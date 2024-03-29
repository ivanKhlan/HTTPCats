package http;

import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");

        int statusCode = 0;

        try {
            statusCode = scanner.nextInt();
            new HttpStatusImageDownloader().downloadStatusImage(statusCode);

        } catch (Exception e) {
            throw new Exception("There is not image for HTTP status " + statusCode);
        }

    }
}
