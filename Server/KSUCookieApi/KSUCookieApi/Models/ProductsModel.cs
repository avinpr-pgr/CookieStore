using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace KSUCookieApi.Models
{
    public class Product
    {
        public Category Category { get; set; }
        public int Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public decimal Price { get; set; }
    }
}