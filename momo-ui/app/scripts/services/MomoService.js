/**
 * Created by daniel on 1/14/17.
 */
angular.module('momoUiApp')
  .factory('MomoService', ['$http', '$rootScope',
    function($http, $rootScope){
      var MomoService = {};
      $rootScope.BASE_URL = "https://demo.openmf.org/fineract-provider/api/v1/";

      MomoService.getAllTransactions = function(){
        return $http.get();
      };

      MomoService.getTransaction = function(id) {
        return $http.get();
      };

      return MomoService;

    }]);
