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