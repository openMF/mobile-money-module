'use strict';
/* global $ */

angular.module('mobileMoneyApp')
  .controller('configCtrl', ['$rootScope', '$scope', '$window', 'mobileMoneyFactory',
    function ($rootScope, $scope, $window, mobileMoneyFactory) {
    // variables
    $scope.hide = false;
    $scope.withHide = false;

    $rootScope.savingsParams = [];
    $rootScope.withdrawalParams = [];
    $rootScope.urls = [];
    $rootScope.params = [];

    // function to add a parameter
    $scope.addSavingsParam = function(){
      $scope.hide = true;
      $rootScope.savingsParams.push({savingsParamName: $scope.savingsParamName, savingsParamValue: $scope.savingsParamValue});
      $scope.savingsParamName = '';
      $scope.savingsParamValue = '';
    }

    $scope.delSavingsParam = function(index){
      $rootScope.savingsParams.splice(index, 1);
    }

    $scope.addWithParams = function(){
      $scope.withHide = true;
      $rootScope.withdrawalParams.push({withParamName: $scope.withParamName, withParamValue: $scope.withParamValue});
      $scope.withParamName = '';
      $scope.withParamValue = '';
    }

    $scope.delWithParams = function(index){
      $rootScope.withdrawalParams.splice(index, 1);
    }

    $scope.updateSettings = function(){
      $rootScope.params.push({savingsParams: $rootScope.savingsParams, withdrawParams: $rootScope.withdrawalParams});
      $rootScope.urls.push({savingsUrl: $scope.savings_url, withdrawUrl: $scope.withdraw_url});

      $rootScope.params = JSON.stringify($rootScope.params);
      $rootScope.urls = JSON.stringify($rootScope.urls);

      // open modal
      $('#updateModal').modal({
			backdrop: 'static',
			keyboard: false
		});
	  $('#updateModal').modal('show');

      mobileMoneyFactory.settings($scope.region, $scope.country, $scope.display_name, $scope.org_phone, $scope.orgAcc_id,$rootScope.urls, $rootScope.params)
        .then(function(response){
            // close modal
            $('#updateModal').modal('hide');
        }, function(error){
            $('#updateModal').modal('hide');
            console.log("Error with configurations");
        });
    }

     $scope.goBack = function(){
    	window.history.back(); 
     };
     $scope.deny = function(){
        $window.location.reload();
     };
  }]);
