package cn.etl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.etl.entity.News;
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController<News>{
	
}
