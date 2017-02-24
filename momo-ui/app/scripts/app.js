'use strict';

/**
 * @ngdoc overview
 * @name momoUiApp
 * @description
 * # momoUiApp
 *
 * Main module of the application.
 */
angular
  .module('momoUiApp', [
    'ngAnimate','ngCookies','ngResource','ngRoute','ngSanitize','ngTouch', 'ui.router',
    'angularUtils.directives.dirPagination'])
  .config(function ($stateProvider, $urlRouterProvider, $httpProvider) {

    // Set headers and enable CORS
    $httpProvider.defaults.headers.common['Fineract-Platform-TenantId'] = 'default';
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
    $httpProvider.defaults.headers.common['Content-Type'] = 'application/json; charset=utf-8';
    $httpProvider.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

    $stateProvider
      .state('login', {
        url: '/login',
        templateUrl: 'views/login.html',
        controller: 'userLoginCtrl'
      })

      .state('clients', {
        url: '/clients',
        templateUrl: 'views/clients.html',
        controller: 'clientCtrl'
      })

      .state('main', {
        url: '/main/:id',
        templateUrl: 'views/main.html',
        controller: 'mainCtrl'
      })

      .state('main.configurations', {
        url: '/configurations',
        templateUrl: 'views/configurations.html',
        controller: 'configCtrl'
      })

      .state('main.transactions', {
        url: '/transactions',
        templateUrl: 'views/transactions.html',
        controller: 'transCtrl'
      })

      .state('main.loans', {
        url: '/loans',
        templateUrl: 'views/loans/loans.html',
        controller: 'loanCtrl'
      })

      .state('main.disbursal_accounts', {
        url: '/loans/disburse_accounts',
        templateUrl: 'views/loans/accounts/loanDisbursals.html',
        controller: 'loanDisbursalCtrl'
      })

      .state('main.repayment_accounts', {
        url: '/loans/repayment_accounts',
        templateUrl: 'views/loans/accounts/loanRepayments.html',
        controller: 'loanRepaymentCtrl'
      })

      .state('main.disbursals', {
        url: '/loans/disbursals/:id',
        templateUrl: 'views/loans/disbursals.html',
        controller: 'disbursalsCtrl',
        params: {
          accId: null
        }
      })

      .state('main.repayments', {
        url: '/loans/repayments',
        templateUrl: 'views/loans/repayments.html',
        controller: 'repaymentCtrl',
        params: {
          accId: null
        }
      })

      .state('main.application', {
        url: '/loans/application',
        templateUrl: 'views/loans/application.html',
        controller: 'applicationCtrl'
      })

      .state('main.savings', {
        url: '/savings',
        templateUrl: 'views/savings/savings.html',
        controller: 'savingsCtrl'
      })

      .state('main.deposit_accounts', {
        url: '/savings/deposit_accounts',
        templateUrl: 'views/savings/accounts/depositAccounts.html',
        controller: 'depositAccCtrl'
      })

      .state('main.withdrawal_accounts', {
        url: '/savings/withdrawal_accounts',
        templateUrl: 'views/savings/accounts/withdrawalAccounts.html',
        controller: 'withdrawAccCtrl'
      })

      .state('main.deposits', {
        url: '/savings/deposits',
        templateUrl: 'views/savings/deposits.html',
        controller: 'depositsCtrl',
        params: {
          accId: null
        }
      })

      .state('main.withdrawals', {
        url: '/savings/withdrawals',
        templateUrl: 'views/savings/withdrawals.html',
        controller: 'withdrawalsCtrl',
        params: {
          accId: null
        }
      });

    $urlRouterProvider.otherwise('/login');
  })
  .run(function($rootScope, $cookieStore, $location, $http){
    $rootScope.location = $location;
    $rootScope.globals = $cookieStore.get('globals') || {};
    console.log("Username-app.js : " + $rootScope.displayname);
    if($rootScope.globals.currentUser){
      $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.basicKey;
    }
    $rootScope.$on('$stateChangeStart', function(event, next, current){
      var restrictedPage = $.inArray($location.path, ['/main', '/clients', '/savings', '/loans',
                                                      '/savings/deposits', '/savings/withdrawals',
                                                      '/loans/repayments', '/loans/disbursals',
                                                      '/main/loans', '/main/savings', '/main/configurations']) === -1;
      var loggedIn = $rootScope.globals.currentUser;
      //var loggedIn = $cookieStore.get('user');
      if(restrictedPage && !loggedIn){
        $rootScope.displaying = true;
        $rootScope.username = "";
        $rootScope.password = "";
        setTimeout(function(){
          $location.path('/login');
        }, 10);
      }
    });
  });
