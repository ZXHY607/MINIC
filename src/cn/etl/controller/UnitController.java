package cn.etl.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.etl.entity.Unit;
@Controller
@RequestMapping("/unit")
public class UnitController extends BaseController<Unit> {
	@RequestMapping("/findUnitsOfCourse")
	public @ResponseBody List<Unit> findUnitsOfCourse(Integer cId)
	{
		if(cId==null) return null;
		return baseDao.find("from Unit where uId.cId="+cId);
	}
}
