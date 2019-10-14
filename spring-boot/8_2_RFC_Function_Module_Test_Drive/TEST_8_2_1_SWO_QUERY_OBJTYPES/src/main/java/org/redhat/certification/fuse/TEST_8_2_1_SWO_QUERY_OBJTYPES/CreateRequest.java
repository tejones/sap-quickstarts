/**
 * Copyright 2016 Red Hat, Inc.
 * 
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 * 
 */
package org.redhat.certification.fuse.TEST_8_2_1_SWO_QUERY_OBJTYPES;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;

/**
 * A {@link CreateRequest} is a processor bean which builds a request to the GetList method of the FlightCustomer BAPI
 * and sets that request in the body of the exchange's message.
 * 
 * @author William Collins (punkhornsw@gmail.com)
 *
 */
public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		// Create a request message from the endpoint to the GetList method of the FlightCustomer BAPI
		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:SWO_QUERY_API_OBJTYPES", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		// Add query parameters to the request to retrieve upto 10 Customer records including Web Users.
		request.put("OBJECT_NAME", " ");
		request.put("LANGUAGE", "EN");
		request.put("WITH_INTERNAL_API_METHODS", "X");
		request.put("WITH_IMPLEMENTED", "X");
		request.put("WITH_TEXTS", "X");
		request.put("WITH_OBJECT_NAMES", "X");
		
		// Set the request in in the body of the exchange's message.
		exchange.getIn().setBody(request);
	}

}
