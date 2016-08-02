!function(){"use strict";function a(a,b){a.when("/",{templateUrl:"/Views/list.html",controller:"MoviesListController"}).when("/movies/add",{templateUrl:"/Views/add.html",controller:"MoviesAddController"}).when("/movies/edit/:id",{templateUrl:"/Views/edit.html",controller:"MoviesEditController"}).when("/movies/delete/:id",{templateUrl:"/Views/delete.html",controller:"MoviesDeleteController"}),b.html5Mode(!0)}a.$inject=["$routeProvider","$locationProvider"],angular.module("moviesApp",["ngRoute","moviesServices"]).config(a)}(),function(){"use strict";function a(a,b){a.movies=b.query()}function b(a,b,c){a.movie=new c,a.add=function(){a.movie.$save(function(){b.path("/")},function(b){f(a,b)})}}function c(a,b,c,d){a.movie=d.get({id:b.id}),a.edit=function(){a.movie.$save(function(){c.path("/")},function(b){f(a,b)})}}function d(a,b,c,d){a.movie=d.get({id:b.id}),a.remove=function(){a.movie.$remove({id:a.movie.Id},function(){c.path("/")})}}function e(a){a.open=function(b){b.preventDefault(),b.stopPropagation(),a.opened=!0}}function f(a,b){if(a.validationErrors=[],b.data&&angular.isObject(b.data))for(var c in b.data)a.validationErrors.push(b.data[c][0]);else a.validationErrors.push("Could not add movie.")}angular.module("moviesApp").controller("MoviesListController",a).controller("MoviesAddController",b).controller("MoviesEditController",c).controller("MoviesDeleteController",d).controller("DatePickerController",e),a.$inject=["$scope","Movie"],b.$inject=["$scope","$location","Movie"],c.$inject=["$scope","$routeParams","$location","Movie"],d.$inject=["$scope","$routeParams","$location","Movie"],e.$inject=["$scope"]}(),function(){"use strict";function a(a){return a("/api/movies/:id")}angular.module("moviesServices",["ngResource"]).factory("Movie",a),a.$inject=["$resource"]}();