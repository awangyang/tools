package com.example.tools.poi;

import freemarker.core.ParseException;
import freemarker.template.*;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @author wangyang
 * @date 2019/10/15
 */
public class WordUtil {
    /**
     * 日志对象
     **/
    private static final Logger LOGGER = Logger.getLogger(WordUtil.class);

    /**
     * 临时目录
     **/
    private static final String TEMP_PATH = "temp/";

    /**
     * 临时docx文件
     **/
    private static final String TEMP_FILE_DOCX = "temp.docx";

    /**
     * utf-8字符编码
     **/
    private static final String CHARSET_UTF8 = "UTF-8";

    /**
     * 缓冲区大小1M
     **/
    private static final int BUFFER_SIZE = 1024 * 1024;

    /**
     * 私有构造器
     **/
    private WordUtil() {
    }

    /**
     * 根据模板生成新的word2003文档
     *
     * @param modelPath 模板存放路径，例如：/template/word/word2003.xml
     * @param savePath  新文档保存路径，例如：D:/word/word2003.doc
     * @param map       写入文档的数据
     */
    public static void createWord2003(String modelPath, String savePath, Map<String, Object> map) {
        Template template = getTemplate(modelPath);
        if (template != null) {
            File file = createFile(savePath);
            try (Writer out = new OutputStreamWriter(new FileOutputStream(file))) {
                template.process(map, out);
            } catch (TemplateException | IOException e) {
                LOGGER.error("生成word2003文档失败", e);
            }
        }
    }

    /**
     * 根据模板生成新的word2003文档，以字节数组返回
     *
     * @param modelPath 模板存放路径，例如：/template/word/word2003.xml
     * @param map       写入文档的数据
     * @return byte[] 字节数组
     */
    public static byte[] createWord2003(String modelPath, Map<String, Object> map) {
        Template template = getTemplate(modelPath);
        if (template != null) {
            return createNewTemp(template, map);
        }
        return new byte[0];
    }

