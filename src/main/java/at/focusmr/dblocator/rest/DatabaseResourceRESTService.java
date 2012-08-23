package at.focusmr.dblocator.rest;

import at.focusmr.dblocator.jdbc.JdbcString;
import at.focusmr.dblocator.model.Databases;
import at.focusmr.dblocator.util.JdbcStringBuilder;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.LinkedList;
import java.util.List;

import static javax.ws.rs.core.MediaType.TEXT_XML;

/**
 * This class produces a RESTful service to read the contents of the databases table.
 */
@Path("/databases")
@RequestScoped
public class DatabaseResourceRESTService {
    @Inject
    private EntityManager em;

    @GET
    @Path("/jdbcs")
    @Produces(TEXT_XML)
    public List<JdbcString> listAllJdbcs() {
        final List<Databases> results = em.createQuery("select m from Databases m where m.category = 'dataentry'").getResultList();
        List<JdbcString> l = new LinkedList<JdbcString>();
        for (Databases d : results) {
            l.add(fromDatabase(d));
        }
        return l;
    }

    @GET
    @Path("/jdbcs/{country:[a-z][a-z]*}")
    @Produces(TEXT_XML)
    public JdbcString lookupMemberById(@PathParam("country") String country) {
        TypedQuery<Databases> query = em.createQuery("select m from Databases m where m.category = 'dataentry' and m.country = :country", Databases.class);
        query.setParameter("country", country);
        Databases d = query.getSingleResult();

        return fromDatabase(d);
    }

    private JdbcString fromDatabase(Databases d) {
        JdbcStringBuilder b = new JdbcStringBuilder();
        b.withHost(d.getHostname());
        b.withPort(d.getPort());
        b.withService(d.getService_name());
        b.withSid(d.getSid());
        return b.build();
    }
}
