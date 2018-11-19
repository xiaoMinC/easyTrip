package com.example.chen.easygo.net.myHttp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class DownLoadManager {
    private static final String TAG = "DownLoadManager";

    private static String APK_CONTENTTYPE = "application/vnd.android.package-archive";

    private static String PNG_CONTENTTYPE = "image/png";

    private static String JPG_CONTENTTYPE = "image/jpg";

    private static String PDF_CONTENTTYPE = "application/pdf";

    private static String fileSuffix = "";

    public static boolean writeResponseBodyToDisk(Context context, ResponseBody body) {

//        L.i( "contentType:>>>>" + body.contentType().toString());

        String type = body.contentType().toString();
//        L.i( "type:>>>>" +type);
        if (type.equals(APK_CONTENTTYPE)) {

            fileSuffix = ".apk";
        } else if (type.equals(PNG_CONTENTTYPE)) {
            fileSuffix = ".png";
        } else if (type.equals(PDF_CONTENTTYPE)) {
            fileSuffix = ".pdf";
        }

        // 其他类型同上 自己判断加入.....
        String path = context.getExternalFilesDir(null) + File.separator + System.currentTimeMillis() + fileSuffix;

//        L.i( "path:>>>>" + path);

        try {
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(path);

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
//                    L.i( "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();


                File pdf = new File(path);
                /**
                 * ComponentName（组件名称）是用来打开其他应用程序中的Activity或服务的。
                 */
                ComponentName comp = new ComponentName("com.dynamixsoftware.printershare", "com.dynamixsoftware.printershare.ActivityPrintPDF");
                Intent intent = new Intent();
                intent.setComponent(comp);
                intent.setAction("android.intent.action.VIEW");
                intent.setType(PDF_CONTENTTYPE);
                intent.setData(Uri.fromFile(pdf));
                context.startActivity(intent);

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

}