    /**
     * 根据模板生成新的word2007文档
     *
     * @param modelPathXml  模板存放路径，例如：/template/word/word2007.xml
     * @param modelPathDocx 模板原文档，例如：/template/word/word2007.docx
     * @param savePath      新文档保存路径，例如：D:/word/word2007.docx
     * @param map           写入文档的数据
     */
    public static void createWord2007(String modelPathXml, String modelPathDocx, String savePath, Map<String, Object> map) {
        ZipFile zipFile = null;
        ZipOutputStream zipOut = null;
        try {
            Template template = getTemplate(modelPathXml);
            byte[] bytes = createNewTemp(template, map);
            outTempFile(modelPathDocx); // 写出临时文件（因Linux环境无法直接读取modelPathDocx路径）
            zipFile = new ZipFile(new File(TEMP_PATH + TEMP_FILE_DOCX)); // 读取临时文件
            Enumeration<? extends ZipEntry> zipEntrys = zipFile.entries();
            zipOut = new ZipOutputStream(new FileOutputStream(savePath));
            int len = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while (zipEntrys.hasMoreElements()) {
                ZipEntry entry = zipEntrys.nextElement();
                zipOut.putNextEntry(new ZipEntry(entry.toString()));
                if ("word/document.xml".equals(entry.toString())) {
                    zipOut.write(bytes);
                } else {
                    try (InputStream is = zipFile.getInputStream(entry)) {
                        while ((len = is.read(buffer)) != -1) {
                            zipOut.write(buffer, 0, len);
                        }
                    } catch (IOException e) {
                        LOGGER.error("操作流失败", e);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("生成word2007文档失败", e);
        } finally {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    LOGGER.error("关闭流失败", e);
                }
            }
            if (zipOut != null) {
                try {
                    zipOut.close();
                } catch (IOException e) {
                    LOGGER.error("关闭流失败", e);
                }
            }
            deleteFiles(TEMP_PATH); // 删除临时文件
        }
    }

    /**
     * 根据模板生成新的word2007文档，以字节数组返回
     *
     * @param modelPathXml  模板存放路径，例如：/template/word/word2007.xml
     * @param modelPathDocx 模板原文档，例如：/template/word/word2007.docx
     * @param map           写入文档的数据
     * @return byte[]
     */
    public static byte[] createWord2007(String modelPathXml, String modelPathDocx, Map<String, Object> map) {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ZipFile zipFile = null;
        ZipOutputStream zipOut = null;
        try {
            Template template = getTemplate(modelPathXml);
            byte[] bytes = createNewTemp(template, map);
            outTempFile(modelPathDocx); // 写出临时文件（因Linux环境无法直接读取modelPathDocx路径）
            zipFile = new ZipFile(new File(TEMP_PATH + TEMP_FILE_DOCX)); // 读取临时文件
            Enumeration<? extends ZipEntry> zipEntrys = zipFile.entries();
            zipOut = new ZipOutputStream(byteStream);
            int len = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while (zipEntrys.hasMoreElements()) {
                ZipEntry entry = zipEntrys.nextElement();
                zipOut.putNextEntry(new ZipEntry(entry.toString()));
                if ("word/document.xml".equals(entry.toString())) {
                    zipOut.write(bytes);
                } else {
                    try (InputStream is = zipFile.getInputStream(entry)) {
                        while ((len = is.read(buffer)) != -1) {
                            zipOut.write(buffer, 0, len);
                        }
                    } catch (IOException e) {
                        LOGGER.error("操作流失败", e);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("生成word2007文档失败", e);
        } finally {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    LOGGER.error("关闭流失败", e);
                }
            }
            if (zipOut != null) {
                try {
                    zipOut.close();
                } catch (IOException e) {
                    LOGGER.error("关闭流失败", e);
                }
            }
            deleteFiles(TEMP_PATH); // 删除临时文件
        }
        return byteStream.toByteArray();
    }

    /**
     * 写出临时文件
     *
     * @param modelPathDocx word2007原文档存放路径
     */
    private static void outTempFile(String modelPathDocx) {
        InputStream input = WordUtil.class.getClassLoader().getResourceAsStream(modelPathDocx);
        if (input != null) {
            try (FileOutputStream fos = new FileOutputStream(createFile(TEMP_PATH + TEMP_FILE_DOCX))) {
                int len = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((len = input.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            } catch (IOException e) {
                LOGGER.error("写出临时文件失败", e);
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                    LOGGER.error("关闭输入流失败", e);
                }
            }
        }
    }

    /**
     * 删除该目录下所有文件
     *
     * @param filePath 文件目录路径，如：d:/test/
     */
    public static boolean deleteFiles(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File f : files) {
                    if (f.isFile() && f.delete()) {
                        LOGGER.info("删除" + f.getName() + "文件成功");
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 删除单个文件
     *
     * @param filePath 文件目录路径，如：d:/test/
     * @param fileName 文件名称，如：110.doc
     */
    public static boolean deleteFile(String filePath, String fileName) {
        File file = new File(filePath);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File f : files) {
                    if (f.isFile() && f.getName().equals(fileName)) {
                        return f.delete();
                    }
                }
            }
        }
        return false;
    }

    /**
     * 写入数据，生成新的模板文件以字节数组返回
     *
     * @param template 模板对象
     * @param map      写入文档的数据
     * @return byte[]
     */
    private static byte[] createNewTemp(Template template, Map<String, Object> map) {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try (Writer out = new OutputStreamWriter(byteStream)) {
            template.process(map, out);
        } catch (TemplateException | IOException e) {
            LOGGER.error("生成新模板文件失败", e);
        }
        return byteStream.toByteArray();
    }

    /**
     * 创建文件对象
     *
     * @param filePath 文件路径，例如：temp/test.doc
     * @return File
     */
    private static File createFile(String filePath) {
        File file = null;
        try {
//            // 创建文件目录
//            file = new File(filePath.substring(0, filePath.lastIndexOf('/')));
//            if (!file.exists()) {
//                file.mkdirs();
//            }
            // 创建文件对象
            file = new File(filePath);
            if (!file.exists() && file.createNewFile()) {
                LOGGER.info("创建文件对象成功");
            }
        } catch (IOException e) {
            LOGGER.error("创建文件对象失败", e);
        }
        return file;
    }

    /**
     * 获取模板对象
     *
     * @param modelPath 模板存放路径
     * @return
     */
    private static Template getTemplate(String modelPath) {
        Template template = null;
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_25);
            configuration.setEncoding(Locale.getDefault(), CHARSET_UTF8);
            configuration.setClassForTemplateLoading(WordUtil.class, modelPath.substring(0, modelPath.lastIndexOf('/')));
            template = configuration.getTemplate(modelPath.substring(modelPath.lastIndexOf('/') + 1));
        } catch (TemplateNotFoundException | MalformedTemplateNameException | ParseException e) {
            LOGGER.error("读取模板失败", e);
            System.out.println("读取模板失败");
        } catch (IOException e) {
            LOGGER.error("创建模板对象失败", e);
            System.out.println("创建模板对象失败");
        }
        return template;
    }

}
