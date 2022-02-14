package com.wanghu.spring.Conditional;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

	//返回值，就是到导入到容器中的组件全类名
	//AnnotationMetadata:当前标注@Import注解的类的所有注解信息
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
//		Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
//		System.out.println(annotationTypes);
		//方法不要返回null值
		return new String[]{"com.wanghu.spring.bean.Blue","com.wanghu.spring.bean.Yellow"};
	}

}
