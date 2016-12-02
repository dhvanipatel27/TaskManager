(function () {
    'use strict'
    app.controller('EditTaskController', function ($scope, TasksSvc,ConfigVarSvc, $routeParams) {
        $scope.title = "Edit Task";
        $scope.task = {};
        console.log($routeParams.taskid);
        $scope.selectOptions = ConfigVarSvc.getSelectOptions();
        $scope.getTask = function (taskid) {
        	TasksSvc.getTaskById(taskid).then(function(d){
        		console.log(taskid);
        		console.log(d);
        		$scope.task=d.data;	
        		$scope.task.uscis_delivery_date=new Date(d.data.uscis_delivery_date);
        		$scope.task.uscis_decision_date=new Date(d.data.uscis_decision_date);
        		$scope.task.uscis_due_date=new Date(d.data.uscis_due_date);
        		$scope.task.internal_due_date=new Date(d.data.internal_due_date);
        		$scope.task.requested_recieved_date=new Date(d.data.requested_recieved_date);
        	});
        
        }
        $scope.getTask($routeParams.taskid);
        //console.log($scope.task);

           $scope.saveTask = function () {
            TasksSvc.updateContactById($routeParams.taskid,$scope.task);
                alert("contact updated!!");     
            }
            //console.log($scope.contact);
         

    });
})();