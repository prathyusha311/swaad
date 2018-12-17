package com.foodServices.swaad.Controller;


import com.foodServices.swaad.Entity.Customer;
import com.foodServices.swaad.Entity.Response;
import com.foodServices.swaad.Entity.TSP;
import com.foodServices.swaad.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/register")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping(path = "/registerUser", method = RequestMethod.POST, produces="application/json",consumes = "application/json")
    public @ResponseBody
    Response addNewUser(@RequestBody Customer customer) {
        Response resp = null;
        try{
            resp = registrationService.addNewUser(customer);
        }catch (Exception e){
            System.out.print("RegistrationController -> registrationService");
            resp.setTxnMessage(e.getMessage());
            resp.setTxnStatus("500");
        }

        return resp;
    }

    @RequestMapping(path = "/registerTSP", method = RequestMethod.POST, produces="application/json",consumes = "application/json")
    public @ResponseBody
    Response addNewTSP(@RequestBody TSP tsp) {
        Response resp = null;
        try{
            resp = registrationService.addNewTSP(tsp);
        }catch (Exception e){
            System.out.print("RegistrationController -> registrationService");
        }

        return resp;
    }
}
