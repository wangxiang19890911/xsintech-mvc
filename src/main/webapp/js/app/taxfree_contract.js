var records = [
			{"Name":"Alfreds Futterkiste","City":"Berlin","Country":"Germany"},
			{"Name":"Ana Trujillo Emparedados y helados","City":"México D.F.","Country":"Mexico"},
			{"Name":"Antonio Moreno Taquería","City":"México D.F.","Country":"Mexico"},
			{"Name":"Around the Horn","City":"London","Country":"UK"},
			{"Name":"B's Beverages","City":"London","Country":"UK"},
			{"Name":"Berglunds snabbköp","City":"Luleå","Country":"Sweden"},
			{"Name":"Blauer See Delikatessen","City":"Mannheim","Country":"Germany"},
			{"Name":"Blondel père et fils","City":"Strasbourg","Country":"France"},
			{"Name":"Bólido Comidas preparadas","City":"Madrid","Country":"Spain"},
			{"Name":"Bon app'","City":"Marseille","Country":"France"},
			{"Name":"Bottom-Dollar Marketse","City":"Tsawassen","Country":"Canada"},
			{"Name":"Cactus Comidas para llevar","City":"Buenos Aires","Country":"Argentina"},
			{"Name":"Centro comercial Moctezuma","City":"México D.F.","Country":"Mexico"},
			{"Name":"Chop-suey Chinese","City":"Bern","Country":"Switzerland"},
			{"Name":"Comércio Mineiro","City":"São Paulo","Country":"Brazil"}
			];

var app = angular.module('taxfree', []);
app.controller('customersCtrl', function($scope, $http) {
//    $http.get("/try/angularjs/data/Customers_JSON.php").then(function (result) {
        $scope.datas = records;
//    });
});


$(document).ready(function() {
	$('.labour').click(function() {
		location.href = contextPath + 'secure/labour';
	});
});