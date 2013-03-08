package com.focusmr.dblocator.client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Handles REST requests from client site.
 */
public class GenericRestClient {

    /**
     * Opens connection based on {@link GenericRestClient.Request} a transform input stream into
     * class.
     *
     * @param r     holding metadata of request
     * @param clazz class to be unmarschal into
     * @return unmarhalled object
     */
    public Object execute(Request r, Class clazz) throws Exception {
        HttpURLConnection connection = null;
        try {
            String uri = r.getUri();
            if (r.getEntity() != null) {
                uri += r.getEntity();
            }
            connection = prepareConnection(r, uri);
            InputStream xml = connection.getInputStream();

            return new XmlExtractor(clazz, xml).invoke();
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
        }
    }

    /**
     * Opens connection based on {@link GenericRestClient.Request} a transform input stream into
     * String.
     *
     * @param r request
     * @return string in response
     * @throws Exception
     */
    public Object execute(Request r) throws Exception {
        HttpURLConnection connection = null;
        try {
            String uri = r.getUri();
            if (r.getEntity() != null) {
                uri += r.getEntity();
            }
            connection = prepareConnection(r, uri);
            InputStream stream = connection.getInputStream();

            return new StringExtractor(stream).invoke();
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
        }
    }

    /**
     * Prepares connection.
     *
     * @param r   holds content-type of connection
     * @param uri uri
     * @return created connetion
     * @throws IOException
     */
    HttpURLConnection prepareConnection(Request r, String uri) throws IOException {
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod(r.getMethod());
        connection.setRequestProperty("Content-Type", r.getType());
        return connection;
    }

    /**
     * Builder pattern for {@link GenericRestClient.Request}
     */
    @SuppressWarnings("SameParameterValue")
    public static class RequestBuilder {

        private String uri;
        private String method;
        private String type;
        private String entity;

        /**
         * With uri.
         *
         * @param uri uri
         * @return builder
         */
        public RequestBuilder withURI(String uri) {
            this.uri = uri;
            return this;
        }

        /**
         * With method.
         *
         * @param method method
         * @return builder
         */
        public RequestBuilder withMethod(String method) {
            this.method = method;
            return this;
        }

        /**
         * With content type.
         *
         * @param type type
         * @return builder
         */
        public RequestBuilder withContentType(String type) {
            this.type = type;
            return this;
        }

        /**
         * With entity.
         * e.g. cz
         *
         * @param entity entity
         * @return builder
         */
        public RequestBuilder withEntity(String entity) {
            this.entity = entity;
            return this;
        }

        /**
         * Builds.
         *
         * @return request
         */
        public Request build() {
            Request request = new Request();
            request.setEntity(entity);
            request.setMethod(method);
            request.setType(type);
            request.setUri(uri);
            return request;
        }
    }

    /**
     * Metadata.
     */
    protected static class Request {

        private String uri;
        private String method;
        private String type;
        private String entity;

        /**
         * Sets uri.
         *
         * @param uri uri
         */
        public void setUri(String uri) {
            this.uri = uri;
        }

        /**
         * Sets method.
         *
         * @param method e.g. GET
         */
        public void setMethod(String method) {
            this.method = method;
        }

        /**
         * Sets type.
         *
         * @param type e.g. text/xml
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * Sets entity.
         * e.g. cz
         *
         * @param entity entity
         */
        public void setEntity(String entity) {
            this.entity = entity;
        }

        /**
         * Gets ur.
         * e.g. http://localhost:8080/DbLocator/rest/databases/jdbcs/
         *
         * @return uri
         */
        public String getUri() {
            return uri;
        }

        /**
         * Gets method.
         * e.g. GET
         *
         * @return http method
         */
        public String getMethod() {
            return method;
        }

        /**
         * Gets type.
         * e.g. text/xml
         *
         * @return type
         */
        public String getType() {
            return type;
        }

        /**
         * Gets entity.
         * e.g. cz
         *
         * @return entity
         */
        public String getEntity() {
            return entity;
        }
    }

    private class XmlExtractor implements Extractor {
        private Class clazz;
        private InputStream xml;

        public XmlExtractor(Class clazz, InputStream xml) {
            this.clazz = clazz;
            this.xml = xml;
        }

        @Override
        public Object invoke() throws JAXBException {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            return jc.createUnmarshaller().unmarshal(xml);
        }
    }

    private class StringExtractor implements Extractor {
        private InputStream xml;

        public StringExtractor(InputStream xml) {
            this.xml = xml;
        }

        @Override
        public Object invoke() throws JAXBException {
            return convertStreamToString(xml);
        }

    }

    /**
     * Converts stream into string.
     *
     * @param is input stream
     * @return string from stream
     */
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
