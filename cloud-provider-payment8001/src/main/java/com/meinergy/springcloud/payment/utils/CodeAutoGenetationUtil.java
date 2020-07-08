package com.meinergy.springcloud.payment.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CodeAutoGenetationUtil
 *
 * @author chenwang
 * @date 2020/7/7
 */
public class CodeAutoGenetationUtil {

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入数据库表名"+tip+":");
        System.out.println(help.toString());
        if(scanner.hasNext()){
            String ipt = scanner.next();
            if(StringUtils.isNotEmpty(ipt)){
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的"+tip+"!");
    }

    public static void main(String[] args) {
        //自动代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir("E://outDir");
        gc.setAuthor("WongChan");
        gc.setOpen(false);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        /*dsc.setSchemaName("public");*/
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();
        //模块名
        pc.setModuleName("");
        //父包名
        pc.setParent("com.meinergy.springcloud");
        pc.setEntity("commons.entity");
        pc.setController("payment.controller");
        pc.setMapper("payment.mapper");
        pc.setService("payment.service");
        pc.setServiceImpl("payment.service.impl");
        mpg.setPackageInfo(pc);

        //自定义配置
        InjectionConfig config = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        //默认优先输出自定义配置
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输出文件名
                return projectPath+"/src/main/resources/mapper/"
                        +tableInfo.getEntityName()+"Mapper"+ StringPool.DOT_XML;
            }
        });
        config.setFileOutConfigList(focList);
        mpg.setCfg(config);

        /*//配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);*/

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setRestControllerStyle(true);
        strategy.setEntityLombokModel(true);
        strategy.setCapitalMode(false);

        //表生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //字段生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //实体类继承父类
        strategy.setSuperEntityClass(com.baomidou.mybatisplus.extension.activerecord.Model.class,NamingStrategy.underline_to_camel);
        //mapper继承父类
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        //service继承父类
        strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
        //服务实现类继承父类
        strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        //写于父类的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分隔").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName()+"_");
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
