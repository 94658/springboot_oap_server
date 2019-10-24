package com.soap.ics;

//import localhost._7000.soap_server.GetCountryRequest;
//import localhost._7000.soap_server.GetCountryResponse;
import localhost._7000.soap_server.GetUniversityRequest;
import localhost._7000.soap_server.GetUniversityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@SuppressWarnings("ALL")
@Endpoint
public class UniversityEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:7000/soap-server";
//
//
    private UniversityRepository universityRepository;
//
//
     @Autowired
    public UniversityEndpoint(UniversityRepository universityRepository) {
        this.universityRepository =  universityRepository;
    }
//
//
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUniversityRequest") //custom change for your project
    @ResponsePayload
    public GetUniversityResponse getUniversity(@RequestPayload GetUniversityRequest request) {
        GetUniversityResponse response = new GetUniversityResponse();
        response.setUniversity(universityRepository.getUniversityByName(request.getName()));
        return response;
    }

}
