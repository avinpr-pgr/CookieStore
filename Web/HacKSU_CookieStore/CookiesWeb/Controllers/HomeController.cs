using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CookiesWeb.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult CookieStore()
        {
            return View();
        }
    }
}