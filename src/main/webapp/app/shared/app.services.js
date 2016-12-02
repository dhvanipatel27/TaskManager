
(function () {
    app.factory("TasksSvc", function ($http) {
        var tasks = {
            "data": [
                {
                    "_id": "1",
                    "priority": "Medium",
                    "type": "H1B",
                    "processing_by": "Attorney",
                    "employee_name": "Employee 3",
                    "task_subject": "H1B CAP",
                    "requested_by": "Client",
                    "task_owner": "Internal 1",
                    "request_receive_date": "07-12-2015",
                    "internal_due_date": "08-12-2016",
                    "uscis_due_date": "07-05-2016",
                    "uscis_delivery_date": "05-14-2016",
                    "uscis_decision_date": "08-26-2014",
                    "status": "In Process",
                    "project": "Project 3",
                    "pending_documents": ["Doc 1", "Doc 2"],
                    "comments": ["comment 1", "comment 2"],
                    "active": true
                },
                {
                    "_id": "2",
                    "priority": "High",
                    "type": "H1B",
                    "processing_by": "Internal Filing",
                    "employee_name": "Employee 3",
                    "task_subject": "Project Change",
                    "requested_by": "Sales",
                    "task_owner": "Internal 1",
                    "request_receive_date": "07-12-2015",
                    "internal_due_date": "08-12-2016",
                    "uscis_due_date": "07-05-2016",
                    "uscis_delivery_date": "05-14-2016",
                    "uscis_decision_date": "08-26-2014",
                    "status": "Submitted",
                    "project": "Project 3",
                    "pending_documents": ["Doc 1", "Doc 2"],
                    "comments": ["comment 1", "comment 2"],
                    "active": false
                },
                {
                    "_id": "3",
                    "priority": "High",
                    "type": "H1B",
                    "processing_by": "Attorney",
                    "employee_name": "Employee 3",
                    "task_subject": "Project Change",
                    "requested_by": "Immigration",
                    "task_owner": "Internal 1",
                    "request_receive_date": "07-12-2015",
                    "internal_due_date": "08-12-2016",
                    "uscis_due_date": "07-05-2016",
                    "uscis_delivery_date": "05-14-2016",
                    "uscis_decision_date": "08-26-2014",
                    "status": "Approved",
                    "project": "Project 3",
                    "pending_documents": ["Doc 1", "Doc 2"],
                    "comments": ["comment 1", "comment 2"],
                    "active": true
                }
            ]
        }



        return {
            viewAlltasks: viewAlltasks,
            addtask: addtask,
            getTaskById: getTaskById,
            updateContactById: updateContactById,
            deleteTask: deleteTask
        }

        function viewAlltasks() {
           return $http.get("http://localhost:2016/TaskManager/webapi/tasks");
        }

        function addtask(task) {
           return $http.post("http://localhost:2016/TaskManager/webapi/tasks",task);
        }

        function getTaskById(id) {
        	
            return $http.get("http://localhost:2016/TaskManager/webapi/tasks/"+id);
        }

        function updateContactById(taskId, taskInfo) {
         return $http.put("http://localhost:2016/TaskManager/webapi/tasks/"+taskId, taskInfo);
        }

        function deleteTask(taskId) {
        	console.log("id in services"+taskId);
        	return $http.delete("http://localhost:2016/TaskManager/webapi/tasks/"+taskId);
    
            // var task = tasks['data'].filter(function (task) {
            //     return task._id !== taskId;
            // });
            // tasks['data'].splice(tasks['data'].indexOf(task), 1);
        }
    })
})();