package com.philips.training.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.philips.training.domain.Book;
import com.philips.training.domain.Publisher;
import com.philips.training.service.BookService;
import com.philips.training.service.PublisherService;
@Controller
public class ControllerClass {

	BookService bs;
	PublisherService ps;
	
	@Autowired
	public void setBs(BookService bs) {
		this.bs = bs;
	}
	
	@Autowired
	public void setPs(PublisherService ps) {
		this.ps = ps;
	}
	
	@RequestMapping(value="/addPublisher", method=RequestMethod.GET)
	public ModelAndView handleProduct(@RequestParam("name")String name,@RequestParam("city")String city) 
	{		
		Publisher p = new Publisher(name,city);
		
		int id = ps.addNewPublisher(p);
		Map<String,Object> modelData = new HashMap<>();
        modelData.put("result", id);
		
		return new ModelAndView("redirect:/PublisherResponse.jsp", modelData); 
		
		
	}
	
	
	
	@RequestMapping(value="/manageBooks", method=RequestMethod.GET) // to get list we should get via the controller
	public ModelAndView listBooks() {
	    List<Book> all = bs.findAll();		
		String view = "/bookList.jsp";
		Map<String,Object> modelData = new HashMap<>();
		modelData.put("books",all);
		return new ModelAndView(view,modelData);
		
		
	}
	
}
