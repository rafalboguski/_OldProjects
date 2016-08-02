using System;

namespace _Movies_App__MVC_6___Angular.Services.Logging
{
    public class Logger
    {
        public static void ReqRes(object request, object response)
        {

            System.Diagnostics.Debug.WriteLine("{0}\t{1}\t{2}", DateTime.Now, request, response);

        }

    }
}