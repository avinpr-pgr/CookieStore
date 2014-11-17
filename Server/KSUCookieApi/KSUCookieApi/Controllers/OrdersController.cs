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
        [HttpPut]
        public HttpResponseMessage UpdateOrder(OrderModel order)
        {
            if (!StaticDataContext.ProductList.Any(o => o.ProductId == order.ProductId))
                return Request.CreateErrorResponse(HttpStatusCode.NotFound, "This is bad juju!");

            bool orderExists = StaticDataContext.OrderList.Any(o => o.ProductId == order.ProductId);

            if (orderExists)
            {
                StaticDataContext.UpdateQuantity(order);
            }
            else
            {
                StaticDataContext.AddItemToOrder(order);
            }

            return Request.CreateResponse(HttpStatusCode.OK, order);
        }

        [HttpDelete]
        public HttpResponseMessage RemoveItem(int ProductId)
        {
            StaticDataContext.OrderList.RemoveAll(p => p.ProductId == ProductId);
            return Request.CreateResponse(HttpStatusCode.OK, "Good job");
        }

        [HttpPost]
        public HttpResponseMessage Submit([FromBody]bool submit)
        {
            var truth = submit;
            StaticDataContext.ResetOrderList();
            var random = new Random();
            int randomId = random.Next();
            return Request.CreateResponse(HttpStatusCode.OK, "Thank you for your purchase. Your order number is " + randomId);
        }

        [HttpGet]
        public IEnumerable<OrderModel> Order()
        {
            return StaticDataContext.OrderList;
        }

        [HttpGet]
        public IEnumerable<DetailedOrderModel> DetailedOrder()
        {
            return (from order in StaticDataContext.OrderList
                    join product in StaticDataContext.ProductList on order.ProductId equals product.ProductId
                    select new DetailedOrderModel
                    {
                        ProductId = order.ProductId,
                        Quantity = order.Quantity,
                        Name = product.Name,
                        Description = product.Description
                    });
        }
    }
}