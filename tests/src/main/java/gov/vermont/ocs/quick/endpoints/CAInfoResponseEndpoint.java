package gov.vermont.ocs.quick.endpoints;

import gov.ocse.jit.wsdl.caretriever.CARetrieveInfoResponse;
import gov.ocse.jit.wsdl.caretriever.CaRetrieveInfo;
import gov.ocse.jit.wsdl.caretriever.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;

/**
 * @author Oblio.Leitch
 *         11/13/2015.
 */
@Endpoint
public class CAInfoResponseEndpoint
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CAInfoResponseEndpoint.class);
    private static final String NAMESPACE_URI = "http://www.ocse.gov/jit/wsdl/CARetriever.xsd";

    private ObjectFactory objectFactory = new ObjectFactory();

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "caRetrieveInfo")
    @ResponsePayload
    public JAXBElement<CARetrieveInfoResponse> getCountry(@RequestPayload CaRetrieveInfo request) {
        LOGGER.debug("Got a hit.");
        CARetrieveInfoResponse infoResponse = objectFactory.createCARetrieveInfoResponse();
        return objectFactory.createCAretrieveInfoResponse(infoResponse);
    }
}
