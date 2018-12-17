package com.foodServices.swaad.Service;

import com.foodServices.swaad.Entity.Customer;
import com.foodServices.swaad.Entity.Response;
import com.foodServices.swaad.Entity.TSP;
import com.foodServices.swaad.Repository.CustomerRepository;
import com.foodServices.swaad.Repository.OTPRepository;
import com.foodServices.swaad.Repository.TSPRepository;
import com.foodServices.swaad.Utility.SecureUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class RegistrationService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TSPRepository tspRepository;


    @Autowired
    OtpUtilService otpUtilService;

    public Response addNewUser(Customer customer) throws NoSuchAlgorithmException {
        Response response = new Response();

        Customer customer1 = customerRepository.findByMsisdn(customer.getMsisdn());
        if(customer1 == null)
        {
            String salt= SecureUtility.getSalt();
            customer.setSalt(salt);
            customer.setPin(SecureUtility.hashPassword(customer.getPin(),salt));
            customerRepository.save(customer);
//            response.setTxnStatus("200");
//            response.setTxnMessage("Success");
            response = otpUtilService.generateOtpUser(customer.getMsisdn());
        }
        else
        {
            response.setTxnStatus("525");
            response.setTxnMessage("Already registered");
        }
        return response;
    }




    public Response addNewTSP(TSP tsp) throws NoSuchAlgorithmException {
        Response response = new Response();

        TSP tsp1 = tspRepository.findByMsisdn(tsp.getMsisdn());
        if(tsp1 == null)
        {
            String salt= SecureUtility.getSalt();
            tsp.setSalt(salt);
            tsp.setPin(SecureUtility.hashPassword(tsp.getPin(),salt));
            tspRepository.save(tsp);
            response.setTxnStatus("200");
            response.setTxnMessage("Success");
        }
        else
        {
            response.setTxnStatus("525");
            response.setTxnMessage("Already registered");
        }
        return response;
    }
}
