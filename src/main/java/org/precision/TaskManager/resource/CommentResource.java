package org.precision.TaskManager.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.precision.TaskManager.model.Comment;
import org.precision.TaskManager.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
private CommentService commentService = new CommentService();
	
	@GET
	public List<String> getAllComments(@PathParam("messageId") int taskId) {
		return commentService.getAllComments(taskId);
	}


}
