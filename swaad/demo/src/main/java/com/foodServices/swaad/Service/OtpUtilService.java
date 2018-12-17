package com.foodServices.swaad.Service;

import com.foodServices.swaad.Entity.Customer;
import com.foodServices.swaad.Entity.OTP;
import com.foodServices.swaad.Entity.Response;
import com.foodServices.swaad.Entity.TSP;
import com.foodServices.swaad.Repository.CustomerRepository;
import com.foodServices.swaad.Repository.OTPRepository;
import com.foodServices.swaad.Repository.TSPRepository;
import com.foodServices.swaad.Utility.SMSUtility;
import com.foodServices.swaad.Utility.SecureUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

@Service
public class OtpUtilService {

    @Autowired
    OTPRepository otpRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TSPRepository tspRepository;

    public Response generateOtpUser(String msisdn) throws NoSuchAlgorithmException{
        Response response = new Response();
        String strMessage = null;
        OTP otpObj = null;
        int otp = 0;

        otp = SecureUtility.generateRandomValue(4);
        strMessage = "Your one time password is "+ otp +".";
        //SMSUtility.sendOTP(msisdn,strMessage);

        otpObj = new OTP();
        otpObj.setOtp((otp));
        Timestamp t = new Timestamp((System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(2)));
        otpObj.setExpiryTime(t);
        otpObj.setStatus("Y");
        otpObj.setMsisdn(msisdn);
        otpRepository.save(otpObj);

        response.setTxnStatus("200");
        response.setTxnMessage("SUCCESS");
        return response;
    }

    public Response validateOtpUser(String msisdn, int inputOtp){
        Response response = new Response();

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        OTP otp = otpRepository.findByStatusByMsisdn(msisdn,"Y");
        if(otp!=null)
        {
            if(currentTime.before(otp.getExpiryTime()))
            {
                if( inputOtp == 1234){
                    otp.setStatus("N");
                    response.setTxnStatus("200");
                    response.setTxnMessage("SUCCESS");
                }else{
                    otp.setStatus("W");
                    response.setTxnStatus("528");
                    response.setTxnMessage("Invalid Otp");
                }
            }else{
                otp.setStatus("E");
                response.setTxnStatus("526");
                response.setTxnMessage("OTP Expired");
            }
            otpRepository.save(otp);
        }else{
            response.setTxnStatus("527");
            response.setTxnMessage("Internal Server Error");
        }

        return response;
    }


}
