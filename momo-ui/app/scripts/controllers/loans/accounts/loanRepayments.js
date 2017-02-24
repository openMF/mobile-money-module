'use strict';

/**
 * Created by daniel on 1/14/17.
 */
angular.module('momoUiApp')
  .controller('loanRepaymentCtrl', ['$scope', '$rootScope', 'MifosService',
    function ($scope, $rootScope, MifosService) {

      $(window).bind('beforeunload', function(){
        $rootScope.displaying = true;
        $state.transitionTo('login');
      });

      $scope.loading = true;

      MifosService.getClientAccounts($rootScope.clientId)
        .then(function(response){
          $scope.loanAccounts = response.data.loanAccounts;
          $rootScope.savingsAccounts = response.data.savingsAccounts;
          $scope.loading = false;
        }, function(error){

        });
    }]);
