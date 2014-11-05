using KSUCookieApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace KSUCookieApi.Controllers
{
    public class ProductsController : ApiController
    {
        // TODO: Chris to explain how this works in MVC
        //[ActionName("AllProducts"] 
        public HttpResponseMessage Get()
        {
            // localhost/products returns all products
            // TODO: Products will return a JSON representation of all products
            return Request.CreateResponse(HttpStatusCode.OK, StaticDataContext.ProductList);
        }

        //TODO: Get Method to get only cookies
        //public ActionResult Cookies()
        //{
                // localhost/products/cookies returns a list of cookies
        //}

        //public ActionResult Milk()
        //{
        // localhost/products/milk returns a list of milk
        //}

        // TODO: Get method to retrieve product by unique ID.
        public void Product(int id)
        {
            // localhost/products/id returns a product based on id passed in
        }
    }
}