(function () {
    'use strict'
    app.controller('HomeController', function ($scope, TasksSvc,$location) {
        $scope.title = "TASKS";
        
        $scope.tasks = '';

        var InitializeTasks = function () {
        	TasksSvc.viewAlltasks().then(function(d){
        		$scope.tasks=d.data;
        		
        	});
           

        }
        InitializeTasks();


        $scope.goTo=function(taskid){
         $location.path('/showtask/'+taskid);
        }

        $scope.deleteTask=function(taskid){
        	console.log("id in ctrls"+taskid);
            TasksSvc.deleteTask(taskid).then(function(d){
            	 InitializeTasks();
                 alert("task deleted!!!!");
            });
             
        }

        // var InitializeHome = function () {
        //     ContactsSvc.viewAllContacts().then(function (d) {
        //         $scope.contacts = d.data;
        //         console.log("gvjhv"+d.data);
        //     })
        // }
        // InitializeHome();

    })
})();