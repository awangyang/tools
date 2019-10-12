package com.example.tools.poi;


import com.itextpdf.io.util.FileUtil;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author wangyang
 * @date 2019/10/08
 */
public class WordReplaceTextUtil {
    /**
     * @Description: 将t中的字段转换成替换模板需要的数据${字段}-->字段值
     * 在word模板中变量为${valuename},为每个值建一个以‘${valuename}’为键，‘value’为值的Map集合，
     * 利用键去和Word模板中寻找相等的变量
     */
    public static <T> Map<String, String> copyParamFromBean(T t, Map<String, String> params) {
        Field[] fields = t.getClass().getDeclaredFields();
        String key;
        String value;
        for (Field field : fields) {
            String fieldName = field.getName();
            key = "{{" + fieldName + "}}";
            String name = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                value = String.valueOf(t.getClass().getMethod(name).invoke(t));
                if ("null".equals(value)) {
                    params.put(key, "");
                } else {
                    params.put(key, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return params;
    }

    /***
     *替换Word模板中的对应变量。
     *两种情况：1-段落中的变量。 2-表格中的变量
     */
    public static void searchAndReplace(XWPFDocument document, Map<String, String> map) {
        try {
            // 替换段落中的指定文字
            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();//获得word中段落
            while (itPara.hasNext()) {       //遍历段落
                XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
                Set<String> set = map.keySet();
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    List<XWPFRun> run = paragraph.getRuns();
                    for (int i = 0; i < run.size(); i++) {
                        if (run.get(i).getText(run.get(i).getTextPosition()) != null &&
                                run.get(i).getText(run.get(i).getTextPosition()).equals(key)) {
                            /**
                             * 参数0表示生成的文字是要从哪一个地方开始放置,设置文字从位置0开始
                             * 就可以把原变量替换掉
                             */
                            run.get(i).setText(map.get(key), 0);
                        }
                    }
                }
            }
            // 替换表格中的指定文字
            Iterator<XWPFTable> itTable = document.getTablesIterator();//获得Word的表格
            while (itTable.hasNext()) { //遍历表格
                XWPFTable table = (XWPFTable) itTable.next();
                int count = table.getNumberOfRows();//获得表格总行数
                for (int i = 0; i < count; i++) { //遍历表格的每一行
                    XWPFTableRow row = table.getRow(i);//获得表格的行
                    List<XWPFTableCell> cells = row.getTableCells();//在行元素中，获得表格的单元格
                    for (XWPFTableCell cell : cells) {   //遍历单元格
                        for (Map.Entry<String, String> e : map.entrySet()) {
                            if (cell.getText().equals(e.getKey())) {//如果单元格中的变量和‘键’相等，就用‘键’所对应的‘值’代替。
                                cell.removeParagraph(0);//所以这里就要求每一个单元格只能有唯一的变量。
                                cell.setText(e.getValue());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭输出流
     *
     * @param os
     */
    public void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static HWPFDocument docReplaceWithPOI(byte[] bytes, Map<String, String> map) {
        HWPFDocument doc = null;

        try {
            InputStream inp = new ByteArrayInputStream(bytes);
            POIFSFileSystem fs = new POIFSFileSystem(inp);
            doc = new HWPFDocument(fs);
            Range range = doc.getRange();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                range.replaceText(entry.getKey(), entry.getValue());
            }
            inp.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    private static byte[] inputToByte(InputStream inStream, int fileSize) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[fileSize];
        int rc;
        while ((rc = inStream.read(buff, 0, fileSize)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        return swapStream.toByteArray();
    }

    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException {
        File file = new File("C:\\Users\\WangYang\\Desktop\\套头模板6.doc");

        HashMap map = new HashMap(16);
//        byte[] bytesByFile = FileUtil.getBytesByFile(file);

//        HWPFDocument hwpfDocument = docReplaceWithPOI(bytesByFile, map);

//        File file1 = new File("C:\\Users\\WangYang\\Desktop\\套头模板6-4.doc");
        System.out.println("-------------------");
//        System.out.println(Word2Html.convert(hwpfDocument));

//        String s = "1123213";
////        byte[] bytes = {1, 2, 3, 4};
//        byte[] bytes = s.getBytes();
//        System.out.println(bytes.toString());
//        InputStream is = new ByteArrayInputStream(bytes);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        int len;
//        while ((len = is.read()) > -1) {
//            baos.write(len);
//        }
//        baos.flush();
//
////        byte[] bytes1 =  inputToByte(is,1024);
//
////        System.out.println(new String(bytes1));
//        System.out.println(baos.toString());
//
//        InputStream stream1 = new ByteArrayInputStream(baos.toByteArray());


//        InputStream stream2 = new ByteArrayInputStream(baos.toByteArray());
    }
}
