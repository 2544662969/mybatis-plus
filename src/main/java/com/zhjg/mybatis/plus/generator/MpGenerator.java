package com.zhjg.mybatis.plus.generator;

import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MpGenerator {

	/**
	 * <p>
	 * MySQL ������ʾ
	 * </p>
	 */
	public static void main(String[] args) {
		AutoGenerator mpg = new AutoGenerator();
		// ȫ������
		GlobalConfig gc = new GlobalConfig();
		//gc.setOutputDir("D://");
		/**
		 * ֱ�ӽ����ɵĴ����ļ��������ǰ��Ŀ��Դ�ļ���
		 */
		String outPutDir = MpGenerator.class.getResource("/").getPath();
		outPutDir = outPutDir.substring(0, outPutDir.indexOf("target"));
		outPutDir += "src/main/java";
		System.out.println(outPutDir);
		gc.setOutputDir(outPutDir);
		gc.setFileOverride(true);
		gc.setActiveRecord(true);
		gc.setEnableCache(false);// XML ��������
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		//���ɴ����ļ�������
		gc.setAuthor("zhjg");
		// �Զ����ļ�������ע�� %s ���Զ�����ʵ�����ԣ�
		// gc.setMapperName("%sDao");
		// gc.setXmlName("%sDao");
		// gc.setServiceName("MP%sService");
		// gc.setServiceImplName("%sServiceDiy");
		// gc.setControllerName("%sAction");
		mpg.setGlobalConfig(gc);
		// ����Դ����
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("root");
		dsc.setUrl("jdbc:mysql://localhost:3306/mybatis-plus?autoReconnect=true&failOverReadOnly=false&useUnicode=true&amp;characterEncoding=UTF-8");
		mpg.setDataSource(dsc);
		// ��������
		StrategyConfig strategy = new StrategyConfig();
		//strategy.setTablePrefix(new String[]{"t_"});// �˴������޸�Ϊ���ı�ǰ׺
		strategy.setNaming(NamingStrategy.underline_to_camel);// �������ɲ���
		strategy.setInclude(new String[] { "t_user" }); // ��Ҫ���ɵı�
		// strategy.setExclude(new String[]{"test"}); // �ų����ɵı�
		// �ֶ������ɲ���
		strategy.setFieldNaming(NamingStrategy.underline_to_camel);
		// �Զ���ʵ�常��
		// strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
		// �Զ���ʵ�壬�����ֶ�
		//strategy.setSuperEntityColumns(new String[] { "user_id", "age" });
		// �Զ��� mapper ����
		// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
		// �Զ��� service ����
		// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
		// �Զ��� service ʵ���ุ��
		// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
		// �Զ��� controller ����
		// strategy.setSuperControllerClass("com.baomidou.demo.TestController");
		// ��ʵ�塿�Ƿ������ֶγ�����Ĭ�� false��
		// public static final String ID = "test_id";
		// strategy.setEntityColumnConstant(true);
		// ��ʵ�塿�Ƿ�Ϊ������ģ�ͣ�Ĭ�� false��
		// public User setName(String name) {this.name = name; return this;}
		// strategy.setEntityBuliderModel(true);
		mpg.setStrategy(strategy);
		// ������
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.zhjg.mybatis.plus");
		//ģ����
		//pc.setModuleName("test");
		mpg.setPackageInfo(pc);
		// ע���Զ������ã������� VM ��ʹ�� cfg.abc ���õ�ֵ
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};
		mpg.setCfg(cfg);
		// �Զ���ģ�����ã����� copy Դ�� mybatis-plus/src/main/resources/template ���������޸ģ�
		// �����Լ���Ŀ�� src/main/resources/template Ŀ¼��, Ĭ������һ�¿��Բ����ã�Ҳ�����Զ���ģ������
		/**
		 * TemplateConfig����ָ������ģ�������
		 * ����set�����Ĳ�������ָ��ģ���ļ���λ��;
		 * Ĭ����src/main/resources/template·������controller.java.vm...���ļ�
		 * ֱ�ӽ�mybatisԴ����µ�ģ���ļ�copy��src/main/resources/template�����Բ�������ģ���λ��
		 * ����Ͱ�����ķ�ʽָ��·�����ļ����ķ�ʽ����
		 */
		TemplateConfig tc = new TemplateConfig();
		/*tc.setController("template/controller.java.vm");
		tc.setEntity("template/entity.java.vm");
		tc.setMapper("template/mapper.java.vm");
		tc.setXml("template/mapper.xml.vm");
		tc.setService("template/service.java.vm");
		tc.setServiceImpl("template/serviceImpl.java.vm");*/
		mpg.setTemplate(tc);
		// ִ������
		mpg.execute();
		// ��ӡע������
		System.err.println(mpg.getCfg().getMap().get("abc"));
	}
}
