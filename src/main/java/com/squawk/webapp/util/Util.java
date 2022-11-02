package com.squawk.webapp.util;

import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.InputStream;

public class Util {
    public static String getFileName(Part part){
        String contentDisposition = part.getHeader("content-disposition");

        if (!contentDisposition.contains("filename=")){
            return null;
        }

        int beginIndex = contentDisposition.indexOf("filename=") + 10;
        int endIndex = contentDisposition.length() - 1;

        return contentDisposition.substring(beginIndex,endIndex);
    }
}
