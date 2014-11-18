var cookieStoreApp = angular.module('cookieStoreApp', ['ui.router', 'ngResource']);
cookieStoreApp.config([
    '$stateProvider',
    '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/Home');

        $stateProvider.state('Home', {
            url: '/Home',
            templateUrl: '/ksusite/apps/cookieStore/templates/products.html',
            controller: 'allProductsController'
        });

        $stateProvider.state('cookies', {
            url: '/store/cookies',
            templateUrl: '/ksusite/apps/cookieStore/templates/products.html',
            controller: 'cookieController'
        });

        $stateProvider.state('milk', {
            url: '/store/milk',
            templateUrl: '/ksusite/apps/cookieStore/templates/products.html',
            controller: 'milkController'
        })

        $stateProvider.state('order', {
            url: '/store/order',
            templateUrl: '/ksusite/apps/cookieStore/templates/order.html',
            controller: 'orderController'
        })
    }
]);