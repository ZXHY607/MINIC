package cn.etl.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.etl.dao.BaseDao;
import cn.etl.dao.CourseGroupDao;
import cn.etl.entity.Course;
@Controller
@RequestMapping("/course")
public class CourseController extends BaseController<Course> {
	@Resource(name="courseGroupDaoImpl")
	private CourseGroupDao cGDao;
	@Override
	@Resource(name="courseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		// TODO Auto-generated method stub
		super.setBaseDao(baseDao);
	}
	@Override
	@RequestMapping("/{view}/{id}.fm")
	public String modifyForm(@PathVariable String view, @PathVariable String id, Model model){
		// TODO Auto-generated method stub
		model.addAttribute("gId", id.substring(0, 2));
		model.addAttribute("cIndex", id.substring(2,4));
		model.addAttribute("list",cGDao.loadAll());
		return super.modifyForm(view, id, model);
	}
	@RequestMapping("courseAdd")
	public String add(Course entity, Model model,String cIndex,String gId) {
		// TODO Auto-generated method stub
		entity.setId(gId+cIndex);
		return super.add(entity, model);
	}
}
