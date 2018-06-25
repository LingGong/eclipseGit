package com.gl.activity;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
@WebAppConfiguration
public class App {  
   
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	

	@Test
	public void test(){
		Deployment deployment= repositoryService.createDeployment()
						 .addClasspathResource("diagrams/MyProcess.bpmn")
						 .deploy();
		System.out.println(deployment.getId());
		
	}
	
	@Test
	public void test1(){
		runtimeService.startProcessInstanceByKey("myProcess");
	}
	
	@Test
	public void test2(){
		runtimeService.startProcessInstanceByKey("myProcess");
	}
	
	
	@Test
	public void test3(){
		List<Task> list=taskService.createTaskQuery().taskAssignee("张三").list();
		for(Task task:list){
			System.out.println("task DefinitionId"+task.getProcessDefinitionId()+";"+"task name"+task.getName());
		}
	}
	
	
	@Test
	public void test4(){
		taskService.complete("10002");
		
	}
}  
