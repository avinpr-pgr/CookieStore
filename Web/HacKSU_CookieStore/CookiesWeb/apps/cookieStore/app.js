function Product(productId, category, name, description, price) {
    this.productId = productId;
    this.category = category;
    this.name = name;
    this.description = description;
    this.price = price;
}

function OrderInfo(productId, quantity) {
    this.productId = productId;
    this.quantity = quantity;
}

var cookieStoreApp = angular.module('cookieStoreApp', ['ui.router', 'ngResource']);
cookieStoreApp.config([
    '$stateProvider',
    '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/Home');

        $stateProvider.state('Home', {
            url: '/Home',
            templateUrl: '/apps/cookieStore/templates/products.html',
            controller: 'allProductsController'
        });

        $stateProvider.state('cookies', {
            url: '/store/cookies',
            templateUrl: '/apps/cookieStore/templates/products.html',
            controller: 'cookieController'
        });

        $stateProvider.state('milk', {
            url: '/store/milk',
            templateUrl: '/apps/cookieStore/templates/products.html',
            controller: 'milkController'
        })

        $stateProvider.state('order', {
            url: '/store/order',
            templateUrl: '/apps/cookieStore/templates/order.html',
            controller: 'orderController'
        })
    }
]);

cookieStoreApp.controller('buttonsController', [
    '$scope',
    function ($scope) {
        $scope.buttonNames = ["Home", "Cookies", "Milk", "Order"];
    }
])

cookieStoreApp.controller('allProductsController', [
    '$scope',
    'talkyTalkyService',
    function ($scope, talkyTalkyService) {
        $scope.btnDescription = "Add Item To Cart!";
        $scope.allProducts = talkyTalkyService.getAllProducts();

        $scope.buttonAction = function ($index, qty) {
            talkyTalkyService.updateOrder({
                productid: $scope.allProducts[$index].ProductId,
                quantity: qty
            })
        }
    }
]);

cookieStoreApp.controller('cookieController', [
    '$scope',
    'talkyTalkyService',
    function ($scope, talkyTalkyService) {
        $scope.btnDescription = "Add Cookie To Cart!";
        $scope.allProducts = talkyTalkyService.getAllCookies();

        $scope.buttonAction = function ($index, qty) {
            talkyTalkyService.updateOrder({
                productid: $scope.allProducts[$index].ProductId,
                quantity: qty
            })
        }
    }
]);

cookieStoreApp.controller('milkController', [
    '$scope',
    'talkyTalkyService',
    function ($scope, talkyTalkyService) {
        $scope.btnDescription = "Add Milk To Cart!";
        $scope.allProducts = talkyTalkyService.getAllMilk();
        $scope.buttonAction = function ($index, qty) {
            talkyTalkyService.updateOrder({
                productid: $scope.allProducts[$index].ProductId,
                quantity: qty
            })
        }
    }
]);

cookieStoreApp.controller('orderController', [
    '$scope',
    'talkyTalkyService',
    function ($scope, talkyTalkyService) {
        $scope.btnDescription = "Remove Item From Cart!";
        $scope.allProducts = talkyTalkyService.getOrder();
        $scope.buttonAction = function ($index, qty) {
            talkyTalkyService.removeItem($scope.allProducts[$index].ProductId)
            $scope.allProducts.splice($index, 1);
        }
    }
])

cookieStoreApp.service('talkyTalkyService', function ($resource, $http) {
    return {
        allProductsArray: [],
        allCookiesArray: [],
        allMilkArray: [],
        order: [],

        getAllProducts: function () {
            if (this.allProductsArray.length === 0) {
                this.allProductsArray = $resource('http://cookieapidev1.cloudapp.net/ksuapi/api/products/AllProducts').query();
            }
            return this.allProductsArray;
        },
        getAllCookies: function () {
            if (this.allCookiesArray.length === 0) {
                this.allCookiesArray = $resource('http://cookieapidev1.cloudapp.net/ksuapi/api/products/Cookies').query();
            }
            return this.allCookiesArray;
        },
        getAllMilk: function () {
            if (this.allMilkArray.length === 0) {
                this.allMilkArray = $resource('http://cookieapidev1.cloudapp.net/ksuapi/api/products/Milk').query();
            }
            return this.allMilkArray;
        },
        getOrder: function () {
            this.order = []
            stufftocheck = $resource('http://cookieapidev1.cloudapp.net/ksuapi/api/orders/order').query();
            // array.prototype.merge() or array.prototype.map on MDN will help you here

            return this.order;
        },
        updateOrder: function (orderInfo) {
            $http({
                url: 'http://cookieapidev1.cloudapp.net/ksuapi/api/orders/UpdateOrder',
                method: 'PUT',
                data: orderInfo
            });
        },
        removeItem: function (productId) {
            $http({
                url: 'http://cookieapidev1.cloudapp.net/ksuapi/api/orders/RemoveItem/' + productId,
                method: 'DELETE'
            });
        },
        submitOrder: function () {
            var resource = $resource('http://cookiesapidev1.cloudapp.net/ksuapi/api/orders/submit');
            resource.save();
        }
    }
})