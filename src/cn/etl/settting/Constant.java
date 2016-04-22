package cn.etl.settting;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class Constant {
	   public static final  Map<String, Integer>PAGE_SIZE=new HashedMap(8);
	   static{
		   PAGE_SIZE.put("Admin",8);
		   PAGE_SIZE.put("Student", 8);
		   PAGE_SIZE.put("Teacher", 8);
		   PAGE_SIZE.put("Post", 8);
		   PAGE_SIZE.put("News", 8);
		   PAGE_SIZE.put("Course", 8);
		   PAGE_SIZE.put("Unit", 8);

	   }
	   public static final String RESULT="/result.jsp",LOGIN="/login.jsp";
	   
}
