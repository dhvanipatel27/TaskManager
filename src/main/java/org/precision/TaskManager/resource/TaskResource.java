package org.precision.TaskManager.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.precision.TaskManager.model.Task;
import org.precision.TaskManager.service.TaskService;

@Path("tasks")
public class TaskResource {
	
	TaskService taskService = new TaskService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
		
	}
	
	
	@GET
	@Path("/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Task getMessage(@PathParam("taskId") int id) {
		System.out.println("tasskResources:"+id);
		return taskService.getTaskById(id);
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addMessage(Task task) {
		System.out.println("reached to addMessage");
		return taskService.addTask(task);
	}
	
	
	@PUT
	@Path("/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Task updateMessage(@PathParam("taskId") int id, Task task) {
		System.out.println("update object id:"+id);
		task.settId(id);
		return taskService.updateTask(id,task);
		
	} 
	
	@DELETE
	@Path("/{taskId}") 
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("taskId") int id) {
		taskService.deleteTask(id);	
		
	}
	

	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
