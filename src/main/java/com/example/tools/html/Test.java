package com.example.tools.html;

import java.io.*;

/**
 * @author Wang Yang
 * @date 2020/5/14 21:23
 */
public class Test {


    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\WangYang\\Desktop\\parse-html1.html";
        FileReader fileReader = new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder html = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            html.append(line);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        fileReader.close();
        System.out.println(html.toString());

        System.out.println("-----------");
        System.out.println(HtmlUtils.del(html.toString()));
    }
}
