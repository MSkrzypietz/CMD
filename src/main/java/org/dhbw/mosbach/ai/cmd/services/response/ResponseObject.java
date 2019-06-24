package org.dhbw.mosbach.ai.cmd.services.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class ResponseObject {

    @JsonProperty(value = ResponseParameters.HTTP_STATUS, required = true)
    private final Status status;

    @JsonProperty(value = ResponseParameters.MESSAGE, required = true)
    private final String message;

    public ResponseObject(Response.Status status, String message) {
        this.status = new Status(status);
        this.message = message;
    }

    public Response buildResponse() {
        return Response.status(status.getCode()).entity(this).build();
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}