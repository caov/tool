package com.cf.tool.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: tool
 * @description: IP查询地区工具类
 * @author: cf
 * @create: 2019-05-09 15:06
 */
public class IpRegionUtils {
    public static String getAddresses(String ip) throws IOException{
        HttpClient client = HttpClients.createDefault();
        // 创建默认http连接
        HttpPost post = new HttpPost("http://api.map.baidu.com/location/ip");
        // 创建一个post请求
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("ip", ip));
        //传递的参数,百度开放平台申请
        paramList.add(new BasicNameValuePair("ak", "OGNLmlzGl46KE7HU0hblDk2zXPPv0w5v"));
        //传递的参数
        //paramList.add(new BasicNameValuePair("sn", "4015fb921f586536886dc4cf088f7351"));
        //传递的参数
        paramList.add(new BasicNameValuePair("coor", ""));
        //传递的参数
        // 把参转码后放入请求实体中
        HttpEntity entitya = new UrlEncodedFormEntity(paramList, "utf-8"); post.setEntity(entitya);
        // 把请求实体放post请求中
        HttpResponse response = client.execute(post);
        // 用http连接去执行get请求并且获得http响应
        HttpEntity entity = response.getEntity();
        // 从response中取到响实体
        String html = EntityUtils.toString(entity);
        // 把响应实体转成文本
        //System.out.println(html);
        //String a="\u5317\u4eac\u5e02";
        //System.out.println(a);
        String jsonObj = convertUnicode(html);
        String[] temp = jsonObj.split(",");
        if(temp.length<3){
            return "无效ip";//无效IP，局域网测试
        }
        if (jsonObj != null) {
            Map<String, Object> map=JsonUtils.fromJSON(jsonObj,Map.class);
            Map<String, Object> contentMap= (Map<String, Object>) map.get("content");
            String regionAndCity = (String) contentMap.get("address");
            return regionAndCity;
        }
        return null;
    }

    public static String convertUnicode(String ori){
        char aChar;
        int len = ori.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = ori.charAt(x++);
            if (aChar == '\\') {
                aChar = ori.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = ori.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);

        }
        return outBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
        IpRegionUtils ipRegion = new IpRegionUtils();
        System.out.println(ipRegion.getAddresses("14.215.177.38"));
    }
}
