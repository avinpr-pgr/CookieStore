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