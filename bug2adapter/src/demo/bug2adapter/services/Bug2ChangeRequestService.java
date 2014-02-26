/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *     Michael Fiedler     - initial API and implementation for Bugzilla adapter
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/

package demo.bug2adapter.services;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.Preview;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.Link;

import demo.bug2adapter.Bug2adapterManager;
import demo.bug2adapter.Bug2adapterConstants;
import demo.bug2adapter.servlet.ServiceProviderCatalogSingleton;
import demo.bug2adapter.resources.Bug2ChangeRequest;


import demo.bug2adapter.resources.Person;	

import demo.bug2adapter.resources.Person;	

import demo.bug2adapter.resources.Type;	


// Start of user code imports
// End of user code


@OslcService(Bug2adapterConstants.CHANGE_MANAGEMENT_DOMAIN)
@Path("{serviceProviderId}/bug2ChangeRequests")
public class Bug2ChangeRequestService
	
{

	@Context private HttpServletRequest httpServletRequest;
	@Context private HttpServletResponse httpServletResponse;
	@Context private UriInfo uriInfo;
	
    public Bug2ChangeRequestService()
    {
        super();
    }

    /**
     * RDF/XML, XML and JSON representation of a change request collection
     * 
     * TODO:  add query support
     * 
     * @param productId
     * @param where
     * @param pageString
     * @return
     * @throws IOException
     * @throws ServletException
     */
    
  @OslcDialogs(
    {
        @OslcDialog
        (
             title = "Change Request Selection Dialog",
             label = "Change Request Selection Dialog",
             uri = "/{serviceProviderId}/bug2ChangeRequests/selector",
             hintWidth = "325px",
             hintHeight = "325px",
             resourceTypes = {Bug2adapterConstants.TYPE_BUG2CHANGEREQUEST},
             usages = {OslcConstants.OSLC_USAGE_DEFAULT}
        )
    })   

	    @OslcQueryCapability
	    (
	        title = "Change Request Query Capability",
	        label = "Change Request Catalog Query",
	        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Bug2adapterConstants.PATH_BUG2CHANGEREQUEST,
	        resourceTypes = {Bug2adapterConstants.TYPE_BUG2CHANGEREQUEST},
	        usages = {OslcConstants.OSLC_USAGE_DEFAULT}
	    ) 
      
    @GET
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public Bug2ChangeRequest [] getBug2ChangeRequests(@PathParam("serviceProviderId")   final String serviceProviderId,
    		                                 		 @QueryParam("oslc.where") final String where,
    		                                 		 @QueryParam("page")       final String pageString) throws IOException, ServletException 
    {
    	int page=0;  
    	int limit=999;
        
		// Start of user code (MUST_FILL_IN) getResourceCollection_init
		// End of user code

        final List<Bug2ChangeRequest> resources = Bug2adapterManager.getBug2ChangeRequests(httpServletRequest, serviceProviderId, page, limit);      
        return resources.toArray(new Bug2ChangeRequest [resources.size()]);
        

    }
    
    /**
     * HTML representation of change request collection
     * 
     * Forwards to changerequest_collection_html.jsp to build the html page
     * 
     * @param productId
     * @param changeRequestId
     * @param pageString
     * @return
     * @throws ServletException
     * @throws IOException
     */
    


