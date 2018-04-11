package com.copm.demonstrationSystem.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author: Yuan Baiyu
 * @Date: Created in 14:49 2018/4/9
 */

public class FileUtil {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {

        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

}
