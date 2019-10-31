package com.example.tools.poi;


import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.font.FontProvider;
import org.apache.commons.collections4.CollectionUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author wangyang
 * @date 2019/10/09
 */
public class Html2Pdf {

    public static String str = "<html>\n" +
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
            "\n" +
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
            "<span class=\"s1\">编号：</span><span class=\"s2\">P102</span>\n" +
            "</p>\n" +
            "</td><td class=\"td3\">\n" +
            "<p class=\"p2\">\n" +
            "<span class=\"s1\">签发人：</span>\n" +
            "</p>\n" +
            "<p class=\"p3\"></p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "<tr class=\"r2\">\n" +
            "<td class=\"td4\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">标题</span>\n" +
            "</p>\n" +
            "</td><td class=\"td5\" colspan=\"3\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">测试成品应用HJHKJHJK</span>\n" +
            "</p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "<tr class=\"r2\">\n" +
            "<td class=\"td4\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">发布单位</span>\n" +
            "</p>\n" +
            "</td><td class=\"td6\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">参考消息,40%;新华社,60%</span>\n" +
            "</p>\n" +
            "</td><td class=\"td2\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">发布时间</span>\n" +
            "</p>\n" +
            "</td><td class=\"td3\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">2019-10-09 15:43:00</span>\n" +
            "</p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "<tr class=\"r2\">\n" +
            "<td class=\"td4\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">所属领域</span>\n" +
            "</p>\n" +
            "</td><td class=\"td6\">\n" +
            "<p class=\"p3\"></p>\n" +
            "</td><td class=\"td2\">\n" +
            "<p class=\"p3\">\n" +
            "<span class=\"s3\">专题</span>\n" +
            "</p>\n" +
            "</td><td class=\"td3\">\n" +
            "<p class=\"p3\"></p>\n" +
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
            "<span class=\"s3\">测试成品应用HJHKJHJK</span>\n" +
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
            "<p class=\"p3\"></p>\n" +
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
            "<span class=\"s3\"><p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\">\n" +
            "<span id=\"1569809050469\" style=\"background:#dacbae;position:relative;\">2月15日 <i class=\"quote-index-x\" contenteditable=\"\" data-pid=\"1F3026B1-B13B-4272-8511-299E72E56017\" data-type=\"4\" style=\"display:inline-block;font-size:12px;background: rgb(224,108,108);border-radius: 2px;min-width: 40px;color: #fff;font-style: normal;height: 16px;position: relative;top:2px;padding: 2px 5px 2px 2px;box-sizing:border-box;\"> <i class=\"index\" contenteditable=\"false\" style=\"cursor:pointer;line-height: 12px;padding: 0 2px;background: #fff;display:inline-block;vertical-align:middle;border-radius: 50%;color: rgb(224,108,108);text-align: center;font-style: normal;text-indent: 0;float:left;\">1</i> <i class=\"quote-close-x\" contenteditable=\"false\" data-sentenceid=\"1569809050469\" style=\"cursor: pointer;font-style: normal;text-indent: 0;float:right;line-height: 12px;\">x</i> </i> </span><span id=\"1569809080681\" style=\"background:#dacbae;position:relative;\">特朗普 <i class=\"quote-index-x\" contenteditable=\"\" data-pid=\"2\" data-type=\"3\" style=\"display:inline-block;font-size:12px;background: rgb(224,108,108);border-radius: 2px;min-width: 40px;color: #fff;font-style: normal;height: 16px;position: relative;top:2px;padding: 2px 5px 2px 2px;box-sizing:border-box;\"> <i class=\"index\" contenteditable=\"false\" style=\"cursor:pointer;line-height: 12px;padding: 0 2px;background: #fff;display:inline-block;vertical-align:middle;border-radius: 50%;color: rgb(224,108,108);text-align: center;font-style: normal;text-indent: 0;float:left;\">2</i> <i class=\"quote-close-x\" contenteditable=\"false\" data-sentenceid=\"1569809080681\" style=\"cursor: pointer;font-style: normal;text-indent: 0;float:right;line-height: 12px;\">x</i> </i> </span><span id=\"1569810518739\" style=\"background:#dacbae;position:relative;\">公开 <i class=\"quote-index-x\" contenteditable=\"\" data-pid=\"7a617a77743796\" data-type=\"2\" style=\"display:inline-block;font-size:12px;background: rgb(224,108,108);border-radius: 2px;min-width: 40px;color: #fff;font-style: normal;height: 16px;position: relative;top:2px;padding: 2px 5px 2px 2px;box-sizing:border-box;\"> <i class=\"index\" contenteditable=\"false\" style=\"cursor:pointer;line-height: 12px;padding: 0 2px;background: #fff;display:inline-block;vertical-align:middle;border-radius: 50%;color: rgb(224,108,108);text-align: center;font-style: normal;text-indent: 0;float:left;\">3</i> <i class=\"quote-close-x\" contenteditable=\"false\" data-sentenceid=\"1569810518739\" style=\"cursor: pointer;font-style: normal;text-indent: 0;float:right;line-height: 12px;\">x</i> </i> </span><span style=\"font-weight:bold;\">2017年7月27 -处理浏览器兼容性</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-family:幼圆;\"><span style=\"font-size:34.7px;\">&lt;!--[if IE 5]&gt; 仅IE5.0与IE5.5可以识别 &lt;![endif]--&gt; </span></span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>&lt;!--[if gt IE 5.0]&gt; IE5.0以及IE5.0以上版本都可以识别 &lt;![endif]--&gt; </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>&lt;!--[if lt IE 6]&gt; IE6以及IE6以下版本可识别 &lt;![endif]--&gt; </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>&lt;!--[if gte IE 6]&gt; IE6以及IE6以上版本可识别 &lt;![endif]--&gt; </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>&lt;!--[if lt IE 7]&gt; IE7以及IE7以下版本可识别 &lt;![endif]--&gt; </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>&lt;!--[if ！IE ]&gt; 非IE版本可识别 &lt;![endif]--&gt; </span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">display:flex;弹性布局 --优点：方便 ！缺点：处理兼容性问题非常麻烦</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.25in;margin-left:0.3125in;text-align:start;border-left:1.500pt solid darkgray;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>解决：</span><span style=\"font-family:Consolas;font-size:6pt;color:black;\">display:&nbsp;-webkit-box;&nbsp;/*&nbsp;Chrome&nbsp;4+,&nbsp;Safari&nbsp;3.1,&nbsp;iOS&nbsp;Safari&nbsp;3.2+&nbsp;*/&nbsp;&nbsp;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.25in;margin-left:0.3125in;text-align:start;border-left:1.500pt solid darkgray;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">display:&nbsp;-moz-box;&nbsp;/*&nbsp;Firefox&nbsp;17-&nbsp;*/&nbsp;&nbsp;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.25in;margin-left:0.3125in;text-align:start;border-left:1.500pt solid darkgray;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">display:&nbsp;-webkit-flex;&nbsp;/*&nbsp;Chrome&nbsp;21+,&nbsp;Safari&nbsp;6.1+,&nbsp;iOS&nbsp;Safari&nbsp;7+,&nbsp;Opera&nbsp;15/16&nbsp;*/&nbsp;&nbsp;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.25in;margin-left:0.3125in;text-align:start;border-left:1.500pt solid darkgray;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">display:&nbsp;-moz-flex;&nbsp;/*&nbsp;Firefox&nbsp;18+&nbsp;*/&nbsp;&nbsp;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.25in;margin-left:0.3125in;text-align:start;border-left:1.500pt solid darkgray;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:blue;\">display:&nbsp;-ms-flexbox;&nbsp;/*&nbsp;IE&nbsp;10&nbsp;*/&nbsp;&nbsp;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.25in;margin-left:0.3125in;text-align:start;border-left:1.500pt solid darkgray;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">display:&nbsp;flex;&nbsp;/*&nbsp;Chrome&nbsp;29+,&nbsp;Firefox&nbsp;22+,&nbsp;IE&nbsp;11+,&nbsp;Opera&nbsp;12.1/17/18,&nbsp;Android&nbsp;4.4+&nbsp;*/&nbsp;&nbsp;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>注意：</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>display:flex与display:box都可用于弹性布局；flex是2012之后提出的写法；box是2009年的提法，已经过时；</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>处理加浏览器前缀的方式外，在ie低版本中也可用float代替弹性布局；</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:#c00000;\">display:flex 兼容性问题很大 不要滥用flex </span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;color:#c00000;\">重点：使用display:flex的场景：一侧固定宽度，另一侧自适应</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><!--Image link to '0.png' can be here--><!--Image link to 'dab0.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">3.:nth-child()选择器 </span><span> 所有的主流浏览器均支持，</span><span style=\"color:blue;\">除IE8及更早的版本</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:blue;\">注意：在页面中尽量不要用下标选择器 页面上位置调换就会出现问题</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">4.Transform属性 </span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>IE9 支持替代的-ms-transform （仅适用于2D转换）</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Opera 仅支持2D转换</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Safari和Chrome支持替代的-webkit-transform（3D与2D转换）</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">5.如何实现元素的水平垂直居中？</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">-水平居中（ 种）</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>①行内元素 例如：a,b(加粗),strong(强调),i,span,img,input,select等</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>父元素设text-align:center;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>②块级元素 特点：独占一行 支持宽高 </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Margin: 0 auto;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>③浮动的元素：子元素浮动 可以给父元素宽度设置为width:fit-content,配合margin:0 auto;</span> <!--Image link to '123d1.png' can be here--> <!--Image link to '1a817.png' can be here--> <!--Image link to '1c6c5.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>④老版display:box 设置弹性布局，box-orient:horizontal主轴方向(vertical垂直) ,box-pack:center盒子内部子元素的排列方式 此处是均等分割多余空间；</span> <!--Image link to '2365b.png' can be here--> <!--Image link to '24c8d.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>⑤新版display:flex,设置父元素display:flex;flex-direction:row;水平方向为主轴;justify-content:center;</span> <!--Image link to '2e799.png' can be here--> <!--Image link to '2f8cc.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>⑥CSS3属性transform:translate(x,y) </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>http://www.jianshu.com/p/09ece194956a?utm_source=desktop&amp;utm_medium=timeline</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">2017年7月28 -处理浏览器兼容性(2)</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Bxslider支持到IE7+ 各种现代浏览器</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>定义浏览器的渲染方式：IE=edge,chrome=1 </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:blue;\">&lt;meta http-equiv=&quot;X-UA-Compatible&quot; content=&quot;IE=edge,chrome=1&quot;&gt;</span><span> </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>外引：Google开发的一个Google Chrome Frame(Google Chrome 浏览器内嵌框架-GCF)，可以让用户的IE浏览器外观不变，但用户在浏览网页时实际使用的是Chrome的内核,并支持Windows XP及以上系统的IE6/7/7，前提是用户必须已经安装了Google Chrome Frame; 官方定义利用Javascript性能增强功能，使应用程序速度更快，响应更灵敏；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:blue;\">这段代码的解释：如果安装了GCF，则使用GCF来渲染页面[&quot;chrome=1&quot;]如果没有安装GCF，则使用最高版本的IE内核进行渲染[&quot;IE=edge&quot;]</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:black;\">::before 和:before</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:black;\">::before 双冒号的写法在CSS3新提出的，有兼容性问题 支持现代浏览器和IE8+(IE8使用:的写法) 以上 IE6/7不支持 </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:black;\">background:color url() no-repeat center left; </span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:black;\">注意书写的顺序 在有的浏览器中不支持 </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:black;\">background-size IE8及以下不支持 </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:black;\">在设置背景图像的时候,设置宽高很重要,但是IE7及以下不认识min-*属性 实际上,IE7及以下将正常的width和height当做min-width和min-height；这在现代浏览器中显示正常,但是在IE7以下就相当于没有设置高宽</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">其他：</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>尽量少用margin-top 有的浏览器有修正错误；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>CMS切图里，图片、文字只要格式正确，自己是不需要切图的，都是后端生成的；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>以后写类名格式md时间(8位)-名字首字母-语义化类名 如：md20170728-lty-header-title </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>尽量不要修改a的结构性样式，网页的链接不是前端能控制的，是CMS切图放上去的,保证去掉a以后不影响页面的样式，保险的写法是</span><span style=\"font-weight:bold;\">.title,.title a{};</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:#0070c0;\">文字垂直居中的神奇效果： </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>&lt;a href=&quot;#&quot; class=&quot;zong&quot;&gt;&lt;span&gt;声音专业委员会&lt;/span&gt;&lt;i&gt;&lt;/i&gt;&lt;/a&gt;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>a{display:inline-block; height:90px; width:90px;}</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>span{ display:inline-block; vertical-align:middle;} //必须</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>i{ height:100%; display:inline-block; vertical-align:middle;} //必须</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>高度固定 文字的行数不固定可以通过隐藏的方式,例如：</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>height:30px;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>line-height:30px;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>overflow:hidden;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>ycty.org 英才添翼管理平台账号</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><a href=\"mailto:sk1@126.com\"><span>sk1@126.com</span></a></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>123456</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">2017年7月31</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>html5中页面拨打电话的方式</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>&lt;a href=&quot;tel:88888888&quot;&gt;拨号&lt;/a&gt;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>&lt;a href=&quot;sms:888888&quot;&gt;发短信&lt;/a&gt;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">解决？</span><span style=\"font-size:12pt;\">在webkit浏览器中字体最小显示12号字体</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><!--Image link to '34d31.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><span>注意：这个属性设定文字大小是否根据设备来自动调整显示的大小，none就禁止调整；建议局部调整，全局设置的话当用户滚轮缩放网页，文字却不变，用户体验不好；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:宋体;font-size:12pt;\"><!--Image link to '35ca8.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><span>问题：transform缩放会将元素的宽高整体等比例缩放，最后影响布局，可以先将元素等比例放大，再缩放就不会有问题啦，稍微调下位置就OK；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:宋体;font-size:10pt;\"><span style=\"font-weight:bold;color:blue;\">总结：-webkit-text-size-adjust的本职是用于mobile的；iPhone和iPad默认设定不一样；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:宋体;font-size:10pt;\"><span style=\"font-weight:bold;color:blue;\">iPhone默认设定-webkit-text-size-adjust:auto;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:宋体;font-size:10pt;\"><span style=\"font-weight:bold;color:blue;\">iPad默认设定-webkit-text-size-adjust:none ；(iPad默认是不调节的)</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><!--Image link to '366a2.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><!--Image link to '3d9d3.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>form表单的target标签配合iframe实现不跳转刷新</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><!--Image link to '4bf6c.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><!--Image link to '4d62e.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><span>说明：</span><span style=\"font-family:宋体;font-size:12pt;\">target的作用是让form提交后在什么窗口下打开，使用iframe 但是将iframe设为看不见的，最终form表单提交会打开iframe ，但iframe被我们设置成看不见的，这样form提交时就刷新不跳转。</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>记编程数学的表单部分标题被压住的问题？</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>原因可能性：表单部分距离标题设的padding值是固定的百分比 (根据父元素的宽度和高度来确定的，表单的高度是固定值)，所以在不同的屏幕尺寸下，表单主体部分和标题的距离在大屏幕下可能被压住，在小屏幕下显示正常或距离稍大。（矛盾的地方在于padding(margin)在不同的屏幕下的百分比也不能是固定的。</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>） 解决方案：将表单的高度不能设为固定值，而是高度随内容的变化的</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">2017年8月1日</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>正则中的特殊字符表示什么意思？ </span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>[]表示字符类 括号里是字符集 例如 /[abc]/表示含有a,b,c任何一个字母的字符都匹配；</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>\\s表示空格符 制表符 换行符 </span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>\\w 小写字符 大学字符 数据 下划线</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>\\d 任意数字 [0-9]</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>\\b 在字符类中使用表示退格符 可以用来指定匹配的位置,即匹配到达单词的边界 例如：查找一个句子中的单词Java，可以使用/\\bjava\\b/;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>- 表示连字符 例如[a-z]</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>.表示除换行符 </span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>^ 两重含义：开始标记和非 例如：/^a/表示以a开始的字符; 当在[]中时:/[^a]/表示非a的所有字符</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>$ 表示字符结尾 </span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>{} 表示重复上一项; 例如/\\d{2,4}/表示数字出现至少2次，最多4次；其他三种格式如下：{n,m}表示至少n次，最多m次；{n,}至少n次;{n}恰好n次；</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>?表示{0,1}</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>+表示{1,}</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>*表示{0,}</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:-0.29166666in;margin-left:0.5833333in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>| 表示或的含义 例如 /ab|cd|ef/匹配含有ab或cd或ef的字符串</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>JS中的字符串API</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>a)string.substring(start,stop);</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>作用：提取字符串中介于两个指定下标之间的字符 </span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>参数说明：start 一个非负整数，表示起始位置；</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:1.2069445in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Stop 一个非负整数，表示结束位置；</span><span style=\"font-weight:bold;color:blue;\">比要截取的子串的最后一位要多1；</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33402777in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>返回值：一个新的字符串，其内容是从start处到stop-1处的所有字符；</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>重要事项：与</span><a href=\"http://www.w3school.com.cn/jsref/jsref_slice_string.asp%22 \\o %22JavaScript slice() %E6%96%B9%E6%B3%95\"><span>slice()</span></a><span>和</span><a href=\"http://www.w3school.com.cn/jsref/jsref_substr.asp%22 \\o %22JavaScript substr() %E6%96%B9%E6%B3%95\"><span>substr()</span></a><span>方法不同的是，</span><span style=\"font-weight:bold;color:blue;\">substring()不接受负的参数</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>b)str.replace(regexp/substr,replacement);</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>作用：replace()方法用于在字符串中用一些字符串替换另一些字符，或替换一个与正则表达式匹配的子串;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>C)str.substr(start,length)</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>作用：在字符串中抽取从start下标开始的length长度的字符</span><span style=\"font-weight:bold;color:blue;\">(包含起始下标)</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>返回值：返回新的子字符串</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">2017年8月3日</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33402777in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>1.获取事件对象常用写法</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33402777in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>var event?event||window.event;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><!--Image link to '4e486.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33402777in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>从上图可以看出：</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33402777in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>ie9 Opera Safari Chrome既支持event又支持window.event;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33402777in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>ie6/7/8只支持window.event;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33402777in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Firefox只支持事件对象作为第一个参数传入即arguments[0];</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>2.</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>event.clientY/X 事件发生时鼠标指针在浏览器页面(客户区)的垂直/水平坐标</span><br />\n" +
            "<span>$(selector).offset()获取当前元素相对于document的偏移量 top与left</span><br />\n" +
            "<span>$(document).scrollTop()/Left() 获取匹配元素的滚动条的偏移量(垂直和水平)</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>伪类用法：</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><!--Image link to 'd3535.png' can be here--><!--Image link to 'd71fe.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">2017年8月4日 移动端随笔</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">响应式与自适应？</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>响应式与自适应的原理是相似的，都是检测设备，根据不同的设备采用不同的css，而且css都是采用百分比的，而不是固定的宽度；不同点是响应式的模板在不同的设备上看上去是不一样的，会随着设备的改变而改变展示样式，而自适应不会，所有的设备看起来都是一套模板，不过是宽高或者图片变小了，不会根据设备采用不同的展示样式。</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">为页面上所有相对URL规定基准URL</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>&lt;base href=&quot;http://www.example.com/&quot;&gt; 注意：URL为绝对URL</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">2017年8月7日</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;color:blue;\">1.平台前端框架使用手册</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><a href=\"http://lianglei.net.cn/demo-ui/platform-help/htmldemo/\"><span>http://lianglei.net.cn/demo-ui/platform-help/htmldemo/</span></a></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:blue;\">2.</span><span style=\"font-weight:bold;color:blue;\">SVN地址</span><span style=\"color:blue;\">：svn://123.59.55.96/cyt/web/platform-ui-local </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"color:blue;\">账号：liutingyu 密码：liutingyu123</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">2017年8月8日</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">1.URL中的#!是什么意思？</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>URL中的#本来的用途是跳转到页内锚点。一个URL中#后的值不影响所访问网页的内容，所以搜索引擎在处理仅仅hash tag不同的多个URL时会当做</span><span style=\"font-weight:bold;\">相同内容</span><span>从而</span><span style=\"font-weight:bold;\">忽略</span><span>hash tag；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>但近年来 hash tag 越来越多地被用于 AJAX 请求获取数据，不同 hash tag 对应的网页内容也有所不同，为了有效地区别这种情况和过去传统的页内锚点标示，让搜索引擎更好地抓取 AJAX 数据，Google 提出的解决方案 (似乎是在 2009 年) 是用 #! (被称为 hashbang ) 来进行区分，他们将带有</span><span style=\"font-weight:bold;\"> #! </span><span>的 URL 称为 pretty AJAX URL 。当网页爬虫遇到这样的 URL 就会</span><span style=\"font-weight:bold;\">将带不同 hash tag 的 URL 当做不同内容来进行抓取</span><span>，从而获得更全的信息。</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">2017年8月9日 SVN使用教程</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">建立库 </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>A)新建文件夹，目录与文件名最好都是英文；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>B)打开文件夹，在空白处按下&quot;shift+鼠标右键&quot;；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>C)弹出菜单中选择&quot;TortoiseSVN-Create respository here&quot;;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>D)弹出对话框 提示创建成功；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">导入项目</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>A)打开已有的项目文件夹，在空白处点击&quot;shift+鼠标右键&quot;；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>B)弹出菜单中选择&quot;TortoiseSVN-Import&quot;;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>C)选择导入的路径，填写备注信息，点击&quot;OK&quot;开始导入；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>D)导入完成后会弹出提示，拖动滚动条查看导入的项目，点击&quot;OK&quot;完成导入；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">建立工作目录（检出）</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>A)新建工作目录文件夹，在空白处点击&quot;shift+鼠标右键&quot;；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>B)弹出菜单中选择&quot;SVN Checkout...&quot;;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>C)在弹出的对话框中选择库目录、工作目录，点击&quot;OK&quot;开始检出；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>D)弹出详细信息对话框，导出完成后，点击&quot;OK&quot;；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">更新工作目录</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>A)在对工作目录进行修改前，为保证你的文件是最新的，需要进行更新操作；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>B)在工作目录空白处点击鼠标右键，选择&quot;SVN Update&quot;;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>C)会弹出对话框开始更新，并显示更新了哪些内容，库版本是多少；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">提交工作目录</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>A)在做了修改需要用到提交操作； </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>B)在工作目录处点击鼠标右键，选择&quot;SVN Commit&quot;;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>C)会弹出对话框，可以输入备注信息，显示将要提交哪些文件，点击&quot;OK&quot;开始提交；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>D)弹出对话框显示提交进度，完成后点击&quot;OK&quot;完成提交；</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>2.COM_TOOLS.DT_ajaxReload(table); 更新数据后刷新组件</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Top.COM_TOOLS.alert();相对于整个窗口居中</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>用PS去掉图片上的文字？</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>用修补工具选中</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">2017年8月18日 自适应解决方案：</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span style=\"font-weight:bold;\">需求1：</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>1. 这个矩形的高度和浏览器窗口的高度相同，不能出现纵向滚动条</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>2. 绿色部分高度固定，比如50px</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>紫色部分填充剩余的高度</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>解决方案：</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&lt;</span><span style=\"color:blue;\">div</span><span style=\"color:black;\">&nbsp;id=&quot;main&quot;&gt;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;&lt;</span><span style=\"color:blue;\">div</span><span style=\"color:black;\">&nbsp;id=&quot;nav&quot;&gt;nav&lt;/</span><span style=\"color:blue;\">div</span><span style=\"color:black;\">&gt;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;&lt;</span><span style=\"color:blue;\">div</span><span style=\"color:black;\">&nbsp;id=&quot;content&quot;&gt;content&lt;/</span><span style=\"color:blue;\">div</span><span style=\"color:black;\">&gt;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&lt;/</span><span style=\"color:blue;\">div</span><span style=\"color:black;\">&gt;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">html, body {</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">height</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">100%</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">margin</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">0px</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">padding</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">0px</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">}</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">#main {</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">background-color</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">#999</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">height</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">100%</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">} </span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">#nav {</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">background-color</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">#85d989</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">width</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">100%</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">height</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">50px</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">}</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">#content {</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">background-color</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">#cc85d9</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">width</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">100%</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">position</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">absolute</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">top</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">50px</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">bottom</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">0px</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"color:blue;\">left</span><span style=\"color:black;\">: </span><span style=\"color:#009900;\">0px</span><span style=\"color:black;\">;</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\"><span style=\"color:black;\">}</span></p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Consolas;font-size:6pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">2017年8月21日</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>将数组中的每个元素都转为字符串，用自定义的连接符分隔</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Join()用法：</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>A.将数组中的每个元素都转为字符串</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Arr.Join()</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>B.无缝拼接</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Arr.join(&quot;&quot;)</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>C.将单词组成句子 --单词之间加空格</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Arr.join（&quot; &quot;）</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>D.判断数组是不是空字符数组-无缝拼接后为空则为空字符数组</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>If(Arr.join（&quot;&quot;）==&quot;&quot;){该数组为空字符数组}</span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\"><span style=\"font-weight:bold;\">2017年8月22日</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>1.bootstrap中的类.hidden/.hide样式类均为</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>.hidden/.hide{display:none !important}</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Jquery中的$().show()文档中提示：如果样式规则有以上的写法,则.show不会推翻 !Important。建议通过removeClass()类移除让元素显示出来</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>类似小圆点的样式中添加：font-size:1px ;line-height:1px;</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>Rgba的兼容性问题：兼容IE9+以上</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;margin-left:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>兼容性处理(IE8及以下)：</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;margin-left:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>filter:progid:DXImageTransform.Microsoft.gradient(startcolorstr=#7f000000, endcolorstr=#7f000000);</span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;margin-left:0.29166666in;text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><!--Image link to 'db755.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>兼容display:inline-block *display:inline;*zoom:1 </span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;margin-left:0.29166666in;text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\"><!--Image link to 'eaf35.png' can be here--></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>页面结构 css放在style里,功能样式图片放在img里 外层素材图片放在images </span></p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33333334in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\"><span>两个子元素都需要设line-height前提设的值都一样 给父元素设就好啦 </span></p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;margin-left:0.29166666in;text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Calibri;font-size:10pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:Calibri;font-size:10pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33402777in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-indent:0.33402777in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-indent:1.2069445in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:start;hyphenate:auto;font-family:Calibri;font-size:10pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:center;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:14pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "\n" +
            "<p style=\"text-indent:0.29166666in;text-align:justify;hyphenate:auto;font-family:宋体;font-size:12pt;\">&nbsp;</p>\n" +
            "</span>\n" +
            "</p>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>" +
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
        String path = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX + "fonts").getPath();
        System.out.println(path.substring(1));
        fp.addDirectory(path); // 自定义字体路径、解决中文,可先用绝对路径测试。
        props.setFontProvider(fp);
        // props.setBaseUri(baseResource); // 设置html资源的相对路径
        HtmlConverter.convertToPdf(html, outputStream, props); // 无法灵活设置页边距等

    }

    public static void main(String[] args) throws IOException {

//        String path = "C:\\Users\\WangYang\\Desktop\\xxxx1.pdf";
//        FileOutputStream fileOutputStream = new FileOutputStream(path);
//        Html2Pdf.convert(str, fileOutputStream);.
        System.out.println(delITag(str));

    }


    public static String delITag(String content) {
        Document doc = Jsoup.parse(content);
        List<Element> spans = doc.getElementsByTag("span");
        if (CollectionUtils.isNotEmpty(spans)) {
            for (int i = 0; i < spans.size(); ++i) {
                Element iTag = (Element) spans.get(i);
                if (iTag != null) {
                    Attributes attributes = iTag.attributes();
                    if (attributes != null) {
                        attributes.remove("style");
                        attributes.remove("id");
                    }
                    List<Element> emTags = iTag.getElementsByClass("quote-index-x");
                    if (CollectionUtils.isNotEmpty(emTags)) {
                        Element emTag = (Element) emTags.get(0);
                        emTag.remove();
                    }
                    if (!StringUtils.isEmpty(iTag.text())) {
                        iTag.text(iTag.text().trim());
                    }
                }
            }
            content = doc.html();
        }
        return content;
    }
}
