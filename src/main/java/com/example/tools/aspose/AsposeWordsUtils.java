package com.example.tools.aspose;


import com.aspose.words.Document;
import com.aspose.words.HtmlSaveOptions;
import com.aspose.words.Range;
import com.aspose.words.SaveFormat;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 支持文档模板替换内容、文档与html 相互转换工具
 * <p>
 * 注意 ： 在Linux中使用时需要安装字体库
 *
 * @author wangyang
 * @date 2019/10/31
 */
public class AsposeWordsUtils {
    /**
     * 根据模板中的占位符 替换成 map 中的 value
     * <p>
     * map中key为文章中的占位符 ，value为替换的内容
     * <p>
     * 例如：key = "${{title}}"  value="标题"
     * key = "${{content}}"  value="内容"
     *
     * @param file 文档文件
     * @param map  key：占位符,value：需要替换的内容
     * @return
     */
    public static Document replaceWords(File file, Map<String, String> map) throws Exception {
        return replaceWords(new FileInputStream(file), map);
    }

    public static Document replaceWords(byte[] bytes, Map<String, String> map) throws Exception {
        return replaceWords(new ByteArrayInputStream(bytes), map);
    }

    public static Document replaceWords(InputStream inputStream, Map<String, String> map) throws Exception {
        Document doc = new Document(inputStream);
        replace(doc, map);
        return doc;
    }

    /**
     * 具体替换实现
     *
     * @param doc
     * @param map
     * @throws Exception
     */
    private static void replace(Document doc, Map<String, String> map) throws Exception {
        Range range = doc.getRange();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            range.replace(entry.getKey(), entry.getValue(), false, false);
        }
    }


    /**
     * 文章字节数组转 html
     *
     * @param bytes 文章字节数组
     * @return
     */
    public static String toHtml(byte[] bytes) throws Exception {
        return toHtml(new ByteArrayInputStream(bytes));
    }

    /**
     * 文章转 html
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static String toHtml(File file) throws Exception {
        return toHtml(new FileInputStream(file));
    }

    /**
     * 文章输入流转 html
     *
     * @param inputStream 文章输入流
     * @return
     */
    public static String toHtml(InputStream inputStream) throws Exception {
        return toHtml(new Document(inputStream));
    }

    /**
     * Document 转成 html
     *
     * @param document com.aspose.words.Document 对象
     * @return
     */
    public static String toHtml(Document document) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HtmlSaveOptions options = new HtmlSaveOptions(SaveFormat.HTML);
        options.setImageSavingCallback(new ImageSavingCallback());
        /**
         * 图片转存 Base64 格式
         */
        options.setExportImagesAsBase64(true);
        document.save(os, options);
        return new String(os.toByteArray(), StandardCharsets.UTF_8);
    }

    /**
     * html 转 file
     *
     * @param html       html字符串
     * @param path       文件路径
     * @param saveFormat 文件格式
     * @return
     * @throws Exception
     */
    public static File toFile(String html, String path, int saveFormat) throws Exception {
        return toFile(html.getBytes(), path, saveFormat);
    }

    /**
     * @param bytes
     * @param path       文件路径
     * @param saveFormat 文件格式
     * @return
     * @throws Exception
     */
    public static File toFile(byte[] bytes, String path, int saveFormat) throws Exception {
        return toFile(new ByteArrayInputStream(bytes), path, saveFormat);
    }

    /**
     * @param is
     * @param path       文件路径
     * @param saveFormat 文件格式
     * @return
     * @throws Exception
     */
    public static File toFile(InputStream is, String path, int saveFormat) throws Exception {
        return toFile(new Document(is), path, saveFormat);

    }


    /**
     * @param document
     * @param path       文件路径
     * @param saveFormat 文件格式
     * @return
     */
    public static File toFile(Document document, String path, int saveFormat) throws Exception {
        File file = new File(path);
        OutputStream os = new FileOutputStream(file);
        document.save(os, saveFormat);
        return file;
    }
}
