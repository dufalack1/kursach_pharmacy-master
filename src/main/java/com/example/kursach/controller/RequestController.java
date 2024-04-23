package com.example.kursach.controller;

import com.example.kursach.entity.Request;
import com.example.kursach.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class RequestController {
    @Autowired
    RequestService requestService;
    @GetMapping("/request")
    private List<Request> getAllRequest()
    {
        return requestService.getAllRequests();
    }
    @GetMapping("/request/{id}")
    private Request getRequestById(@PathVariable("id") int id)
    {
        return requestService.getRequestById(id);
    }
    @DeleteMapping("/request/{id}")
    private void deleteRequest(@PathVariable("id") int id)
    {
        requestService.delete(id);
    }
    @PostMapping("/request")
    private int saveRequest(@RequestBody Request request)
    {
        requestService.saveOrUpdate(request);
        return request.getId();
    }
    @PutMapping("/request")
    private Request update(@RequestBody Request request)
    {
        requestService.saveOrUpdate(request);
        return request;
    }
}
