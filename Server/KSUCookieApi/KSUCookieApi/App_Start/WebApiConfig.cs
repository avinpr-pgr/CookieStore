using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace KSUCookieApi
{
    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            // Web API configuration and services

            // Web API routes
            config.MapHttpAttributeRoutes();

            config.Routes.MapHttpRoute(
                name: "BoolApi",
                routeTemplate: "api/{controller}/{action}/{submit}"                
                );

            config.Routes.MapHttpRoute(
                name: "DefaultApi",
                routeTemplate: "api/{controller}/{action}/{ProductId}",
                defaults: new { ProductId = RouteParameter.Optional }
            );
        }
    }
}
