package org.precision.TaskManager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.precision.TaskManager.model.Task;
//DB Connectivity..
public class TaskDao {
	
	public Connection getConnnection() {
		

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/taskmanagerdb", "root", "oracle");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public List<Task> getTasks() {
		
		List<Task> tasks = new ArrayList<Task>();
		Connection con = getConnnection();
		ResultSet rs = null;
		
		try {
			String sql ="select Firstset.*, secondset.* from (select t.* from task t where t.active='true') Firstset LEFT JOIN ( select tc.* from task_comment tc INNER JOIN ( select task_id, max(updated_date) AS maxCtreatedDate from task_comment group by task_id) groupct on tc.task_id=groupct.task_id and tc.updated_date = groupct.maxCtreatedDate) secondset on Firstset.tid = secondset.task_id order by Firstset.tid";
			PreparedStatement st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while (rs.next()) {
				Task t = new Task();
						
				t.settId(rs.getInt("tid"));
				t.setPriority(rs.getString("priority"));
				t.setType(rs.getString("type"));
				t.setProcessing_by(rs.getString("processing_by"));
				t.setEmployee_name(rs.getString("employee_name"));
				t.setTask_subject(rs.getString("task_subject"));
				t.setRequested_by(rs.getString("requested_by"));
				t.setTask_owner(rs.getString("task_owner"));
				t.setRequested_recieved_date(rs.getDate("request_recieve_date"));
				t.setInternal_due_date(rs.getDate("internal_due_date"));
				t.setUscis_due_date(rs.getDate("uscis_due_date"));
				t.setUscis_delivery_date(rs.getDate("uscis_delivery_date"));
				t.setUscis_decision_date(rs.getDate("uscis_decision_date"));
				t.setStatus(rs.getString("status"));
				t.setProject_name(rs.getString("project_name"));
				t.setPending_documents(rs.getString("pending_documents"));
				t.setComment_detail(rs.getString("comment_detail"));
				
				tasks.add(t);
				System.out.println(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
	
	public Task getTaskRecords(int id) {
		
		Task t1 = new Task();
		
		Connection con = getConnnection();
		ResultSet rs = null;
		System.out.println("taskDao:"+id);		
		try {
			//PreparedStatement st = con.prepareStatement("select t.*, c.comment_detail from task t,task_comment c where t.tid=? and t.active='true' and t.tid = c.task_id");
			
			String sql ="select Firstset.*, secondset.* from (select t.* from task t where t.active='true' and t.tid= ?) Firstset LEFT JOIN ( select tc.* from task_comment tc INNER JOIN ( select task_id, max(updated_date) AS maxCtreatedDate from task_comment group by task_id) groupct on tc.task_id=groupct.task_id and tc.updated_date = groupct.maxCtreatedDate) secondset on Firstset.tid = secondset.task_id order by Firstset.tid";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
					
			while (rs.next()) {
								
				t1.settId(rs.getInt("tid"));
				t1.setPriority(rs.getString("priority"));
				t1.setType(rs.getString("type"));
				t1.setProcessing_by(rs.getString("processing_by"));
				t1.setEmployee_name(rs.getString("employee_name"));
				t1.setTask_subject(rs.getString("task_subject"));
				t1.setRequested_by(rs.getString("requested_by"));
				t1.setTask_owner(rs.getString("task_owner"));
				t1.setRequested_recieved_date(rs.getDate("request_recieve_date"));
				t1.setInternal_due_date(rs.getDate("internal_due_date"));
				t1.setUscis_due_date(rs.getDate("uscis_due_date"));
				t1.setUscis_delivery_date(rs.getDate("uscis_delivery_date"));
				t1.setUscis_decision_date(rs.getDate("uscis_decision_date"));
				t1.setStatus(rs.getString("status"));
				t1.setProject_name(rs.getString("project_name"));
				t1.setPending_documents(rs.getString("pending_documents"));
				
				t1.setAllComments(getAllComments(id));
				System.out.println("Comment array:" +getAllComments(rs.getInt("tid")));
				System.out.println(t1);
				System.out.println(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t1;
	}

	public List<String> getAllComments(int taskId) {
		
		List<String> comments = new ArrayList<String>();
		
		Connection con = getConnnection();
		ResultSet rs = null;
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement("select c.comment_detail from task_comment c where task_id=?");
			ps.setInt(1, taskId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				comments.add(rs.getString("comment_detail"));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(comments);
		return comments;
	}
	
	
	public String insertTask(Task task) {
		
		Connection con = getConnnection();
		System.out.println("reached to insertTask in Dao");
		
		try {
			PreparedStatement st = con.prepareStatement("insert into task (tid,priority,type,processing_by,employee_name,task_subject,requested_by,task_owner,request_recieve_date,internal_due_date,uscis_due_date,uscis_delivery_date,uscis_decision_date,status,project_name,pending_documents,active,created_date,updated_date)values (NULL,?,?,?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,'true',CURTIME(),CURTIME())", new String [] {"tid"});
			
			//st.setInt(1, task.gettId());
			st.setString(1, task.getPriority());
			st.setString(2, task.getType());
			st.setString(3, task.getProcessing_by());
			st.setString(4, task.getEmployee_name());
			st.setString(5, task.getTask_subject());
			st.setString(6, task.getRequested_by());
			st.setString(7, task.getTask_owner());
			st.setDate(8,new java.sql.Date(task.getRequested_recieved_date().getTime()));
			st.setDate(9,new java.sql.Date(task.getInternal_due_date().getTime()));
			st.setDate(10,new java.sql.Date(task.getUscis_due_date().getTime()));;
			st.setDate(11,new java.sql.Date(task.getUscis_delivery_date().getTime()));
			st.setDate(12, new java.sql.Date(task.getUscis_decision_date().getTime()));;
			st.setString(13, task.getStatus());
			st.setString(14, task.getProject_name());
			st.setString(15, task.getPending_documents());
			//st.setString(16, task.getActive());
			//st.setDate(17, (Date)task.getCreated_date());
			//st.setDate(18, (Date)task.getUpdated_date());
			
			int j= st.executeUpdate();
			System.out.println(j);
			
			int task_id = 0;
			if(j>0) {
				ResultSet rs = st.getGeneratedKeys();
				while(rs.next()) {
					//System.out.println(rs.getInt(1));
					task_id = rs.getInt(1);
				}
			}
			int i = insertComment(task_id,task.getComment_detail());
			
			if(i==1)
				return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private int insertComment(int taskId,String comment_detail) {
		
		Connection con = getConnnection();
				
		try {
			PreparedStatement ps = con.prepareStatement("insert into task_comment (comment_id,task_id,comment_detail,created_date,updated_date) values (NULL,?,?,CURTIME(),CURTIME())");
			
			ps.setInt(1,taskId);
			ps.setString(2, comment_detail);
			
			ps.executeUpdate();
			
			return 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public Task updateTask(int id, Task task) {
		
		Connection con =  getConnnection();
		PreparedStatement st = null;

		try {
			st = con.prepareStatement("update task  set priority=?,type=?,processing_by=?,employee_name=?,task_subject=?,requested_by=?,task_owner=?,request_recieve_date=?,internal_due_date=?,uscis_due_date=?,uscis_delivery_date=?,uscis_decision_date=?,status=?,project_name=?,pending_documents=?,active='true',updated_date=CURTIME() where tid=?  ");
			
			st.setString(1, task.getPriority());
			st.setString(2, task.getType());
			st.setString(3, task.getProcessing_by());
			st.setString(4, task.getEmployee_name());
			st.setString(5, task.getTask_subject());
			st.setString(6, task.getRequested_by());
			st.setString(7, task.getTask_owner());
			st.setDate(8,new java.sql.Date(task.getRequested_recieved_date().getTime()));
			st.setDate(9,new java.sql.Date(task.getInternal_due_date().getTime()));
			st.setDate(10,new java.sql.Date(task.getUscis_due_date().getTime()));;
			st.setDate(11,new java.sql.Date(task.getUscis_delivery_date().getTime()));
			st.setDate(12, new java.sql.Date(task.getUscis_decision_date().getTime()));;
			st.setString(13, task.getStatus());
			st.setString(14, task.getProject_name());
			st.setString(15, task.getPending_documents());
			//st.setString(16, task.getActive());
			st.setInt(16, id);
			
			st.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;
	}
	

	public void deleteTask(int id) {
		
		Connection con = null;
		PreparedStatement ps = null;

		con = getConnnection();
		
		try {
			ps = con.prepareStatement("update task set active='false' where tid=?");
			ps.setInt(1, id);
			System.out.println(ps);
			int status = ps.executeUpdate();
			
			System.out.println("status = " + status);
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	}

}
