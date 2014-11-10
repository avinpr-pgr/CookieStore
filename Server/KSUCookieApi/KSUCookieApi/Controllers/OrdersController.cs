using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using KSUCookieApi.Models;
using System.Web.Http;

namespace KSUCookieApi.Controllers
{
    public class OrdersController : ApiController
    {
        // TODO: PUT method to update order (add if no entry, update quantity if present)
        public HttpResponseMessage Put([FromBody] OrderModel order)
        {
            return Request.CreateResponse(HttpStatusCode.OK, order);
        }

        // As this is not expressing returning data to the client, should this be a get?  Think about your HTTP verbs
        //[HttpGet]
        // If this isn't a Get, what should you return?  Remember, void is not an option.
        //public IEnumerable<OrderList> Delete(int Id)
        //{
        //    // 
        //    StaticDataContext.OrderList.RemoveAll(p => p.Id == Id);
        //    return StaticDataContext.OrderList;
        //}

        // TODO: Add/Update quantity
        //[HttpGet]
        //public IEnumerable<OrderModel> AddToCart(int Id, Category cat, int quantity)
        //{
        //    StaticDataContext.AddItemToCart(Id, cat, quantity);
        //    return StaticDataContext.OrderList;
        //}


        // TODO: Private method to manage static context object
    }
}