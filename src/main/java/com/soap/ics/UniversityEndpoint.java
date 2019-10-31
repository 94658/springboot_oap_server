package com.soap.ics;

import localhost._7050.universities.GetAllUniversitiesResponse;
import localhost._7050.universities.GetUniversityRequest;
import localhost._7050.universities.GetUniversityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@SuppressWarnings("ALL")
@Endpoint
public class UniversityEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:7050/universities";

    private UniversityRepository universityRepository;

    @Autowired
    public UniversityEndpoint(UniversityRepository universityRepository) {
        this.universityRepository =  universityRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUniversityRequest")
    @ResponsePayload
    public GetUniversityResponse getUniversity(@RequestPayload GetUniversityRequest request) {
        GetUniversityResponse response = new GetUniversityResponse();
        response.setUniversity(universityRepository.getUniversityByName(request.getName()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUniversitiesRequest")
    @ResponsePayload
    public GetAllUniversitiesResponse getAllUniversities() {
        GetAllUniversitiesResponse response = new GetAllUniversitiesResponse();

        response.getUniversity().addAll(universityRepository.getAllUniversities());

        return response;
    }

}
