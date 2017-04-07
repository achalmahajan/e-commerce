

// Show_ Page Function -------------



////////////////////////////ANGULAR JS///////////////////////////////



//var app = angular.module('test', []);
//app.controller('myController', ['$scope', '$http', function($scope, $http) {
//  $scope.items = []
//  $scope.clickButton = function() {
//    $http.get('http://192.168.0.19:8080/items').success(function(data) {
//        $scope.items = data;
//      });
//  }
//
//}]);

var app = angular.module('test', []);
app.controller('myController', ['$scope', '$http', function($scope, $http) {
var url = "http://192.168.0.19:8080/items";
$scope.items = []
$http({
method: 'GET',
    headers: {
            "Access-Control-Allow-Origin": "http://localhost:8080"
        },


    url: url
}).
success(function(status) {
    console.log(status.result);
    $scope.items = status.result;
})
.error(function(data, status) {
                alert(status);
            });
}]);