	@GET
	@Produces({ MediaType.TEXT_HTML })
	public Response getBug2ChangeRequestsAsHtml(@PathParam("serviceProviderId")       final String serviceProviderId,
			                          @PathParam("bug2ChangeRequestId") final String bug2ChangeRequestId,
			                          @QueryParam("page")           final String pageString) throws ServletException, IOException
	{
		int page=0;
		int limit=20;
		
		if (null != pageString) {
			page = Integer.parseInt(pageString);
		}

		// Start of user code (MUST_FILL_IN) getResourceCollectionAsHTML_init
		// End of user code

        final List<Bug2ChangeRequest> resources = Bug2adapterManager.getBug2ChangeRequests(httpServletRequest, serviceProviderId, page, limit);      
		
        if (resources!= null) {
        	httpServletRequest.setAttribute("resources", resources);
			// Start of user code (RECOMMENDED) getResourceCollectionAsHTML_setAttributes
			// End of user code

        	httpServletRequest.setAttribute("queryUri", 
                    uriInfo.getAbsolutePath().toString() + "?oslc.paging=true");
        	if (resources.size() > limit) {
        		resources.remove(resources.size() - 1);
        		httpServletRequest.setAttribute("nextPageUri", 
        				uriInfo.getAbsolutePath().toString() + "?oslc.paging=true&amp;page=" + (page + 1));
        	}
        	
        	ServiceProvider serviceProvider = ServiceProviderCatalogSingleton.getServiceProvider(httpServletRequest, serviceProviderId);
        	httpServletRequest.setAttribute("serviceProvider", serviceProvider);

        	RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/demo/bug2adapter/bug2changerequestcollection_html.jsp");
			
        	rd.forward(httpServletRequest,httpServletResponse);
        }
		
		throw new WebApplicationException(Status.NOT_FOUND);	
	}


    
	/**
	 * RDF/XML, XML and JSON representation of a single change request
	 * 
	 * @param productId
	 * @param changeRequestId
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 * @throws URISyntaxException
	 */
    


