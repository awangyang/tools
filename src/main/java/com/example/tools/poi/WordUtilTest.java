package com.example.tools.poi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyang
 * @date 2019/10/15
 */
public class WordUtilTest {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>(64);
//        map.put("title","111111");
        map.put("content","wwwwwwwwwwwww");
        WordUtil.createWord2003("/template/word/word2003.xml", "D:\\Project_idea\\git\\tools\\src\\main\\resources\\template\\word\\word2003-1.doc", map);
    }
}
