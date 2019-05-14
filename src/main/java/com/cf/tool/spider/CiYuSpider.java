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
 * @description: 词语爬虫
 * @author: cf
 * @create: 2019-05-13 14:27
 */
public class CiYuSpider {
    private static final String beginUrl = "http://www.zd9999.com/ci/index.htm";

    public static void main(String[] args)throws Exception {

        //所有url生成
        Set<String> setUrls = new HashSet<>();
        setUrls.add(beginUrl);
        for (int j = 2; j <= 1959; j++) {
            String allurl = String.format("http://www.zd9999.com/ci/index_%d.htm", j);
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
                    Elements ziElements = ziDocument.select("table[bgcolor=#79BCFF] td");
                    String ci = ziElements.eq(1).text();
                    String explanation = ziElements.eq(2).text();
                    System.out.println(ci+"----"+explanation);

                    //插入数据库
                    String sqlInsert = "insert into tool.ci(ci, explanation) values(?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sqlInsert);
                    stmt.setString(1, ci);    //设置SQL语句第1个“？”的值
                    stmt.setString(2, explanation);
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
