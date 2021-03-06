package cn.rongcloud.im.utils;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

import cn.rongcloud.im.common.LogTag;
import cn.rongcloud.im.utils.log.SLog;

public class FileUtils {
    public static String saveBitmapToFile(Bitmap bitmap, File toFile) {
        try {
            FileOutputStream fos = new FileOutputStream(toFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);

            fos.flush();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        SLog.e(LogTag.FILE, "save image to path:" + toFile.getPath());

        return toFile.getPath();
    }

    public static String saveBitmapToPublicPictures(Bitmap bitmap, String fileName) {
        File publicDownloadDirectoryFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!publicDownloadDirectoryFile.exists()) {
            publicDownloadDirectoryFile.mkdirs();
        }

        File saveFile = new File(publicDownloadDirectoryFile, fileName);
        return saveBitmapToFile(bitmap, saveFile);
    }
}
