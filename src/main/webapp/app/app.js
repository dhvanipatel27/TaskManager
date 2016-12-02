var app=angular.module("task-app",['ngRoute']);

app.config(function($routeProvider){
    $routeProvider.when('/',{
       templateUrl: "app/views/home/home.html",
        controller: "HomeController"
    }
    ).when('/addnewtask',{
        templateUrl: "app/views/addtask/task.add.html",
        controller: "AddTaskController"
    }
    ).when('/showtask/:taskid',{
        templateUrl: "app/views/showtask/showtask.html",
        controller: "ShowTaskController"
    }
    ).when('/edit/:taskid',{
        templateUrl: "app/views/addtask/task.add.html",
        controller: "EditTaskController"
    })
});