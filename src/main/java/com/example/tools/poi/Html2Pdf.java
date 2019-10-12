package com.example.tools.poi;


import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.font.FontProvider;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author wangyang
 * @date 2019/10/09
 */
public class Html2Pdf {

    public static String str="<html>\n" +
            "<head>\n" +
            "<META http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
            "<style type=\"text/css\">.b1{white-space-collapsing:preserve;}\n" +
            ".b2{margin: 1.0in 1.25in 1.0in 1.25in;}\n" +
            ".s1{color:red;}\n" +
            ".s2{font-family:Calibri;font-weight:bold;}\n" +
            ".s3{font-weight:bold;}\n" +
            ".p1{text-align:center;hyphenate:auto;font-family:华文中宋;font-size:36pt;}\n" +
            ".p2{text-align:justify;hyphenate:auto;font-family:仿宋;font-size:16pt;}\n" +
            ".p3{text-align:justify;hyphenate:auto;font-family:Calibri;font-size:16pt;}\n" +
            ".p4{text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;}\n" +
            ".td1{width:2.632639in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
            ".td2{width:1.4in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
            ".td3{width:1.7284722in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
            ".td4{width:1.4402778in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
            ".td5{width:4.320833in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
            ".td6{width:1.1923611in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
            ".td7{width:3.1284723in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
            ".td8{width:5.7611113in;padding-start:0.0in;padding-end:0.0in;border-bottom:thin solid black;border-left:thin solid black;border-right:thin solid black;border-top:thin solid black;}\n" +
            ".r1{height:1.7319444in;keep-together:always;}\n" +
            ".r2{height:0.39375in;keep-together:always;}\n" +
            ".r3{height:4.540278in;keep-together:always;}\n" +
            ".t1{table-layout:fixed;border-collapse:collapse;border-spacing:0;}\n" +
            "</style>\n" +
            "<meta content=\"WangYang\" name=\"author\">\n" +
            "</head>\n" +
            "<body class=\"b1 b2\">\n" +
            "<table class=\"t1\">\n" +
            "<tbody>\n" +
            "<tr class=\"r1\">\n" +
            "<td class=\"td1\" colspan=\"2\">\n" +
            "<p class=\"p1\">\n" +
            "<span class=\"s1\">产品</span>\n" +
            "</p>\n" +
            "<p class=\"p1\">\n" +
            "<span class=\"s1\">信息</span>\n" +
            "</p>\n" +
            "</td><td class=\"td2\">\n" +
            "<p class=\"p2\">\n" +
            "<span class=\"s1\">编号：</span><span class=\"s2\">P34</span>\n" +
            "</p>\n" +
            "</td><td class=\"td3\">\n" +
            "<p class=\"p2\">\n" +
            "<span class=\"s1\">签发人：</span>\n" +
            "</p>\n" +
            "<p class=\"p2\"></p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "<tr class=\"r2\">\n" +
            "<td class=\"td4\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">标题</span>\n" +
            "</p>\n" +
            "</td><td class=\"td5\" colspan=\"3\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">发布测试1111111111111111111</span>\n" +
            "</p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "<tr class=\"r2\">\n" +
            "<td class=\"td4\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">发布单位</span>\n" +
            "</p>\n" +
            "</td><td class=\"td6\">\n" +
            "<p class=\"p3\"></p>\n" +
            "</td><td class=\"td2\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">发布时间</span>\n" +
            "</p>\n" +
            "</td><td class=\"td3\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">2019-09-12 15:49:40.973</span>\n" +
            "</p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "<tr class=\"r2\">\n" +
            "<td class=\"td4\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">所属领域</span>\n" +
            "</p>\n" +
            "</td><td class=\"td6\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">体育</span>\n" +
            "</p>\n" +
            "</td><td class=\"td2\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">专题</span>\n" +
            "</p>\n" +
            "</td><td class=\"td3\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">YDYL</span>\n" +
            "</p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "<tr class=\"r2\">\n" +
            "<td class=\"td4\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">来源</span>\n" +
            "</p>\n" +
            "</td><td class=\"td6\">\n" +
            "<p class=\"p3\"></p>\n" +
            "</td><td class=\"td2\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">方式</span>\n" +
            "</p>\n" +
            "</td><td class=\"td3\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">发布测试1111111111111111111</span>\n" +
            "</p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "<tr class=\"r2\">\n" +
            "<td class=\"td4\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">国家地区1</span>\n" +
            "</p>\n" +
            "</td><td class=\"td6\">\n" +
            "<p class=\"p3\"></p>\n" +
            "</td><td class=\"td2\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">国家地区2</span>\n" +
            "</p>\n" +
            "</td><td class=\"td3\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">美国</span>\n" +
            "</p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "<tr class=\"r2\">\n" +
            "<td class=\"td1\" colspan=\"2\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">关联总体要求</span>\n" +
            "</p>\n" +
            "</td><td class=\"td7\" colspan=\"2\">\n" +
            "<p class=\"p3\"></p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "<tr class=\"r3\">\n" +
            "<td class=\"td8\" colspan=\"4\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">正文：</span>\n" +
            "</p>\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">12月28日接口 类 ： SearchClient&lt;br&gt;包 路径： casia.basic.analysisgroup.es.search.SearchClient&lt;br&gt;最新 接口 jar 请 在 团队 maven 私库 中按 keywords 检索 \" fusionSearch \" ，或 点击该链接  http://192.168.6.154:8081/nexus/#nexus-search;quick~fusionSearch   &lt;br&gt;构造 函数&lt;br&gt;SearchClient ( String coreserver , int port, String clusterName , String index, String type)&lt;br&gt;参数 说明：&lt;br&gt;coreserver ： 索引服务 IP 地址&lt;br&gt;port ：索引 服务端口&lt;br&gt;clusterName ： 集群名称&lt;br&gt;index ： 索引名称 ， 可为 null&lt;br&gt;type ： 类型名 ， 与数据库表名相同 ， 可为 string 格式 数组 。&lt;br&gt;具体 参数 对应 值 及 已索引的数据表 请 关注 禅道 平台 ： http://172.18.11.1/index.php?m=doc&amp;amp;f=view&amp;amp;docID=66&lt;br&gt;常量类路径&lt;br&gt;参数 中几个常量类路径：&lt;br&gt;KeywordsCombine 类 ：  casia  .  basic  .  analysisgroup  .  es  .  search  .  common  ， 包括 \"AND\" 、 \"OR\" 两个 常量， 表示关键词之间的 \" 与 \" -- AND 、 \" 或 \" -- OR 关系 ；&lt;br&gt;ISIOperator 类 ： casia.basic.analysisgroup.es.search.common ， 包括 \"MUST\" 、 \"MUST_NOT\" 两个 常量， 表示 检索条件 是 \"必须 出现 \" --MUST 、\"必须不 出现 \" --MUST_NOT 关系 ；&lt;br&gt;SortOrder 类 ： org.elasticsearch.search.sort ，包括 \"ASC\" 、 \"DESC\" 两个 常量， 表示 \" 正序 \" --ASC 、 \" 倒序 \" --DESC 。&lt;br&gt;基本 检索接口&lt;br&gt;4 .1 全文检索接口&lt;br&gt;addKeywordsQuery (String field, String keywords, ISIOperator operator, KeywordsCombine combine)&lt;br&gt;单 字段 全文 检索接口&lt;br&gt;参数说明 ：&lt;br&gt;field ： 字段 名称&lt;br&gt;keywords ： 检索关键词&lt;br&gt;operator ：检索 条件 \"必须 出现 \" 还是 \"必须不 出现 \"&lt;br&gt;combine ： 如果 关键词是空格分隔的， 该 参数表示 关键词之间的与、或关系， 比如 keywords 是 \"China USA\" ， combine 是 \"AND\" ， 表示该检索 条件 是 C hina 和 USA 都 要包含 才 满足 该 条件； combine 是 \"OR\"   ， 表示该检索 条件 是 C hina 和 USA 包含其中 一个即满足 该 条件 ；&lt;br&gt;示例 ：&lt;br&gt;&lt;br&gt;&lt;br&gt;适用该 接口字段 ： title 、 content 、 summary&lt;br&gt;&amp;nbsp;&lt;br&gt;addKeywordsQuery (String[] fields, String keywords, ISIOperator operator, KeywordsCombine combine)&lt;br&gt;多 字段 全文 检索接口&lt;br&gt;参数说明 ：&lt;br&gt;fields ： 字段 名称 数组&lt;br&gt;keywords ： 检索关键词&lt;br&gt;operator ：检索 条件 \"必须 出现 \" 还是 \"必须不 出现 \"&lt;br&gt;combine ：如果 关键词是空格分隔的， 该 参数表示 关键词之间的与、或关系， 比如 keywords 是 \"China USA\" ， combine 是 \"AND\" ， 表示该检索 条件 是 C hina 和 USA 都 要包含 才 满足 该 条件； combine 是 \"OR\"   ， 表示该检索 条件 是 C hina 和 USA 包含其中 一个即满足 该 条件 ；&lt;br&gt;示例 ：&lt;br&gt;&lt;br&gt;适用该 接口字段 ： title 、 content 、 summary&lt;br&gt;4 .2 精确查询接口&lt;br&gt;addPhraseQuery (String field, String keywords)&lt;br&gt;短语 查询接口 ， 对 检索 关键词 不 分词&lt;br&gt;参数说明 ：&lt;br&gt;field ： 字段 名称&lt;br&gt;keywords ： 检索关键词&lt;br&gt;示例 ：&lt;br&gt;&lt;br&gt;适用该 接口字段 ： title 、 content 、 summary&lt;br&gt;&amp;nbsp;&lt;br&gt;addTermQuery (String field, String term, ISIOperator operator )&lt;br&gt;原子 查询接口 ，适用于 不 分词 字段&lt;br&gt;参数说明 ：&lt;br&gt;fields ： 字段 名称&lt;br&gt;keywords ： 检索 条件， 支持 同时 传入多个条件 （ 以 空格 分隔 ）， 条件 之间 是或的关系&lt;br&gt;operator ：检索 条件 \"必须 出现 \" 还是\"必须不 出现 \" 。&lt;br&gt;示例 ：&lt;br&gt;&lt;br&gt;适用该 接口字段 ： 除 title 、 content 、 summary 外 的其他字段&lt;br&gt;与 该接口有相同效果的还有接口 addPrimitiveTermQuery (String field, String[] terms, ISIOperator operator ) ， 不同之处在于该接口的多个条件是数组 形式传参的 。&lt;br&gt;&amp;nbsp;&lt;br&gt;4 .3 范围查询接口&lt;br&gt;addRangeTerms (String field, long startTerm , long endTerm )&lt;br&gt;范围 查询接口 ， 范围边界是起始和结束条件之间的闭区间&lt;br&gt;参数说明 ：&lt;br&gt;fields ： 字段 名称&lt;br&gt;startTerm ： 起始 条件&lt;br&gt;endTerm ： 结束 条件&lt;br&gt;示例 ：&lt;br&gt;&lt;br&gt;适用该 接口字段 ： 值是 数字 类型 的 字段&lt;br&gt;&amp;nbsp;&lt;br&gt;addRangeTerms (String field, String startTerm , String endTerm )&lt;br&gt;范围 查询接口 ， 范围边界是起始和结束条件之间的闭区间&lt;br&gt;参数说明 ：&lt;br&gt;fields ： 字段 名称&lt;br&gt;startTerm ：起始 条件 ， 日期类型值格式： yyyy -MM- dd   HH:mm:ss&lt;br&gt;endTerm ：结束 条件 ， 日期类型值格式： yyyy -MM- dd   HH:mm:ss&lt;br&gt;示例 ：&lt;br&gt;&lt;br&gt;适用该 接口字段 ： 值是字符串、 日期类型的字段&lt;br&gt;&amp;nbsp;&lt;br&gt;4 .4 排序接口&lt;br&gt;addSortField (String field, SortOrder order)&lt;br&gt;排序 接口 ，该接口 可多次调用， 排序 方式依据调用次序 进行 叠加 。&lt;br&gt;参数说明 ：&lt;br&gt;fields ： 字段 名称&lt;br&gt;order ： 排序方式&lt;br&gt;示例 ：&lt;br&gt;&lt;br&gt;适用该 接口字段 ： 值是字符串、 日期类型的字段&lt;br&gt;&amp;nbsp;&lt;br&gt;4 .5 翻页接口&lt;br&gt;setStart ( int start)&lt;br&gt;从第几条结果取数据&lt;br&gt;参数说明 ：&lt;br&gt;start ： 从第几条结果取数据 ， 从 0 开始 计数&lt;br&gt;&amp;nbsp;&lt;br&gt;setRow ( int rows)&lt;br&gt;每次返回 多少 条 数据&lt;br&gt;参数说明 ：&lt;br&gt;rows ： 从第几条结果取数据 ， 从 0 开始 计数&lt;br&gt;&amp;nbsp;&lt;br&gt;getTotal ()&lt;br&gt;返回 结果总数 ， 此接口要在执行 execute () 后 才有效。&lt;br&gt;4 .6 返回结果接口&lt;br&gt;getResults   ()&lt;br&gt;返回 命中记录 对应 mongodb 中的 _id ， 此接口要在执行 execute () 后 才有效。 如果 type 是 null 或多个，则 String[] 第一个数值 是类型 名称；其余字段顺序和 execute(String[]) 方法中的参数 fields 一致 。&lt;br&gt;&amp;nbsp;&lt;br&gt;高级 检索及统计接口&lt;br&gt;见 javadoc&lt;br&gt;索引字段 说明&lt;br&gt;已 索引字段&lt;br&gt;已 索引数据表见  http://172.18.11.1/index.php?m=doc&amp;amp;f=view&amp;amp;docID=66  ， 除 html 代码类字段外 的其他字段 都 会索引 。 如 发现有字段未索引，可能 属于 新增 字段，如需添加索引请及时告知 ， 谢谢！&lt;br&gt;索引存储 哪些字段&lt;br&gt;对于 进行分词的文本类字段，比如 title 、 content ，构建 索引时会 只索引 不 存储 ； 其他字段一般都会存储到索引中。&lt;br&gt;特殊 字段 说明&lt;br&gt;对于各数据表中的 date 类型字段，在索引的时候 会 做特殊处理 ， 将 一个 日期字段转换成 两个 字段索引，比如 datepublished 字段，在索引中会有 datepublished 和 datepublished 2 这样 两个字段， 索引 数 值 分别 按 yyyyMMdd HHmmss 和 yyyyMMdd 两种 格式进行格式化 ， 即 datepublished 带时分秒 ， datepublished2 不 带 时分秒 ，类型转换为 长整型 ， 以 便于按照日期进行数据检索，提高检索速度。&lt;br&gt;注意 ！ ！！&lt;br&gt;如果初始化 一次 SearchClient 多次 检索， 必须 每次获取结果后执行 reset() 接口 ，以免 两次 检索条件叠加 影响下次检索。&lt;br&gt;完成 检索后调用 close() 接口 关闭连接。</span>\n" +
            "</p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "<p class=\"p4\"></p>\n" +
            "<p class=\"p4\"></p>\n" +
            "</body>\n" +
            "</html>";
    public static void convert(String html, OutputStream outputStream) throws IOException {

//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ConverterProperties props = new ConverterProperties();
        FontProvider fp = new FontProvider(); // 提供解析用的字体
        fp.addStandardPdfFonts(); // 添加标准字体库、无中文
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println();
        String path = ResourceUtils.getURL("classpath:fonts").getPath();
        System.out.println(path.substring(1));
        fp.addDirectory(path); // 自定义字体路径、解决中文,可先用绝对路径测试。
        props.setFontProvider(fp);
        // props.setBaseUri(baseResource); // 设置html资源的相对路径
        HtmlConverter.convertToPdf(html, outputStream, props); // 无法灵活设置页边距等

    }

    public static void main(String[] args) throws IOException {

        String path="C:\\Users\\WangYang\\Desktop\\xxxx1.pdf";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        Html2Pdf.convert(str, fileOutputStream);

    }
}
