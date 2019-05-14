package com.cf.tool.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: tool
 * @description: 歇后语爬虫：获取所有url,借助Jsoup解析页面获取歇后语数据，插入数据库
 * @author: cf
 * @create: 2019-05-09 16:54
 */
public class XieHouYuSpider {
    private static final String beginUrl = "http://xhy.5156edu.com/html2/xhy.html";


    public static void main(String[] args)throws Exception{

        //所有url生成
        Set<String> setUrls = new HashSet<>();
        setUrls.add(beginUrl);
        for (int j = 2; j <= 281; j++){
            String allurl = String .format("http://xhy.5156edu.com/html2/xhy_%d.html",j);
            setUrls.add(allurl);
        }

        MysqlConnect mysqlConnect = new MysqlConnect();
        Connection conn = mysqlConnect.getCon();
        try {
            for(String url : setUrls) {
                Document document = Jsoup.connect(url).get();
                //获取歇后语内容
                Elements elements = document.select("table[style=word-break:break-all] tr[bgcolor=#ffffff]");
                    for (Element element : elements){
                        Elements riddleElement = element.select("td[width=60%]");
                        String riddle = riddleElement.text();
                        Elements answerElement = element.select("td[width=40%]");
                        String answer = answerElement.text();
                        System.out.println(riddle+"----------"+answer);

                        //插入数据库
                        String sqlInsert = "insert into tool.xiehouyu(riddle, answer) values(?, ?)";
                        PreparedStatement stmt = conn.prepareStatement(sqlInsert);
                        stmt.setString(1, riddle);    //设置SQL语句第1个“？”的值
                        stmt.setString(2, answer);    //设置SQL语句第2个“？”的值
                        stmt.executeUpdate();
                    }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
