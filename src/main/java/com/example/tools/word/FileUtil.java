package com.example.tools.word;

import java.io.*;

/**
 * @author wangyang
 * @date 2019/09/26
 */
public class FileUtil {
    //将文件转换成Byte数组
    public static byte[] getBytesByFile(String pathStr) {
        File file = new File(pathStr);
        return getBytesByFile(file);
    }

    //将文件转换成Byte数组
    public static byte[] getBytesByFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            byte[] data = bos.toByteArray();
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //将Byte数组转换成文件
    public static File getFileByBytes(byte[] bytes, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

//    public static String getMimeType(File file) {
//        if (file.isDirectory()) {
//            return "the target is a directory";
//        }
//
//        AutoDetectParser parser = new AutoDetectParser();
//        parser.setParsers(new HashMap<MediaType, Parser>());
//
//        Metadata metadata = new Metadata();
//        metadata.add(TikaMetadataKeys.RESOURCE_NAME_KEY, file.getName());
//
//        InputStream stream;
//        try {
//            stream = new FileInputStream(file);
//            parser.parse(stream, new DefaultHandler(), metadata, new ParseContext());
//            stream.close();
//        } catch (TikaException | SAXException | IOException e) {
//            e.printStackTrace();
//        }
//
//        return metadata.get(HttpHeaders.CONTENT_TYPE);
//    }


}
