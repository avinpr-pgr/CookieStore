function Product(id, category, name, description, price) {
    this.id = id;
    this.category = category;
    this.name = name;
    this.description = description;
    this.price = price;
}

function OrderInfo(id, quantity) {
    this.id = id;
    this.quantity = quantity;
}

var chocoChip = new Product(0, 0, "Chocolate Chip", "Warm, gooey Chocolate Chips!", 1);
var peanutButter = new Product(1, 0, "Peanut Butter", "Caution--May Contain Peanut Products", 1.25);
var sugar = new Product(2, 0, "Sugar", "WHEEE!!", 1.5);
var oatRaisin = new Product(3, 0, "Oatmeal Raisin", "It's Oatmeal. It's Raisin. It's both!", 2.25);
var whole = new Product(4, 1, "Whole", "Pours like a milkshake", 0.5);
var twoPer = new Product(5, 1, "2%", "Just Like Mom used to buy", 0.75);
var skim = new Product(6, 1, "Skim", "To help you watch your waistline", 0.55);
var soy = new Product(7, 1, "Soy", "Well...this is really soy juice, but who cares?", 1.3);

var productsArray = [chocoChip, peanutButter, sugar, oatRaisin, whole, twoPer, skim, soy];

function makeItemArray(products, category) {
    var itemArray = [];
    products.forEach(function (currentProduct) {
        var itemCategory = currentProduct.category;
        if (itemCategory == category) {
            itemArray.push(currentProduct);
        }
    });

    return itemArray;
}

var cookieItems = makeItemArray(productsArray, 0);
var milkItems = makeItemArray(productsArray, 1);

var cookieStoreApp = angular.module('cookieStoreApp', ['ui.router', 'ngResource']);
cookieStoreApp.config([
    '$stateProvider',
    '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/store');

        $stateProvider.state('store', {
            url: '/store',
            templateUrl: '/apps/cookieStore/templates/products.html',
            controller: 'allProductsController'
        });

        $stateProvider.state('cookies', {
            url: '/store/cookies',
            templateUrl: '/apps/cookieStore/templates/cookies.html',
            controller: 'cookieController'
        });

        $stateProvider.state('milk', {
            url: '/store/milk',
            templateUrl: '/apps/cookieStore/templates/milk.html',
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
    'shoppingCartService',
    function ($scope, shoppingCartService) {
        $scope.allProducts = productsArray;
    }
]);

cookieStoreApp.controller('cookieController', [
    '$scope',
    'shoppingCartService',
    function ($scope) {
        $scope.allProducts = cookieItems;
    }
]);

cookieStoreApp.controller('milkController', [
    '$scope',
    'shoppingCartService',
    function ($scope) {
        $scope.allProducts = milkItems;
    }
]);

cookieStoreApp.controller('orderController', [
    '$scope',
    'shoppingCartService',
    function ($scope, shoppingCartService) {
        $scope.shoppingCart = shoppingCartService.getCart;
    }
])

cookieStoreApp.service('shoppingCartService', function () {
    this.shoppingCart = [];

    this.addItem = function (item) {
        this.shoppingCart.push(item);
    }

    this.getCart = function () {
        return this.shoppingCart;
    }

    this.clear = function () {
        this.shoppingCart = [];
    }
})