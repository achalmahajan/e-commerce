

// Show_ Page Function -------------

// Login -------------
var userInfo;
function login(Email, Password){
	alert(Email+" "+Password);
	$.ajax({
	  type: "POST",
	  url: "database/accntLogin.php",
	  data: {
	  email: Email,
	  password: Password}
	})
	  .done(function( msg ) {
	  //if credentials match
		//alert("here");
		//console.log(msg);
		userInfo = msg;
		$('#exampleInputPassword1').val('');

		//console.log(userInfo);
		if((userInfo == null) || (!(typeof userInfo==='object'))){
			$('#titleWSignUPInfo').text("Login Un-SuccessFul");
			$('#tWSignUPInfo').text(msg);
			$('#mWSignUPInfo').modal('show');
		}else{
		//console.log(userInfo);
		var $scope = angular.element($("#accntMenu")).scope();
	   		$scope.$apply(function(){
				$scope.userinfo = new Array();
				$scope.userinfo = userInfo;
		});
		accnt_sumary();
	  }});
}


$(function(){
    var $itemList = $('#itemList');
    $.ajax({
        type:'GET',
        url: '/items',
        success: function(items){
            $.each(items, function(i, item){
                $itemList.append('<li>title: '+ item.title +'</li>');
        });
        }
    });
});


////////////////////////////ANGULAR JS///////////////////////////////



var app = angular.module('test', []);
app.controller('myController', ['$scope', '$http', function($scope, $http) {
  $scope.clickButton() = function() {
    $http.get('http://192.168.0.19:8080/items').success(function(data) {
        $scope.items = data;
      });
  }

}]);





var myapp = angular.module('dealModule', []);


myapp.controller('SearchController', function($scope, $http) {
    $http.get('http://localhost:8080/items').success(function(data){
    $scope.itemsResult = data;
    });
});

//myapp.controller('AccntSearchController', function($scope) {
//    $scope.searchCategories = new Array();
//});
//
//
//var searchCategories;//done checking
//function accnt_search_categories(moveToPage){
//	$.ajax({
//	  type: "GET",
//	  url: "http://localhost:8080/items",
//	  data: {}
//	})
//	  .done(function( msg ) {
//	    searchCategories = msg;
//		if (moveToPage !=-1 ){
//			var $scope = angular.element($("#searchCategory")).scope();
//	   		$scope.$apply(function(){
//				$scope.searchCategories = new Array();
//				$scope.searchCategories = searchCategories;
//    		});
//			show_Page(moveToPage);
//		}else{
//			var $scope = angular.element($("#newItemSale")).scope();
//	   		$scope.$apply(function(){
//				$scope.searchCategories = new Array();
//				$scope.searchCategories = searchCategories;
//    		});
//		}
//		alert(searchCategories[0]['Category'])
//	  });
//}