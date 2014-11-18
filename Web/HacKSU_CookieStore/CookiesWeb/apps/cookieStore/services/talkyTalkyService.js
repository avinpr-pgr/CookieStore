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
            this.order = $resource('http://cookieapidev1.cloudapp.net/ksuapi/api/orders/DetailedOrder').query();
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
            var promise = $http({
                url: 'http://cookieapidev1.cloudapp.net/ksuapi/api/orders/submit',
                method: 'POST'
            })
            .success(function (response) {
                toastr.success(response)
            });
        }
    }
})