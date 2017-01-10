'use strict';
/* global $ */
/* global Materialize */

angular.module('mobileMoneyApp')
  .controller('loanDisbursalCtrl', ['$rootScope', '$scope', '$http', '$timeout', '$stateParams', 'authFactory', 'dataFactory', 
	function ($rootScope, $scope, $http, $timeout, $stateParams, authFactory, dataFactory) {
		
    // show spinner
    $scope.loading = true;
	
    // client's details
    $rootScope.clientId = $stateParams.id;
	
	// authenticate user
	authFactory.getAuthKey($rootScope.username, $rootScope.password)
    	.then(function (response) {
			var basicKey = response.data.base64EncodedAuthenticationKey;
			authFactory.setBasicAuthKey(basicKey);
	
			// get client data
			dataFactory.getClientDetails($scope.clientId)
				.then(function(response){
					console.info("Getting client data.");
		          	$scope.data = response.data;
		          	$scope.clientName = $scope.data.displayName;
		          	$rootScope.accountNo = $scope.data.accountNo;
					$rootScope.accountId = $scope.data.id;
		          	$scope.staffName = $scope.data.staffName;
		          	$scope.activDate = new Date($scope.data.activationDate);
					$scope.activationDate = $scope.activDate.toDateString();

					// now get the date of today
					$scope.newDate = new Date();
					$scope.newDate1 = $scope.newDate.toDateString();
					$rootScope.todayDate = $scope.newDate1.substring(4);

		          	$scope.officeName = $scope.data.officeName;
		          	$scope.userName = $scope.data.timeline.activatedByUsername;
					
					// get client account Info
					dataFactory.getClientAccounts($scope.clientId)
						.then(function(response){
							console.info("Get client account details.");
							$scope.loanAccounts = response.data.loanAccounts;
							$rootScope.savingsAccounts = response.data.savingsAccounts;
							$scope.loading = false;
						}, function(error){});
				}, function(error){});
    	}, function (error){});
}])

.controller('disburseToSavingsCtrl', ['$rootScope', '$scope', '$http', '$timeout', '$stateParams', 'loanFactory',
	function($rootScope, $scope, $http, $timeout, $stateParams, loanFactory){
		
		$rootScope.accountId = $stateParams.accId;
		
		$scope.disburseToSavings = function(){
	        $('#loanDisbursalToSavings').modal({
	          backgrop: "static",
	          keyboard: false
	        });
	        
	    $('#loanDisbursalToSavings').modal('show');
			
	    loanFactory.disburseToSavingsProcess($rootScope.accountId, $rootScope.todayDate)
			.then(function(response){
				//	Materialize.toast('Loan successfully disbursed to Savings account', 6000, 'rounded');
                $('#loanDisbursalToSavings').modal('hide');
				}, function(error){
					//Materialize.toast('Failure to disburse loans.No savings account has been configured for this', 6000, 'rounded');
                	$('#loanDisbursalToSavings').modal('hide');
			});
		};
}])

.controller('disburseToMoMoCtrl', ['$rootScope', '$scope', '$http', '$timeout', '$stateParams', 'mobileMoneyFactory', 'loanFactory',
	function($rootScope, $scope, $http, $timeout, $stateParams, mobileMoneyFactory, loanFactory){
  	
      $scope.submitted = true;

      // function to submit the form after all form validation
      $scope.submitDisbursalForm = function(){
		
         // Check to make sure the form is valid
         if($scope.disburseForm.$valid){
           $scope.submitted = false;
           $scope.loanRequest($rootScope.clientId);
         }
      };
	  
	  $scope.loanRequest = function(clientId){
	  		// open modal when user submits valid form
		  	$('#loanDisbursalToMoMo').modal({
		  		backdrop: 'static',
				keyboard: false
		  	});
		  	
		  	$('#loanDisbursalToMoMo').modal('show');
			
			// make request to mobile money engine
			// 1 - withdrawal
			// 2 - savings
			// 3 - loan transactions
			mobileMoneyFactory.transactions($scope.phoneNumber, $scope.amount, clientId, $scope.accountId, 1)
				.then(function(response){
					// since transaction is successful, 
					// update the platform of these changes
					loanFactory.disburseToMoMo($rootScope.accountId, $scope.amount, $rootScope.todayDate)
						.then(function(response){
		         //       	Materialize.toast('Transaction success. Loan disbursed to Mobile money account', 6000, 'rounded');
							
		                	$('#loanDisbursalToMoMo').modal('hide');
						}, function(){
		              //  	Materialize.toast('Transaction failure. Loan not in disbursal state due to unapproval', 6000, 'rounded');
		                	$('#loanDisbursalToMoMo').modal('hide');
						});
				});
	  };
}]);