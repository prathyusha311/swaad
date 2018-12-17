package com.foodServices.swaad.Controller;

import com.foodServices.swaad.Entity.Customer;
import com.foodServices.swaad.Entity.Response;
import com.foodServices.swaad.Entity.TSP;
import com.foodServices.swaad.Entity.TSPItems;
import com.foodServices.swaad.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @RequestMapping(path = "/getTsps", method = RequestMethod.GET, produces="application/json",consumes = "application/json")
    public @ResponseBody
    Map<String,Iterable<TSP>> getAllTsps() {

        return homeService.getAllTsps();

//        Iterable<TSP> t = homeService.getAllTsps();
//        Map<String,Object> m =  new HashMap<String, Object>();


    }


//    @RequestMapping(path = "/getAllMenuItemsByTsp", method = RequestMethod.GET, produces="application/json",consumes = "application/json")
//    public @ResponseBody
//    Iterable<TSPItems> getsAllTspMenuss() {
//
//        return homeService.getAllTsps();
//    }
}
