package com.nikhil.personmanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nikhil.personmanagement.entity.Person;
import com.nikhil.personmanagement.service.PersonService;

@Controller
public class ControllerClass {

	@Autowired
	private PersonService service;

	@RequestMapping(value = "createPerson", method = RequestMethod.GET)
	public ModelAndView createPerson(ModelAndView mav, Person person) {
		mav.addObject("person", person);
		mav.setViewName("form");
		return mav;
	}

	@RequestMapping(value = "savePerson", method = RequestMethod.POST)
	public ModelAndView savePerson(ModelAndView mav, @ModelAttribute Person person) {
		boolean flag = service.savePerson(person);
		if (flag == true) {
			mav.addObject("msg", "Person added Successfully...");
		} else {
			mav.addObject("msg", "Unable to add a Person...");
		}
		mav.setViewName("index");
		return mav;
	}

	// ************Find by ID**************
	@RequestMapping(value = "findPerson", method = RequestMethod.GET)
	public ModelAndView findPerson(ModelAndView mav, Person person) {
		mav.addObject("person", person);
		mav.setViewName("findPerson");
		return mav;
	}

	@RequestMapping(value = "displayPerson", method = RequestMethod.GET)
	public ModelAndView displayPerson(ModelAndView mav, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("personId"));
		Person obj = service.findPerson(id);
		mav.addObject("person", obj);
		mav.setViewName("displayPerson");
		return mav;
	}

	// ***********Update**************
	@RequestMapping(value = "updatePage", method = RequestMethod.GET)
	public ModelAndView updatePage(ModelAndView mav, Person person) {
		mav.addObject("person", person);
		mav.setViewName("updatePerson");
		return mav;
	}

	@RequestMapping(value = "getPerson", method = RequestMethod.GET)
	public ModelAndView updatePerson(ModelAndView mav, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("personId"));
		Person obj = service.findPerson(id);
		mav.addObject("person", obj);
		mav.setViewName("updatingPerson");
		return mav;
	}

	@RequestMapping(value = "saveUpdatePerson", method = RequestMethod.POST)
	public ModelAndView savingUpdatedPerson(ModelAndView mav, @ModelAttribute Person person, RedirectAttributes redirectAttribute) {

		service.updatePerson(person);
		redirectAttribute.addFlashAttribute("message", "User updated successfully");
		mav.setViewName("redirect:/displayAll");
		return mav;
	}

	// *****************Delete ************************
	@RequestMapping(value = "deletePerson", method = RequestMethod.GET)
	public ModelAndView deletePerson(ModelAndView mav) {
		mav.setViewName("deleteperson");
		return mav;
	}

	@RequestMapping(value = "deletingperson", method = RequestMethod.GET)
	public ModelAndView deletingPerson(ModelAndView mav, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		int id = Integer.parseInt(request.getParameter("personId"));
		boolean flag = service.deletPerson(id);

		if (flag) {
			redirectAttributes.addFlashAttribute("message", "User deleted successfully");
			mav.setViewName("redirect:/displayAll");
			return mav;
		} else {
			redirectAttributes.addFlashAttribute("message", "Unable to Delete Person");
			mav.setViewName("redirect:/displayAll");
			return mav;
		}
	}
	
	//Display all
	@RequestMapping(value = "displayAll", method =  RequestMethod.GET)
	public ModelAndView displayAll(ModelAndView mav) {
		
		List<Person> list = service.displayAll() ;
		
		mav.addObject("users", list);
		mav.setViewName("displayAll");
		return mav ;
	}

}
