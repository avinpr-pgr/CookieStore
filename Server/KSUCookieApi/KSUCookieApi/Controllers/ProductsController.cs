using KSUCookieApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Http;

namespace KSUCookieApi.Controllers
{
    public class ProductsController : ApiController
    {
        [HttpGet]
        public IEnumerable<ProductsModel> AllProducts()
        {
            return StaticDataContext.ProductList;
        }

        [HttpGet]
        public IEnumerable<ProductsModel> Cookies()
        {
            return StaticDataContext.ProductList.Where(p => p.ProductCategory == Category.Cookie);
        }

        [HttpGet]
        public IEnumerable<ProductsModel> Milk()
        {
            return StaticDataContext.ProductList.Where(p => p.ProductCategory == Category.Milk);
        }

        [HttpGet]
        public ProductsModel Product(int id)
        {
            return StaticDataContext.ProductList.Where(p => p.Id == id).FirstOrDefault();
        }
    }
}