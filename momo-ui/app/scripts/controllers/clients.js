'use strict';

/**
 * Created by daniel on 1/14/17.
 */
angular.module('momoUiApp')
  .controller('clientCtrl', ['$scope', 'MifosService',
    function ($scope, MifosService) {

    $(window).bind('beforeunload', function(){
      $rootScope.displaying = true;
      $state.transitionTo('login');
    });

    $scope.loading = true;

    MifosService.getAllClients()
      .then(function(response){
          $scope.clients = response.data.pageItems;
          $scope.loading = false;
      })

  }]);
