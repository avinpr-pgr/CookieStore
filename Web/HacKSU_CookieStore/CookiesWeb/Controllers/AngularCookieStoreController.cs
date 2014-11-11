using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CookiesWeb.Controllers
{
    public class AngularCookieStoreController : Controller
    {
        // GET: AngularCookieStore
        public ActionResult Store()
        {
            return View();
        }
    }
}