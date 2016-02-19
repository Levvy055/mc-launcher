package com.subakstudio.mclauncher;

import com.subakstudio.http.OkHttpClientHelper;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.File;

/**
 * Created by yeoupooh on 2/19/16.
 */
public class DownloadFileService extends Service {

    //    private StringProperty url = new SimpleStringProperty();
    private String url;
    private String fileName;

    public void setUrl(String value) {
//        url.setValue(value);
        url = value;
    }

    public final String getUrl() {
//        return url.get();
        return url;
    }

//    public final StringProperty urlProperty() {
//        return url;
//    }

    @Override
    protected Task createTask() {
        final String _url = getUrl();
        final String _fileName = getFileName();

        return new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                OkHttpClientHelper httpClient = new OkHttpClientHelper();
                httpClient.downloadBinary(_url, new File("test.bin"));
                return true;
            }
        };
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
