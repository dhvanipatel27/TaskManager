package org.precision.TaskManager.service;

import java.util.List;

import org.precision.TaskManager.dao.TaskDao;
import org.precision.TaskManager.model.Task;


public class TaskService {

	TaskDao taskDao = new TaskDao();
	Task task = new Task();

	public List<Task> getAllTasks() {
		return taskDao.getTasks(); 
	}

	public Task getTaskById(int id) {
		System.out.println("TaskService" +id);
		return taskDao.getTaskRecords(id); //taskDao.getTask(id);

	}
	
	public String addTask(Task task) {
		System.out.println("reached to addTask");
		return taskDao.insertTask(task);
	}
	
	public Task updateTask(int id, Task task) {
		return taskDao.updateTask(id,task);
	} 

	public void deleteTask(int id) {
		taskDao.deleteTask(id);
		
	}
	
}
