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