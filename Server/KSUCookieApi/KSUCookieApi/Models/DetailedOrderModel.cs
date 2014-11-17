using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace KSUCookieApi.Models
{
    public class DetailedOrderModel :  OrderModel
    {
        public string Name { get; set; }
        public string Description { get; set; }
    }
}