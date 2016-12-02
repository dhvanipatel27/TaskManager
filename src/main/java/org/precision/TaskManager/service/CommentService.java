package org.precision.TaskManager.service;

import java.util.List;
import java.util.Map;

import org.precision.TaskManager.dao.TaskDao;
import org.precision.TaskManager.model.Comment;
import org.precision.TaskManager.model.Task;


public class CommentService {
	
	TaskDao taskDao = new TaskDao();
	//private Map<Long, Task> taskRecords = TaskDao.getTaskRecords();

	public List<String> getAllComments(int taskId) {
		//Map<Long, Comment> comments = taskRecords.get(messageId).getComments();
		//return new ArrayList<Comment>(comments.values());
		return taskDao.getAllComments(taskId);
	}

}
