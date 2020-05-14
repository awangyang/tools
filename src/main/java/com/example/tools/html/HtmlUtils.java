package com.example.tools.html;

import com.google.common.base.Strings;

import java.util.regex.Pattern;

/**
 * @author Wang Yang
 * @date 2020/5/14 21:19
 */
public class HtmlUtils {

    /**
     * 定义script的正则表达式
     */
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
    /**
     * 定义style的正则表达式
     */
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";

    private static final String regEx_head = "<head[^>]*?>[\\s\\S]*?<\\/head>";

    private static final String regEx_html = "<html[^>]+>|<html>|</html>";

    private static final String regEx_body = "<body[^>]+>|<body>|</body>";
    private static final String regEx_doc = "<![^>]+>";

    private static final Pattern p_doc = Pattern.compile(regEx_doc, Pattern.CASE_INSENSITIVE);
    private static final Pattern p_head = Pattern.compile(regEx_head, Pattern.CASE_INSENSITIVE);
    private static final Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
    private static final Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
    private static final Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
    private static final Pattern p_body = Pattern.compile(regEx_body, Pattern.CASE_INSENSITIVE);

    public static String del(String html) {
        if (Strings.isNullOrEmpty(html)) {
            return html;
        }
        html = p_doc.matcher(html).replaceAll("");
        html = p_head.matcher(html).replaceAll("");
        html = p_script.matcher(html).replaceAll("");
        html = p_style.matcher(html).replaceAll("");
        html = p_html.matcher(html).replaceAll("");
        html = p_body.matcher(html).replaceAll("");

        return html;
    }
}
