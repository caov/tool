package com.cf.tool.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: tool
 * @description: 成语爬虫
 * @author: cf
 * @create: 2019-05-13 16:19
 */
public class ChengYuSpider {
    private static final String beginUrl = "http://www.zd9999.com/cy/";

    public static void main(String[] args)throws Exception {

        //所有url生成
        Set<String> setUrls = new HashSet<>();
        setUrls.add(beginUrl);
        for (int j = 2; j <= 198; j++) {
            String allurl = String.format("http://www.zd9999.com/cy/index_%d.htm", j);
            setUrls.add(allurl);
        }
        MysqlConnect mysqlConnect = new MysqlConnect();
        Connection conn = mysqlConnect.getCon();
        try {
            for(String url : setUrls) {
                Document document = Jsoup.connect(url).get();
                //获取字典内容
                Elements elements = document.select("a[target=_blank]");
                String prefix = "http://www.zd9999.com";
                for(Element element : elements){
                    String ziUrl = prefix+element.attr("href");
                    Document ziDocument = Jsoup.parse(new URL(ziUrl).openStream(), "gbk", ziUrl);
                    Elements ziElements = ziDocument.select("table[bordercolor=#111111] td");
                    String ci = ziElements.eq(1).text();
                    //去掉长度不为四的成语
                    if(ci.length() != 4)
                        continue;
                    String pinyin = ziElements.eq(4).text();
                    String explanation = ziElements.eq(6).text();
                    String derivation = ziElements.eq(8).text();
                    String example = ziElements.eq(10).text();
                    System.out.println(ci+"----"+pinyin+"----"+explanation+"----"+derivation+"----"+example);

                    //插入数据库
                    String sqlInsert = "insert into tool.chengyu(word,pinyin,explanation,derivation,example) values(?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sqlInsert);
                    stmt.setString(1, ci);    //设置SQL语句第1个“？”的值
                    stmt.setString(2, pinyin);
                    stmt.setString(3, explanation);
                    stmt.setString(4, derivation);
                    stmt.setString(5, example);
                    stmt.executeUpdate();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
