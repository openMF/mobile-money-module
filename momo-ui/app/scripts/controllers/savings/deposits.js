'use strict';

/**
 * Created by daniel on 1/14/17.
 */

angular.module('momoUiApp')
  .controller('depositsCtrl', ['$scope', '$stateParams', '$rootScope',
    function ($scope, $stateParams, $rootScope) {

      console.log($rootScope.clientId);

    }]);
