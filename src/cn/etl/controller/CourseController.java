package cn.etl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.etl.entity.Course;
@Controller
@RequestMapping("/course")
public class CourseController extends BaseController<Course> {

}
