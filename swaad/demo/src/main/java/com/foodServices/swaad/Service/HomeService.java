package com.foodServices.swaad.Service;

import com.foodServices.swaad.Entity.Response;
import com.foodServices.swaad.Entity.TSP;
import com.foodServices.swaad.Repository.TSPItemsRepository;
import com.foodServices.swaad.Repository.TSPRepository;
import com.foodServices.swaad.Utility.SecureUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class HomeService {

    @Autowired
    TSPRepository tspRepository;

    @Autowired
    TSPItemsRepository tspItemsRepository;

    public Map<String,Iterable<TSP>> getAllTsps() {

        Map<String,Iterable<TSP>> ans = new HashMap<String,Iterable<TSP>>();
        Iterable<TSP> tsp = tspRepository.findAll();
        ans.put("restaurants",tsp);

        return ans;
    }

//    public Map<String,Iterable<TSP>> getAllTsps() {
//
//        Map<String,Iterable<TSP>> ans = new HashMap<String,Iterable<TSP>>();
//        Iterable<TSP> tsp = tspRepository.findAll();
//
//        Object obj = tspRepository.findAll();
//
//        ans.put("restaurants",tsp);
//
//        return ans;
//    }
}
