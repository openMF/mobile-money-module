/**
 * Created by daniel on 1/14/17.
 */
angular.module('momoUiApp')
.factory('MifosService', ['$http', '$rootScope', '$cookieStore',
  function($http, $rootScope, $cookieStore){
    var MifosService = {};
    $rootScope.BASE_URL = "https://demo.openmf.org/fineract-provider/api/v1/";

    MifosService.getAllClients = function(){
      return $http.get($rootScope.BASE_URL + "clients");
    };

    MifosService.getClientAccounts = function(clientId){
      return $http.get($rootScope.BASE_URL + "clients/" + clientId + "/accounts");
    };

    MifosService.getClientDetails = function(clientId){
      return $http.get($rootScope.BASE_URL + "clients/" + clientId);
    };

    MifosService.submitLoanApplication = function(clientId, amt, disbursementDate, todayDate){
      return $http({
        method: "POST",
        url: $rootScope.BASE_URL + "loans",
        data: {
          "dateFormat": "dd MMMM yyyy",
          "clientId": "1",
          "productId": 59,
          "disbursementData": [],
          "principal": amt,
          "loanTermFrequency": 30,
          "loanTermFrequencyType": 0,
          "numberOfRepayments": 1,
          "repaymentEvery": 30,
          "repaymentFrequencyType": 0,
          "interestRatePerPeriod": 30,
          "amortizationType": 1,
          "interestType": 0,
          "interestCalculationPeriodType": 0,
          "allowPartialPeriodInterestCalcualtion": false,
          "transactionProcessingStrategyId": 1,
          "locale": "en",
          "loanType": "individual",
          "expectedDisbursementDate": todayDate,
          "submittedOnDate": todayDate
        }
      });
    };

    MifosService.requestLoanExtension = function(accountId, todayDate, terms, comments){
      return $http({
        method: "POST",
        url: $rootScope.BASE_URL + "rescheduleloans",
        data: {
          "loanId": accountId,
          "graceOnPrincipal": 2,
          "graceOnInterest": 3,
          "extraTerms": terms,
          "rescheduleFromDate": todayDate,
          "dateFormat": "MMMM dd yyyy",
          "locale": "en",
          "recalculateInterest": true,
          "submittedOnDate": todayDate,
          "newInterestRate" : 28,
          "rescheduleReasonId": 1,
          "rescheduleReasonComment": comments
        }
      });
    };

    MifosService.disburse = function(accountId, disburseDate, note, amount) {
      var url = $rootScope.BASE_URL + "loans/" + accountId + "?command=disburse";
      var data = {
        "dateFormat": "dd MMMM yyyy",
        "locale": "en",
        "transactionAmount": amount,
        "actualDisbursementDate": disburseDate,
        "paymentTypeId": "12",
        "note": note
      };
      return $http.post(url, data);
    };

    return MifosService;

  }]);
