(function(){
    'use strict'
    app.controller('ShowTaskController', function($scope,$routeParams,TasksSvc){
        $scope.title="Single Task";
   var InitializeTask=function(){
       var obj=TasksSvc.getTaskById($routeParams.taskid);
       $scope.task=obj;
       console.log("jhbhj"+ $scope.task.tId);
   }
   InitializeTask();
        console.log("Task id of this page is:" + $routeParams.taskid);
        })
})();