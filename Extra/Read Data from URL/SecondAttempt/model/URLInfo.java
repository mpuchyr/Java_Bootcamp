package model;

import java.net.*;

public class URLInfo {
    
    private String urlAsString;
    private String protocol;
    private String host;
    private String file;

    public URLInfo(String urlString) {
        if (urlString.isBlank() || urlString == null) {
            throw new IllegalArgumentException("urlString cannot be blank/null");
        }
        
        try {
            URL url = new URL(urlString);
            this.urlAsString = urlString;
            this.protocol = url.getProtocol();
            this.host = url.getHost();
            this.file = url.getFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getUrlAString() {
        return this.urlAsString;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getHost() {
        return this.host;
    }

    public String getFile() {
        return this.file;
    }

    public void setHost(String urlString) {
        if (urlString.isBlank() || urlString == null) {
            throw new IllegalArgumentException("urlString cannot be blank/null");
        }

        try {
            URL url = new URL(urlString);
            this.urlAsString = urlString;
            this.protocol = url.getProtocol();
            this.host = url.getHost();
            this.file = url.getFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String toString() {
        return "URL: " + this.urlAsString + "\n"
            + "Protocol: " + this.protocol + "\n"
            + "Host: " + this.host + "\n"
            + "File: " + this.file + "\n";
    }
}
