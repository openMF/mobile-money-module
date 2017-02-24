'use strict';

/**
 * @ngdoc function
 * @name momoUiApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the momoUiApp
 */
angular.module('momoUiApp')
  .controller('mainCtrl', ['$rootScope', '$scope', '$stateParams', 'MifosService',
    function ($rootScope, $scope, $stateParams, MifosService) {

    $rootScope.clientId = $stateParams.id;

    MifosService.getClientDetails($rootScope.clientId)
      .then(function (response) {
        $scope.name = response.data.displayName;
        $scope.account = response.data.accountNo;
        $scope.staff = response.data.staffName;

        console.log($scope.name);
        console.log($scope.account);
        console.log($scope.staff);
      })

  }]);
