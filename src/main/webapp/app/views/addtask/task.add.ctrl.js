(function () {
    'use strict'
    app.controller('AddTaskController', function ($scope, TasksSvc,ConfigVarSvc) {
        $scope.title = "ADD TASK";
        $scope.selectOptions = ConfigVarSvc.getSelectOptions();
        var InitializeTask = function () {
            $scope.task = {};
        }
        InitializeTask();
        
        $scope.saveTask = function () {

           
            console.log($scope.task);
            TasksSvc.addtask($scope.task).then(function(d){
        		console.log($scope.task);
        		 InitializeTask();
                 alert("new task added");
        	});
           
        }
    })
})();