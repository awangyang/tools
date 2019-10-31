package com.example.tools.poi;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author wangyang
 * @date 2019/10/09
 */
public class Html2Word {

    public static void exportWord(String html, String path) throws Exception {
        try {
            byte b[] = html.getBytes(StandardCharsets.UTF_8);  //这里是必须要设置编码的，不然导出中文就会乱码。
            ByteArrayInputStream bais = new ByteArrayInputStream(b);//将字节数组包装到流中
            /*
             * 关键地方
             * 生成word格式 */
            POIFSFileSystem poifs = new POIFSFileSystem();
//            DirectoryEntry directory = poifs.getRoot();
//            DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);

            DirectoryEntry directory = poifs.getRoot();
            //WordDocument名称不允许修改
            directory.createDocument("WordDocument", bais);
            //输出文件
//            request.setCharacterEncoding("utf-8");
//            response.setContentType("application/msword");//导出word格式
//            response.addHeader("Content-Disposition", "p_w_upload;filename=" +
//                    new String((documentEntry.getName() + ".doc").getBytes(), "iso-8859-1"));
//            OutputStream ostream = response.getOutputStream();
            File file = new File(path);
            OutputStream os = new FileOutputStream(file);
            poifs.writeFilesystem(os);
            bais.close();
            os.close();
        } catch (Exception e) {
            //异常处理
        }
    }

    public static void main(String[] args) throws Exception {

        exportWord(Html2Pdf.str, "D://zzz.doc");

    }
}
