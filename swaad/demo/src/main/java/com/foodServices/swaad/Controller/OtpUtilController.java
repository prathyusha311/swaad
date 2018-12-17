package com.foodServices.swaad.Controller;


import com.foodServices.swaad.Entity.Customer;
import com.foodServices.swaad.Entity.OTP;
import com.foodServices.swaad.Entity.Response;
import com.foodServices.swaad.Entity.TSP;
import com.foodServices.swaad.Service.OtpUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OtpUtilController {


    @Autowired
    OtpUtilService otpUtilService;

    @RequestMapping(path = "/generateOtpUser", method = RequestMethod.POST, produces="application/json",consumes = "application/json")
    public @ResponseBody
    Response otpGenerationUser(@RequestBody OTP otp) {

        Response resp = null;
        try{
            resp = otpUtilService.generateOtpUser(otp.getMsisdn());
        }catch (Exception e){
            System.out.println(e);
        }
        return resp;
    }

    @RequestMapping(path = "/validateOtpUser", method = RequestMethod.POST, produces="application/json",consumes = "application/json")
    public @ResponseBody
    Response otpValidationUser(@RequestBody OTP otp) {

        Response resp = null;
        try{
            resp = otpUtilService.validateOtpUser(otp.getMsisdn(), otp.getOtp());
        }catch (Exception e){
            System.out.println(e);
        }
        return resp;
    }


}
