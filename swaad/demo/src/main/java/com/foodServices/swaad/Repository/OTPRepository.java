package com.foodServices.swaad.Repository;

import com.foodServices.swaad.Entity.OTP;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OTPRepository extends CrudRepository<OTP,String> {

    @Query("select otp from OTP otp where otp.msisdn=?1 and otp.status=?2 ")
    OTP findByStatusByMsisdn(String msisdn,String status);

}
