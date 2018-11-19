package com.example.chen.easygo.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.DIRECTORY_PICTURES;

public class FileUtil {

	
	// SDCard路径
	public static final String SD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
		// 图片存储路径
	public static final String BASE_PATH = SD_PATH + "/hnsafe/apk/";
		// 缓存图片路径
   public static final String BASE_IMAGE_CACHE = BASE_PATH + "cache/";
   
	public static String getSDpath() {
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);
		if (sdCardExist) {
			File f = Environment.getExternalStorageDirectory();
			return f.getPath();
		}
		return "";
	}

	public static boolean existSD() {
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);
		return sdCardExist;
	}
	public static String getImageCache(){
		File dir = new File(BASE_IMAGE_CACHE);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return BASE_IMAGE_CACHE;
	}

	/**
	 * 获得存储bitmap的文件
	 * getExternalFilesDir()提供的是私有的目录，在app卸载后会被删除
	 *
	 * @param context
	 * @param
	 * @return
	 */
	public static String getBitmapDiskFile(Context context) {
		String cachePath;
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
			cachePath = context.getExternalFilesDir(DIRECTORY_PICTURES).getAbsolutePath();
		} else {
			cachePath =context.getFilesDir().getAbsolutePath();
		}
		return new File(cachePath +File.separator+ getBitmapFileName()).getAbsolutePath();
	}

	public static final String bitmapFormat = ".png";

	/**
	 * 生成bitmap的文件名:日期，md5加密
	 *
	 * @return
	 */
	public static String getBitmapFileName() {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			final MessageDigest mDigest = MessageDigest.getInstance("MD5");
			String currentDate = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			mDigest.update(currentDate.getBytes("utf-8"));
			byte[] b = mDigest.digest();
			for (int i = 0; i < b.length; ++i) {
				String hex = Integer.toHexString(0xFF & b[i]);
				if (hex.length() == 1) {
					stringBuilder.append('0');
				}
				stringBuilder.append(hex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileName = stringBuilder.toString() + bitmapFormat;
		return fileName;
	}

}
