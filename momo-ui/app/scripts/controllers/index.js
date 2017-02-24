'use strict';
/**
 * Created by daniel on 1/14/17.
 */

angular.module('momoUiApp')
  .run(function($rootScope, $location){
    $rootScope.location = $location;
  });
