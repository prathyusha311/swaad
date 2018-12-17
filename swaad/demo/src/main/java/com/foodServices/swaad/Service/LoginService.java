package com.foodServices.swaad.Service;


import com.foodServices.swaad.Entity.Customer;
import com.foodServices.swaad.Entity.Response;
import com.foodServices.swaad.Entity.TSP;
import com.foodServices.swaad.Repository.CustomerRepository;
import com.foodServices.swaad.Repository.TSPRepository;
import com.foodServices.swaad.Utility.SecureUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;


@Service
public class LoginService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TSPRepository tspRepository;

    public Response loginCustomer(String msisdn, String pin) throws NoSuchAlgorithmException {
        Response response = new Response();

        Customer customer = customerRepository.findByMsisdn(msisdn);
            if(customer!=null) {
                if (SecureUtility.hashPassword(pin, customer.getSalt()).equals(customer.getPin())) {
                    response.setTxnStatus("200");
                    response.setTxnMessage("Success");
                } else {
                    response.setTxnStatus("524");
                    response.setTxnMessage("Incorrect mobileNumber or pin");
                }
            }else{
                response.setTxnStatus("524");
                response.setTxnMessage("Incorrect mobileNumber or pin");
            }
        return response;
        }


    public Response loginTSP(String msisdn, String pin) throws NoSuchAlgorithmException {
        Response response = new Response();

        TSP tsp = tspRepository.findByMsisdn(msisdn);
        if(tsp!=null) {
            if (SecureUtility.hashPassword(pin, tsp.getSalt()).equals(tsp.getPin())) {
                response.setTxnStatus("200");
                response.setTxnMessage("Success");
            } else {
                response.setTxnStatus("524");
                response.setTxnMessage("Incorrect username or password");
            }
        }else{
            response.setTxnStatus("524");
            response.setTxnMessage("Incorrect username or password");
        }

        return response;
    }

}
