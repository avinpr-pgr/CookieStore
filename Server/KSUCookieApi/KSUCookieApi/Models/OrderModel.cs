using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace KSUCookieApi.Models
{
    public class OrderModel
    {
        public int Id { get; set; }
        public int Quantity { get; set; }
        public Category ProductCategory { get; set; }
        public string Name { get; set; }
    }
}