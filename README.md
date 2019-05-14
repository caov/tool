# 项目介绍  
 汉字、成语、词语、歇后语、对联 数据爬取爬虫，ip的地区查询API、地区邮编查询API、唐诗宋词API、汉字、成语、词语、歇后语、对联API  
## 项目目录  
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

***
## 项目架构
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
**本仓库无任何商业目的！如果有侵权行为将及时删除！**
    
