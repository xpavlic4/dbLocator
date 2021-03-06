package com.focusmr.dblocator.rest;

import com.focusmr.dblocator.data.TnsName;
import com.focusmr.dblocator.data.TnsNamesBuilder;
import com.focusmr.dblocator.model.Databases;
import com.focusmr.dblocator.xml.TnsNameXml;
import com.focusmr.dblocator.xml.TnsNamesXml;

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
public class TnsNamesResourceRESTService {

    @Inject
    private EntityManager em;

    @GET
    @Path("/tnsnames")
    @Produces({TEXT_XML, APPLICATION_JSON})
    public TnsNamesXml listAllTns() {
        final List<Databases> results = em.createNamedQuery(Databases.Q.ALL, Databases.class).getResultList();

        TnsNamesXml l = new TnsNamesXml();
        for (Databases d : results) {
            TnsName tnsName = fromDatabase(d);

            TnsNameXml xml = new TnsNameXml();
            xml.setCountry(d.getCountry());
            xml.setTnsName(tnsName.getValue());
            xml.setNlsLang(d.getNlsLang());

            l.add(xml);
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
