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
 * @description: 汉字爬虫
 * @author: cf
 * @create: 2019-05-10 10:34
 */
public class ZiSpider {

    private static final String beginUrl = "http://www.zd9999.com/zi/index.htm";

    public static void main(String[] args)throws Exception {

        //所有url生成
        Set<String> setUrls = new HashSet<>();
        setUrls.add(beginUrl);
        for (int j = 2; j <= 101; j++) {
            String allurl = String.format("http://www.zd9999.com/zi/index_%d.htm", j);
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
                    Document ziDocument =Jsoup.parse(new URL(ziUrl).openStream(), "gbk", ziUrl);
                    //System.out.println(ziDocument);
                    Elements ziElements = ziDocument.select("table[bgcolor=#79BCFF] td");

                    String word = ziElements.eq(1).text();
                    String oldword = ziElements.eq(4).text();
                    String strokes = ziElements.eq(6).text();
                    String pinyin = ziElements.eq(8).text();
                    String radicals = ziElements.eq(10).text();
                    System.out.println(word+"----"+oldword+"----"+strokes+"----"+pinyin+"----"+radicals+"----");

                    //插入数据库
                    String sqlInsert = "insert into tool.zi(word, oldword,strokes,pinyin,radicals) values(?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sqlInsert);
                    stmt.setString(1, word);    //设置SQL语句第1个“？”的值
                    stmt.setString(2, oldword);
                    stmt.setString(3, strokes);
                    stmt.setString(4, pinyin);
                    stmt.setString(5, radicals);
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
