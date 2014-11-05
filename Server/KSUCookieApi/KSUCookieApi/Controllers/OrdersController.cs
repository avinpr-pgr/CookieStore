using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;
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

        // TODO: Create a DELETE call for a specific ID

        // TODO: Add/Update quantity

        // TODO: Private method to manage static context object
    }
}