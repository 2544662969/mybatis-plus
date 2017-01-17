1、依赖关系：
Mybatis-Plus 仅仅依赖 Mybatis 和 Mybatis-Spring,Mybatis-Plus会自动帮你维护！请勿自行引入，以免引起版本冲突！！！
2、代码生成：
	1）、主键策略选择：
		IdType.AUTO	                    数据库ID自增
		IdType.INPUT	          用户输入ID
		IdType.ID_WORKER	全局唯一ID，内容为空自动填充（默认配置）
		IdType.UUID	                    全局唯一ID，内容为空自动填充
	2）、表及字段命名策略选择：我们建议数据库表名采用下划线命名方式，而表字段名采用驼峰命名方式，这样字段不用做映射就能直接和实体类对应。
	3）、代码生成器：
		com.zhjg.mybatis.plus.generator.MpGenerator
		maven插件：http://git.oschina.net/baomidou/mybatisplus-maven-plugin（待完善）

3、CRUD操作：src/test/main:TUserServiceTest

自动生成controller、service、serviceImpl、mapper、mapper.xml、entity
直接通过service进行增删改查操作
	