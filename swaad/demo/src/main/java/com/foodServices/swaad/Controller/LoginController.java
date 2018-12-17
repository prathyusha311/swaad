package com.foodServices.swaad.Controller;

import com.foodServices.swaad.Entity.Customer;
import com.foodServices.swaad.Entity.Response;
import com.foodServices.swaad.Entity.TSP;
import com.foodServices.swaad.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(path = "/user", method = RequestMethod.POST, produces="application/json",consumes = "application/json")
    public @ResponseBody
    Response customerLogin(@RequestBody Customer customer) {

        Response resp = null;
        try{
            resp = loginService.loginCustomer(customer.getMsisdn(), customer.getPin());
        }catch (Exception e){
            System.out.println(e);
        }
        return resp;
    }


    @RequestMapping(path = "/TSP", method = RequestMethod.POST, produces="application/json",consumes = "application/json")
    public @ResponseBody
    Response tspLogin(@RequestBody TSP tsp) {
    Response resp = null;
        try{
            resp =  loginService.loginTSP(tsp.getMsisdn(), tsp.getPin());
        }catch (Exception e){
            System.out.println(e);
        }

        return resp;
    }


}
