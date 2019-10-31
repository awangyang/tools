package com.example.tools.word;

import com.aspose.words.Document;
import com.aspose.words.HtmlSaveOptions;
import com.aspose.words.Range;
import com.aspose.words.SaveFormat;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyang
 * @date 2019/10/30
 */
public class ReplaceWord {

    public static Document docReplaceWithAsposeWords(byte[] bytes, Map<String, String> map) {
        Document document = null;
        try {
            InputStream is = new ByteArrayInputStream(bytes);
            document = new Document(is);
            Range range = document.getRange();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                range.replace(entry.getKey(), entry.getValue(), false, false);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\WangYang\\Desktop\\套头模板3.docx");

        HashMap<String, String> map = new HashMap(16);
        byte[] bytesByFile = FileUtil.getBytesByFile(file);
        map.put("{{content}}", "<html>\n" +
                " <head></head> \n" +
                " <body> \n" +
                "  <p>“百年大计，教育为本。教育大计，教师为本。”教育发展和教师工作，习近平一直非常重视。在他看来，教师不能只做传授书本知识的教书匠，而要成为塑造学生品格、品行、品味的“大先生”。何谓“大先生”？谁是值得点赞的“大先生”？在第35个教师节来临之际，一起来看看习近平怎么说。<span>”报道认为，由于年龄在35岁以下的人在印度约13亿人口中占到近三分之二的比例，而且在从4月11日开始的大选中有超过1500万人是首次参加投票，所以获得大明星的首肯可能很关键。</span></p> \n" +
                "  <p>　　<strong>◎何谓好老师、“大先生”</strong></p> \n" +
                "  <p align=\"center\"><img alt=\"\" oldsrc=\"W020190909480068883730.jpg\" src=\"http://news.youth.cn/sz/201909/W020190909480068883730.jpg\"></p> \n" +
                "  <p>　　2014年教师节的前一天，习近平来到北京师范大学同师生代表座谈。在讲话中，他用了将近三分之二的篇幅，与大家交流“怎样才能成为好老师”。</p> \n" +
                "  <p>　　在习近平看来，好老师没有统一的模式，可以各有千秋、各显身手，但有一些共同的、必不可少的特质。</p> \n" +
                "  <p>　　“有理想信念、有道德情操、有扎实学识、有仁爱之心”，这是习近平心中好老师的四条标准。</p> \n" +
                "  <p>　　“四有”老师是什么样？心中要有国家和民族；要有“捧着一颗心来，不带半根草去”的奉献精神；始终处于学习状态，给学生一碗水，教师要有一潭水；应该把自己的温暖和情感倾注到每一个学生身上。</p> \n" +
                "  <p>　　2018年5月，习近平来到北京大学与师生座谈，又谈到好老师的话题。他表示，评价教师队伍素质的第一标准应该是师德师风。他提出，要“以德立身、以德立学、以德施教”。</p> \n" +
                "  <p>　　同年，在教师节当天召开的全国教育大会上，习近平再次强调，做老师就要执着于教书育人，有热爱教育的定力、淡泊名利的坚守。</p> \n" +
                "  <p>　　多次谈、反复谈这个话题，是因为习近平一直对好老师给予很高的期望，他把他们比作打造中华民族“梦之队”的“筑梦人”，他说“一个人遇到好老师是人生的幸运，一个学校拥有好老师是学校的光荣，一个民族源源不断涌现出一批又一批好老师则是民族的希望。”</p> \n" +
                "  <p>　　<strong>◎谁是值得点赞的“大先生”</strong></p> \n" +
                "  <p align=\"center\"><img alt=\"\" oldsrc=\"W020190909480068924000.jpg\" src=\"http://news.youth.cn/sz/201909/W020190909480068924000.jpg\"></p> \n" +
                "  <p align=\"center\">“是老师培养了我们。”</p> \n" +
                "  <p>　　2016年教师节前夕，“老校友”习近平回到北京市八一学校。他同陈仲韩、陈秋影等几位老师一一握手。他说，看到各位老师精神这么好，我心里特别高兴。当年老师对我们要求十分严厉，现在回想起来，终生受益。</p> \n" +
                "  <p>　　习近平曾在另一个场合动情地回忆起教过自己的老师们：“他们教给我知识、教给我做人的道理，让我受益无穷。”对于好老师、“大先生”，习近平从来不吝称赞。</p> \n" +
                "  <p>　　就在几天前，习近平给全国涉农高校的书记校长和专家代表回信，称赞他们为“三农”事业发展作出了积极贡献。</p> \n" +
                "  <p>　　他称赞河北保定学院西部支教毕业生“让青春之花绽放在祖国最需要的地方”；他赞叹中央美院老教授耄耋之年，初心不改，依然心系祖国接班人培养；他赞扬北大老教授几十年如一日笔耕不辍、悉心育人，向他们表示敬意。</p> \n" +
                "  <p>　　他曾与国学泰斗汤一介教授促膝交谈，赞扬他为中华优秀传统文化继承、发展、创新作出了很大贡献；他称赞河北农业大学教授李保国35年如一日长期奋战在扶贫攻坚和科技创新第一线；他号召大家学习吉林大学教授黄大年教书育人、敢为人先的敬业精神。</p> \n" +
                "  <p>　　还有那些奋斗在基层的普通教师，他们的事迹习近平也都装在心里：有的一生中忘了自己、把全部身心扑在学生身上，有的把自己有限的工资用来资助贫困学生，有的背着学生上学、牵着学生的手过急流、走险路……习近平用“感人至深、催人泪下”的赞语向他们致敬。</p> \n" +
                "  <p>　　<strong>◎如何让“大先生”不断涌现</strong></p> \n" +
                "  <p align=\"center\"><img alt=\"\" oldsrc=\"W020190909480068946212.jpg\" src=\"http://news.youth.cn/sz/201909/W020190909480068946212.jpg\"></p> \n" +
                "  <p>　　“形成优秀人才争相从教、教师人人尽展其才、好老师不断涌现的良好局面”，为了这个目标，习近平不遗余力地推动相关工作。</p> \n" +
                "  <p>　　在地方任职时，习近平就非常重视教育、关心老师。他到河北正定不久，看到一份简报反映南牛公社南永固小学18间教室没有一间不漏雨，4名民办教师一年未领到工资。他很生气，立即作了批示。</p> \n" +
                "  <p>　　后来习近平到正定北贾村小学检查工作，看到坍塌的大门破败不堪，老师学生就从墙上的一个大窟窿进进出出，教室房顶的瓦片都快掉完了，他当即发火了，对在场的村干部说：“你们今晚就开会落实整改。”</p> \n" +
                "  <p>　　“就你们村的条件，不应该把小学搞成这个样子，完全有条件把学校好好改善。如果一个月内你们还不行动，就要撤你的职！”</p> \n" +
                "  <p>　　不止一位同行的工作人员说，这是头一回见他发这么大火。</p> \n" +
                "  <p>　　十八大以来，习近平多次强调，要使教师成为“让人羡慕的职业”“最受社会尊重的职业”，要让广大教师“安心从教、热心从教、舒心从教、静心从教”。</p> \n" +
                "  <p>　　对于教师的工作情况和待遇问题，他非常关注。在北京大学考察，他向汤一介教授询问有什么困难和需要；在陕西延安市杨家岭福州希望小学看望，他关切询问教师待遇如何；在重庆石柱土家族自治县中益乡小学考察，他嘱咐学校和老师既要当好老师，又要当好临时家长，把学生教好、管好。</p> \n" +
                "  <p>　　在习近平的推动下，“国培计划”大力实施，“乡村教师支持计划（2015—2020年）”不断推进落实，《关于全面深化新时代教师队伍建设改革的意见》出台……中小学教师的职业“天花板”被打破，乡村教师生活待遇日益提高，一支充满活力的优秀教师队伍正在形成。</p> \n" +
                "  <p>责任编辑：墨北</p> \n" +
                "  <p><span>宝莱坞在莫迪的连任竞选中扮演主要角色。据路透社4月10日报道，2019年年初，12名宝莱坞大腕从印度电影之都孟买</span></p>  \n" +
                " </body>\n" +
                "</html>");
        Document document = docReplaceWithAsposeWords(bytesByFile, map);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\img\\zz3.docx"));
        HtmlSaveOptions htmlSaveOptions = new HtmlSaveOptions();
//        htmlSaveOptions.setImagesFolder(ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX + "img").getPath());
        htmlSaveOptions.setImagesFolder("D:\\img\\");
        try {
            document.save(baos, SaveFormat.HTML);
//            document.save(fileOutputStream, SaveFormat.DOC);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        String content = new String(baos.toByteArray());
        String content = StringEscapeUtils.unescapeHtml(new String(baos.toByteArray()));
        System.out.println(content);
        Document document1 = new Document(new ByteArrayInputStream(content.getBytes()));
        document1.save(fileOutputStream, SaveFormat.DOCX);
    }
}
