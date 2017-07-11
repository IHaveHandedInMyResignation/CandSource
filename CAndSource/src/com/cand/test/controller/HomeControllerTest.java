package com.cand.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.cand.source.controller.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {HomeController.class})
public class HomeControllerTest{
	HomeController controller;
	
	MockMvc mockMvc;
	
	@Before
	public void onInit(){
		controller = new HomeController();
		mockMvc = standaloneSetup(controller).build();
	}

	@Test
	public void testShowHome() throws Exception{
		
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
	
	@After
	public void onDestroy(){
		controller = null;
		mockMvc = null;
	
	}
}
  