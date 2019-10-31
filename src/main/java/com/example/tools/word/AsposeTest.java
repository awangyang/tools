package com.example.tools.word;

import com.aspose.words.Document;
import com.aspose.words.HtmlSaveOptions;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author wangyang
 * @date 2019/10/30
 */
public class AsposeTest {
    public static void main(String[] args) throws Exception {

        long old = System.currentTimeMillis();
//        String inputPath = "D:\\2003.doc";
//        String outputPath = "D:\\new-2003.html";

//        String inputPath = "D:\\new-2003.html";
//        String outputPath = "D:\\new-2003doc.doc";

        String inputPath = "D:\\new-2003html.html";
        String outputPath = "D:\\new-2003img.doc";
        Document document = new Document(inputPath);
        OutputStream os = new FileOutputStream(new File(outputPath));
        HtmlSaveOptions htmlSaveOptions = new HtmlSaveOptions();
        htmlSaveOptions.setImagesFolder("D:\\img\\");
        document.save(os, SaveFormat.DOC);
        long now = System.currentTimeMillis();
        System.out.println("convert OK! " + ((now - old) / 1000.0) + "秒");


    }
}
