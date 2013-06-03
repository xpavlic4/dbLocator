package com.focusmr.dblocator.rest;

import com.focusmr.dblocator.data.TnsName;
import com.focusmr.dblocator.data.TnsNamesBuilder;
import com.focusmr.dblocator.model.Databases;
import com.focusmr.dblocator.xml.CountriesXML;
import com.focusmr.dblocator.xml.TnsNameXml;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_XML;

/**
 * This class produces a RESTful service to read the contents of the databases
 * table.
 */
@Path("/databases")
@RequestScoped
public class CountriesResourceRESTService {

    @Inject
    private EntityManager em;

    @GET
    @Path("/countries")
    @Produces({TEXT_XML, APPLICATION_JSON})
    public CountriesXML listAllCountries() {
        final List<String> results = em.createNamedQuery(Databases.Q.DISTINCT_COUNTRY, String.class).getResultList();

        CountriesXML l = new CountriesXML();
        for (String d : results) {
            l.add(d);
        }
        return l;
    }

    @GET
    @Path("/tnsnames/{country:[a-z][a-z]*}")
    @Produces({TEXT_XML, APPLICATION_JSON})
    public TnsNameXml lookupMemberById(@PathParam("country") String country) {
        TypedQuery<Databases> query = em.createNamedQuery(Databases.Q.BY_COUNTRY, Databases.class);
        query.setParameter("country", country);
        Databases d = query.getSingleResult();

        TnsName tnsName = fromDatabase(d);
        TnsNameXml xml = new TnsNameXml();
        xml.setTnsName(tnsName.getValue());
        xml.setCountry(country);
        xml.setNlsLang(d.getNlsLang());
        return xml;
    }

    TnsName fromDatabase(Databases d) {
        TnsNamesBuilder b = new TnsNamesBuilder();
        b.withTnsName(d.getTnsName());
        b.withHost(d.getHostname());
        b.withPort(d.getPort());
        b.withServiceName(d.getServiceName());
        b.withSid(d.getSid());
        return b.build();
    }
}
