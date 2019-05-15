## 1、项目介绍  
 #### 功能:
 汉字、成语、词语、歇后语、对联 数据爬取，ip的地区查询API、地区邮编查询API、唐诗宋词API、汉字、成语、词语、歇后语、对联API 
 #### 思路:
 * 汉字、成语、词语、歇后语、对联，数据是通过网上爬取插入数据库，接口通过查询数据库
 * ip的地区查询接口是借助百度开发平台的接口
 * 地区邮编查询、唐诗宋词接口通过查询数据库
 #### 使用:
  整个项目，直接pull下来，运行ToolApplication.java。浏览器访问查看接口：http://localhost:8000/swagger-ui.html
***
## 2、项目架构
```
└── 基础
    └── Java
└── 框架
    └── Springboot
    └── Mybatis
    └── Jsoup 一款Java 的HTML解析器，本项目用于数据爬取
└── 数据库
    └── mysql
└── 其他
    └── lombok 通过简单注解来精简代码达到消除冗长代码，本项目用于实体类
    └── Swagger 是一个规范和完整的框架，用于生成、描述、调用和可视化 RESTful 风格的 Web 服务
```
***
## 3、项目主要目录  
#### src/main/java/com/cf/tool/spider：
* [CiYuSpider.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/spider/CiYuSpider.java)：词语数据爬取  
* [DuiLianSpider.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/spider/DuiLianSpider.java)  : 对联数据爬取  
* [XieHouYuSpider.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/spider/XieHouYuSpider.java)：歇后语数据爬取  
* [ZiSpider.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/spider/ZiSpider.java)：汉字数据爬取  
* [ChengYuSpider.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/spider/ChengYuSpider.java)：成语数据爬取  

 #### src/main/java/com/cf/tool/controller： 
* [ChengYuController.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/controller/ChengYuController.java)：成语相关接口  
* [CiYuController.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/controller/CiYuController.java): 词语相关接口  
* [DuiLianController.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/controller/DuiLianController.java)：对联相关接口  
* [IpAddressController.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/controller/IpAddressController.java)：查询ip的地区接口  
* [PoetryController.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/controller/PoetryController.java)：唐诗相关接口  
* [RegionPostcodeController.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/controller/RegionPostcodeController.java)：地区邮编相关接口   
* [XieHouYuController.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/controller/XieHouYuController.java)：歇后语相关接口  
* [ZiController.java](https://github.com/caov/tool/blob/master/src/main/java/com/cf/tool/controller/ZiController.java)：汉字相关接口  

#### /sql：
* [chengyu.sql](https://github.com/caov/tool/tree/master/sql)：成语sql文件 
* [xiehouyu.sql](https://github.com/caov/tool/tree/master/sql)：歇后语sql文件 
* [zi.sql](https://github.com/caov/tool/tree/master/sql)：汉字sql文件 
***
## 4、接口查询: 
1、/api/chengyu/getChengYuMessageByWord 接口查询成语 "安然无恙"  
接口返回：
```
 {
        "word": "安然无恙",
        "pinyin": "ān rán wú yàng",
        "explanation": "恙病。原指人平安没有疾病。现泛指事物平安未遭损害。",
        "derivation": "《战国策·齐策》岁亦无恙耶？民亦无恙耶？王亦无恙耶？。”",
        "example": "只求处士每岁元旦，作一朱幡，上图日月五星之文，立于苑东，吾辈则安然无恙矣。★明·冯梦龙《醒世恒言》第四卷"
      }
 ```
2、/api/ipAddress/getAddressByIp 接口查询ip "14.215.177.38"  
接口返回： 
 ```
{
  "data": "广东省佛山市",
}
 ```
3、/api/xiehouyu/getXieHouYuByRiddle 接口查询 "狗咬吕洞宾"  
接口返回：
 ```
 {
   "riddle": "狗咬吕洞宾",
   "answer": "不识好人心"
 }
 ```
 4、/api/zi/getZiMessage 接口查询 "国"  
接口返回：
  ```
{
    "word": "国",
    "oldword": "國",
    "strokes": "8",
    "pinyin": "ɡuó",
    "radicals": "囗"
  }
```
***
**本仓库无任何商业目的！如果有侵权行为将及时删除！**
    
