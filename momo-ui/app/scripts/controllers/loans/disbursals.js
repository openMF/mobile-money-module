'use strict';
/**
 * Created by daniel on 1/14/17.
 */

angular.module('momoUiApp')
  .controller('disbursalsCtrl', ['$scope', '$stateParams', '$rootScope',
    function ($scope, $stateParams, $rootScope) {

      console.log($rootScope.clientId);
      console.log($stateParams.accId);

      $scope.accId = $stateParams.accId;

      $scope.submitDisbursalsForm = function() {
        console.log("submitted disbursal");
      }

    }]);