    @GET
    @Path("{bug2ChangeRequestId}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public Bug2ChangeRequest getBug2ChangeRequest(@PathParam("serviceProviderId")       final String serviceProviderId,
                                                  @PathParam("bug2ChangeRequestId") final String bug2ChangeRequestId) throws IOException, ServletException, URISyntaxException
    {
	
		// Start of user code (MUST_FILL_IN) getResource_init
		// End of user code

        final Bug2ChangeRequest aBug2ChangeRequest = Bug2adapterManager.getBug2ChangeRequest(httpServletRequest, bug2ChangeRequestId, serviceProviderId);

        if (aBug2ChangeRequest != null) {
			// Start of user code (RECOMMENDED) getResource_body
			// End of user code

            return aBug2ChangeRequest;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }



    
    /**
     * 
     * HTML representation for a single change request  - redirect the request directly to Bugzilla
     * 
     * @param productId
     * @param changeRequestId
     * @throws ServletException
     * @throws IOException
     * @throws URISyntaxException
     */
    


	@GET
	@Path("{bug2ChangeRequestId}")
	@Produces({ MediaType.TEXT_HTML })
	public Response getBug2ChangeRequestAsHtml(@PathParam("serviceProviderId")       final String serviceProviderId,
			                         @PathParam("bug2ChangeRequestId") final String bug2ChangeRequestId) throws ServletException, IOException, URISyntaxException
	{	
		// Start of user code (MUST_FILL_IN) getResourceAsHTML_init
		// End of user code

        final Bug2ChangeRequest aBug2ChangeRequest = Bug2adapterManager.getBug2ChangeRequest(httpServletRequest, bug2ChangeRequestId, serviceProviderId);

        if (aBug2ChangeRequest != null) {
        	httpServletRequest.setAttribute("aBug2ChangeRequest", aBug2ChangeRequest);
			// Start of user code getResourceAsHTML_setAttributes
			// End of user code

         	ServiceProvider serviceProvider = ServiceProviderCatalogSingleton.getServiceProvider(httpServletRequest, serviceProviderId);
        	httpServletRequest.setAttribute("serviceProvider", serviceProvider);

        	RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/demo/bug2adapter/bug2changerequest_html.jsp");
			
        	rd.forward(httpServletRequest,httpServletResponse);


		}

        throw new WebApplicationException(Status.NOT_FOUND);
	}

	
	/**
	 * OSLC delegated selection dialog for change requests
	 * 
	 * If called without a "terms" parameter, forwards to changerequest_selector.jsp to 
	 * build the html for the IFrame
	 * 
	 * If called with a "terms" parameter, sends a Bug search to Bugzilla and then 
	 * forwards to changerequest_filtered_json.jsp to build a JSON response
	 * 
	 * 
	 * @param terms
	 * @param productId
	 * @throws ServletException
	 * @throws IOException
	 */
	
	@GET
	@Path("selector")
	@Consumes({ MediaType.TEXT_HTML, MediaType.WILDCARD })
	public void bug2ChangeRequestSelector(@QueryParam("terms")     final String terms,
						              @PathParam("serviceProviderId")  final String serviceProviderId) throws ServletException, IOException
	{
		try {
			// Start of user code (MUST_FILL_IN) resourceSelector_init
			// End of user code

			ServiceProvider serviceProvider = ServiceProviderCatalogSingleton.getServiceProvider(httpServletRequest, serviceProviderId);
			httpServletRequest.setAttribute("serviceProvider", serviceProvider);
			httpServletRequest.setAttribute("selectionUri",uriInfo.getAbsolutePath().toString());
			// Start of user code (RECOMMENDED) resourceSelector_setAttributes
			// End of user code

			if (terms != null ) {
				httpServletRequest.setAttribute("terms", terms);
				final List<Bug2ChangeRequest> resources = Bug2adapterManager.searchBug2ChangeRequests(httpServletRequest, serviceProviderId, terms);      
				if (resources!= null) {
							httpServletRequest.setAttribute("resources", resources);
							RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/demo/bug2adapter/bug2changerequestfilteredcollection_json.jsp"); 
							
							rd.forward(httpServletRequest, httpServletResponse);
				}
				//a empty search should return an empty list and not NULL!
				throw new WebApplicationException(Status.NOT_FOUND);	
			
			} else {
				try {	
					RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/demo/bug2adapter/bug2changerequestselector_html.jsp"); 
					
					rd.forward(httpServletRequest, httpServletResponse);
					
				} catch (Exception e) {
					throw new ServletException(e);
				}
			}
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}

	}
	
    
    /**
     * OSLC delegated creation dialog for a single change request
     * 
     * Forwards to changerequest_creator.jsp to build the html form
     * 
     * @param productId
     * @throws IOException
     * @throws ServletException
     */
	
    @GET
    @Path("creator") 
    @Consumes({MediaType.WILDCARD})
    public void bug2ChangeRequestCreatorAsHtml(@PathParam("serviceProviderId") final String serviceProviderId) throws IOException, ServletException
    {
		// Start of user code (MUST_FILL_IN) resourceCreatorAsHTML_init
		// End of user code

		ServiceProvider serviceProvider = ServiceProviderCatalogSingleton.getServiceProvider(httpServletRequest, serviceProviderId);
		httpServletRequest.setAttribute("serviceProvider", serviceProvider);

		RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/demo/bug2adapter/bug2changerequestcreator_html.jsp");
		
		rd.forward(httpServletRequest, httpServletResponse);
    }
	

    /**
     * Backend creator for the OSLC delegated creation dialog. 
     * 
     * Accepts the input in FormParams and returns a small JSON response
     * 
     * @param productId
     * @param component
     * @param version
     * @param summary
     * @param op_sys
     * @param platform
     * @param description
     */
    @POST
    @Path("creator") 
    @Consumes({ MediaType.APPLICATION_FORM_URLENCODED})
    public void createBug2ChangeRequest(@PathParam("serviceProviderId")   final String serviceProviderId)
    {
    	try {
    		Bug2ChangeRequest aBug2ChangeRequest = new Bug2ChangeRequest();

    		String[] paramValues;

				paramValues = httpServletRequest.getParameterValues("reviewed");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setReviewed(new Boolean(paramValues[0]));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("verified");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setVerified(new Boolean(paramValues[0]));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("shortTitle");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setShortTitle(paramValues[0]);
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("affectsRequirement");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addAffectsRequirement(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("subject");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addSubject(paramValues[i]);
						}
				}			
				paramValues = httpServletRequest.getParameterValues("discussedBy");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setDiscussedBy(new Link(new URI(paramValues[0])));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("relatedTestPlan");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addRelatedTestPlan(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("relatedTestCase");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addRelatedTestCase(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("version");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setVersion(paramValues[0]);
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("component");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setComponent(paramValues[0]);
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("affectedByDefect");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addAffectedByDefect(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("creator");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addCreator(new Person(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("relatedChangeRequest");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addRelatedChangeRequest(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("affectsTestResult");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addAffectsTestResult(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("identifier");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setIdentifier(paramValues[0]);
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("affectsPlanItem");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addAffectsPlanItem(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("closeDate");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setCloseDate(new SimpleDateFormat().parse(paramValues[0]));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("implementsRequirement");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addImplementsRequirement(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("contributor");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addContributor(new Person(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("blocksTestExecutionRecord");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addBlocksTestExecutionRecord(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("status");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setStatus(paramValues[0]);
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("created");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setCreated(new SimpleDateFormat().parse(paramValues[0]));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("type");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addType(new Type(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("product");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setProduct(paramValues[0]);
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("testedByTestCase");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addTestedByTestCase(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("inprogress");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setInprogress(new Boolean(paramValues[0]));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("serviceProvider");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setServiceProvider(new URI(paramValues[0]));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("description");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setDescription(paramValues[0]);
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("type");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addType(new URI(paramValues[i]));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("relatedTestExecutionRecord");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addRelatedTestExecutionRecord(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("fixed");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setFixed(new Boolean(paramValues[0]));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("title");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setTitle(paramValues[0]);
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("tracksChangeSet");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addTracksChangeSet(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("modified");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setModified(new SimpleDateFormat().parse(paramValues[0]));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("instanceShape");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setInstanceShape(new Link(new URI(paramValues[0])));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("relatedTestScript");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addRelatedTestScript(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("tracksRequirement");
				if (paramValues != null) {
			    		for(int i=0; i<paramValues.length; i++) {
							aBug2ChangeRequest.addTracksRequirement(new Link(new URI(paramValues[i])));
						}
				}			
				paramValues = httpServletRequest.getParameterValues("closed");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setClosed(new Boolean(paramValues[0]));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			
				paramValues = httpServletRequest.getParameterValues("approved");
				if (paramValues != null) {
						if (paramValues.length == 1) {
							if (paramValues[0].length() != 0)
								aBug2ChangeRequest.setApproved(new Boolean(paramValues[0]));
							// else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
						} 
					
				}			

      
    		final Bug2ChangeRequest newBug2ChangeRequest = Bug2adapterManager.createBug2ChangeRequest(httpServletRequest, aBug2ChangeRequest, serviceProviderId);
   		
    		httpServletRequest.setAttribute("newResource", newBug2ChangeRequest);
    		httpServletRequest.setAttribute("newResourceUri", newBug2ChangeRequest.getAbout().toString());

    		// Send back to the form a small JSON response
    		httpServletResponse.setContentType("application/json");
    		httpServletResponse.setStatus(Status.CREATED.getStatusCode());
    		httpServletResponse.addHeader("Location", newBug2ChangeRequest.getAbout().toString());
    		PrintWriter out = httpServletResponse.getWriter();
    		out.print("{" + "\"resource\" : \"" + newBug2ChangeRequest.getAbout().toString() + "\"}");
    		out.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new WebApplicationException(e);
    	}

    }

	/**
	 * Create a single BugzillaChangeRequest via RDF/XML, XML or JSON POST
	 * @param productId
	 * @param changeRequest
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */

		 @OslcDialog
		(
             title = "Change Request Creation Dialog",
             label = "Change Request Creation Dialog",
             uri = "/{serviceProviderId}/bug2ChangeRequests/creator",
             hintWidth = "600px",
             hintHeight = "375px",
             resourceTypes = {Bug2adapterConstants.TYPE_BUG2CHANGEREQUEST},
             usages = {OslcConstants.OSLC_USAGE_DEFAULT}
		)

		@OslcCreationFactory
		(
			 title = "Change Request Creation Factory",
			 label = "Change Request Creation",
			 resourceShapes = {OslcConstants.PATH_RESOURCE_SHAPES + "/" + Bug2adapterConstants.PATH_BUG2CHANGEREQUEST},
			 resourceTypes = {Bug2adapterConstants.TYPE_BUG2CHANGEREQUEST},
			 usages = {OslcConstants.OSLC_USAGE_DEFAULT}
		)

    @POST
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public Response addChangeRequest(@PathParam("productId") final String productId,
                                                             final Bug2ChangeRequest aBug2ChangeRequest) throws IOException, ServletException
    {
    	return null; // See LAB 5 of the Lyo workshop for implementation
    }

	// Start of user code (RECOMMENDED) functions
	// End of user code

}

