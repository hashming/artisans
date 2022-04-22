package com.duoduo.hashming.artisan.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

public class FastAutoGeneratorTest {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://127.0.0.1:3306/hh_demo?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig((scanner, builder) -> {
                    builder.author(scanner.apply("duoduo"))
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\pro_data");
                }) // 指定输出目录)
                // 包配置
                .packageConfig((scanner, builder) -> builder.pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C:\\pro_data")).parent("com.duoduo.hashming.artisan"))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(scanner.apply("请输入表名，多个表名用,隔开")))
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}