using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace KSUCookieApi.Models
{
    public enum Category {Cookie,Milk};

    public abstract class StaticDataContext
    {
        public static List<Product> ProductList = new List<Product>
        {
            CreateProduct(0,1m,Category.Cookie,"Chocolate Chip", "Warm, gooey Chocolate Chips!"),
            CreateProduct(0,1.25m,Category.Cookie,"Peanut Butter", "Caution--May Contain Peanut Products"),
            CreateProduct(0,1.5m,Category.Cookie,"Sugar", "WHEEE!!"),
            CreateProduct(0,2.25m,Category.Cookie,"Oatmeal Raisin", "It's Oatmeal.  It's Raisin.  It's both!"),
            CreateProduct(0,.5m,Category.Milk,"Whole", "Pours like a milkshake"),
            CreateProduct(0,.75m,Category.Milk,"2%", "Just Like Mom used to buy"),
            CreateProduct(0,.55m,Category.Milk,"Skim", "To help you watch your waistline"),
            CreateProduct(0,1.3m,Category.Milk,"Soy", "Well... this is really soy juice but who cares?"),

        };

        public static Product CreateProduct(int id, decimal price, Category cat, string name, string desc)
        {
            return new Product
            {
                Id = id,
                Name = name,
                Price = price,
                Category = cat,
                Description = desc
            };
        }
    }
}