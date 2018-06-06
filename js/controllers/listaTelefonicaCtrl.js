angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function($scope, $filter, $http){
	$scope.app = "Lista Telefonica";
	$scope.contatos = [
		{nome: $filter('uppercase')("Fábio"), telefone: "8999-2222", data: new Date(), cor: "yellow", operadora: {nome: "Vivo", codigo: 15, categoria: "Celular"}},
		{nome: "Sthefany", telefone: "7999-2222", data: new Date(), cor: "red", operadora: {nome: "Oi", codigo: 14, categoria: "Celular"}},
		{nome: "Mary Jane Elita", telefone: "9999-2222", data: new Date(), cor: "blue", operadora: {nome: "Oi", codigo: 14, categoria: "Celular"}}
	];

	var carregarContatos = function(){
		console.log("carregar contatos");
		$http({method: 'GET', url: 'http://localhost:8080/rest-angularjs/rest/contatos/array'}).then(function (response){
			 //console.log(response.data);
			 $scope.contatos = response.data;
		},function (error){
			console.log(error);
		});
	}

	var carregarOperadoras = function(){
		$http({
			method: 'GET', 
			url: 'http://localhost:8080/rest-angularjs/rest/operadoras'
		}).then(function (response){
			 $scope.operadoras = response.data;
		},function (error){
			console.log(error);
		});
	}

	$scope.salvarContatos = function(contato){
		console.log("salvar contatos");
		contato.data = new Date();
		$http({
			method: 'POST', 
			url: 'http://localhost:8080/rest-angularjs/rest/contatos/post', 
			data: contato
		}).then(function (response){
			console.log("resposta");
			carregarContatos();
			delete $scope.contato;
			$scope.contatoForm.$setPristine();
		},function (error){
			console.log(error);
		});

	}

	$scope.operadoras = [
		{nome: "Oi", codigo: 14, categoria: "Celular", preco: 2},
		{nome: "Vivo", codigo: 15, categoria: "Celular", preco: 3},
		{nome: "Tim", codigo: 41, categoria: "Celular", preco: 1},
		{nome: "Vivi Fixo", codigo: 25, categoria: "Fixo", preco: 3},
		{nome: "Embratel", codigo: 21, categoria: "Fixo", preco: 1}
	];
	$scope.apagarContatos = function(contatos){
		$scope.contatos = contatos.filter(function(contato){
			if(!contato.selecionado == true)
				return contato;
		});
	}
	$scope.isContatotSelecionado = function(contatos){
		return contatos.some(function(contato){
			return contato.selecionado;
		});
	}
	$scope.ordenarPor = function(campo){
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoOrdenacao = !$scope.direcaoOrdenacao;
	}
	carregarContatos();
	carregarOperadoras();
});