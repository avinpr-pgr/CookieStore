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

        $scope.submitOrder = function () {
            talkyTalkyService.submitOrder();
            $scope.allProducts = talkyTalkyService.getOrder();
        }
    }
])