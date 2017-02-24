'use strict';
/**
 * Created by daniel on 1/14/17.
 */
angular.module('momoUiApp')
  .controller('userLoginCtrl', ['$scope', '$state', '$rootScope', '$location', '$cookieStore', 'AuthService',
    function ($scope, $state, $rootScope, $location, $cookieStore, AuthService) {

    $scope.loading = false;
    $scope.errorCreds = false;

    (function initController() {
      AuthService.clearCredentials();
      $scope.username = "";
      $scope.password = "";
    })();

    // function to log user in
    $scope.submitLoginForm = function() {
        $rootScope.username = $scope.username;
        $rootScope.password = $scope.password;

        $scope.loading = true;

        AuthService.login($rootScope.username, $rootScope.password)
          .then(function(response) {
            var usr = {
              username: $rootScope.username,
              password: $rootScope.password
            };
            $cookieStore.put("user", usr);
            $rootScope.basicKey = response.data.base64EncodedAuthenticationKey;

            AuthService.setCredentials($scope.username, $scope.password, $rootScope.basicKey);
            $rootScope.displayname = $scope.username;
            $scope.loginView();
          }, function(error){
            $scope.loading = false;
            // Reset login page after wrong credentials
            $scope.username = "";
            $scope.password = "";
            $scope.errorMsg = "Sorry wrong credentials";
            $scope.errorCreds = true;
          })
    };

    $scope.loginView = function(){
      $state.transitionTo('clients');
    };

  }]);
