'use strict';

angular.module('momoUiApp')
  .controller('loanCtrl', ['$scope', '$stateParams', '$rootScope',
    function ($scope, $stateParams, $rootScope) {
      $rootScope.clientId = $stateParams.id;
      console.log($rootScope.clientId);

    }]);
