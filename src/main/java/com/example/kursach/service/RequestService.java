package com.example.kursach.service;

import com.example.kursach.entity.Request;
import com.example.kursach.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getAllRequests()
    {
        List<Request> requests = new ArrayList<Request>();
        requestRepository.findAll().forEach(requests1 -> requests.add(requests1));
        return requests;
    }

    public Request getRequestById (int id)
    {
        return requestRepository.findById(id).get();
    }
    public void saveOrUpdate(Request request)
    {
        requestRepository.save(request);
    }
    public void delete(int id)
    {
        requestRepository.deleteById(id);
    }
    public void update(Request request, int id)
    {
        requestRepository.save(request);
    }
}
