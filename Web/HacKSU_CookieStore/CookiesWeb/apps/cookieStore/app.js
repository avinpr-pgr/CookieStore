var cookieStoreApp = angular.module('cookieStoreApp', ['ui.router', 'ngResource']);
cookieStoreApp.config([
    '$stateProvider',
    '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/store');

        $stateProvider.state('store', {
            url: '/store',
            templateUrl: '/apps/cookieStore/templates/store.html',
            controller: 'cookieStoreController'
        });

        $stateProvider.state('products', {
            url: '/store/:product',
            templateUrl: '/apps/cookieStore/templates/products.html',
            controller: 'cookieStoreController'
        });

        $stateProvider.state('order', {
            url: '/store/order',
            templateUrl: '/apps/cookieStore/templates/order.html',
            controller: 'cookieStoreController'
        })
    }
]);
cookieStoreApp.controller('cookieStoreController', [
    '$scope',
    '$resource',
    function ($scope, $resource) {
    $scope.buttonNames = ["Home", "Cookies", "Milk", "Order"];

    allProducts = $resource('http://cookieapidev1.cloudapp.net/ksuapi/api/products/allproducts');
    $scope.products = allProducts.query();
}]);