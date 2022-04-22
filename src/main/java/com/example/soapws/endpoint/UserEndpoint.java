package com.example.soapws.endpoint;


import com.example.soapws.dto.GetUserRequest;
import com.example.soapws.dto.GetUserResponse;
import com.example.soapws.dto.User;
import com.example.soapws.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class UserEndpoint {
    private final UserService userService;
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request){
        GetUserResponse response = new GetUserResponse();
        User user = userService.getUserById((long) request.getId());
        response.setUser(user);
        return response;
    }
}
