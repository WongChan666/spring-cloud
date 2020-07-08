package com.meinergy.springcloud.payment.utils;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.converts.DmTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Generator
 *
 * @author chenwang
 * @date 2020/6/5
 */
public class Generator {

    /**
     * <p>
     * 代码生成器
     * </p>
     */
    /*public static String scanner(String tip){
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
    }*/

    public static void main(String []args){
        //表名
        String[] tables = {
                "user"
        };
        //数据库地址
        String url = "jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        //数据库用户名
        String userName = "root";
        //数据库密码
        String password = "123456";
        //数据库驱动
        String driverName = "com.mysql.cj.jdbc.Driver";
        //数据库类型
        String type = "MYSQL";
        //作者
        String author = "WongChan";
        //父包名
        String parentPackage = "com.meinergy.springcloud";
        //模块名
        String moduleName = "";
        //去掉表前缀
        //String[] profix = {"TBL"};
        //生成文件输出地址
        String projectPath = System.getProperty("user.dir");
        String mudelName = "\\cloud-provider-payment8001";
        String outputDir = projectPath+mudelName+"\\src\\main\\java";
        GenerateConfig config = new GenerateConfig();
        config.setDbType(DbType.getDbType(type));
        config.setJdbcUrl(url);
        config.setJdbcUserName(userName);
        config.setJdbcPassword(password);
        config.setJdbcDriver(driverName);
        config.setAuthor(author);
        config.setParentPackage(parentPackage);
        config.setModuleName(moduleName);
        config.setIncludeTables(tables);
        //config.setTablePrefix(profix);
        config.setOutputDir(outputDir);
        generate(config);
    }



    public static void generate(GenerateConfig generateConfig){
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(generateConfig.getOutputDir());
        gc.setFileOverride(true);
        //ActiveRecord特性
        gc.setActiveRecord(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        gc.setEnableCache(false);
        // 自动打开输出目录
        gc.setOpen(false);
        gc.setAuthor(generateConfig.getAuthor());
        gc.setSwagger2(true);
        gc.setBaseColumnList(true);
        //主键策略
        gc.setIdType(IdType.ASSIGN_UUID);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");

        mpg.setGlobalConfig(gc);

        /*//数据库配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("mysql.cj.jdbc.driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://localhost:3306/study?serverTimezone=GMT%2B8");
        mpg.setDataSource(dsc);*/

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(generateConfig.getDbType());
        dsc.setDriverName(generateConfig.getJdbcDriver());
        dsc.setUsername(generateConfig.getJdbcUserName());
        dsc.setPassword(generateConfig.getJdbcPassword());
        dsc.setUrl(generateConfig.getJdbcUrl());
        dsc.setTypeConvert(new DmTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                //将数据库中NUMBER转换成double
                if (fieldType.toLowerCase().contains("number")) {
                    return DbColumnType.DOUBLE;
                }
                if (fieldType.toLowerCase().contains("bigint")) {
                    return DbColumnType.LONG;
                }
                if (fieldType.toLowerCase().contains("date")) {
                    return DbColumnType.DATE;
                }
                return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
            }
        });
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(false);
        strategy.setRestControllerStyle(true);
        strategy.setEntityLombokModel(true);
        strategy.setEntityTableFieldAnnotationEnable(false);
        // 此处可以移除表前缀表前缀
        strategy.setTablePrefix(generateConfig.getTablePrefix());
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 字段生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityColumns("create_time", "update_time");
        // mapper 父类
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        // 实体父类
        strategy.setSuperEntityClass(com.baomidou.mybatisplus.extension.activerecord.Model.class,NamingStrategy.underline_to_camel);
        // 接口父类
        strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
        // 接口实现类父类
        strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        // 需要生成的表
        strategy.setInclude(generateConfig.getIncludeTables());

        ConfigBuilder config = new ConfigBuilder(new PackageConfig(), dsc, strategy, new TemplateConfig(), gc);
        List<TableInfo> list = config.getTableInfoList();

        // 公共字段填充
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill("createTime", FieldFill.INSERT));
        tableFills.add(new TableFill("updateTime", FieldFill.UPDATE));
        strategy.setTableFillList(tableFills);
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        //父包名
        pc.setParent(generateConfig.getParentPackage());
        //父包模块名
        pc.setModuleName(generateConfig.getModuleName());
        //实体类父包
        pc.setEntity("payment.entity");
        //controller父包
        pc.setController("payment.controller");
        //mapper父包
        pc.setMapper("payment.mapper");
        //xml父包
        pc.setXml("payment.xml");
        pc.setServiceImpl("payment.service.impl");
        pc.setService("payment.service");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
    }
}
