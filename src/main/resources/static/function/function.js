

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

var myapp = angular.module('dealModule', []);


    myapp.controller('SearchController', ['$scope', '$http', function($scope, $http) {
    var url = "/items";
    $scope.items = new Array();
    $http({
    method: 'GET',
         url: url
    }).
    success(function(status) {
        $scope.items = status;
    })
    .error(function(data, status) {
                    alert(status);
                });
    }]);
