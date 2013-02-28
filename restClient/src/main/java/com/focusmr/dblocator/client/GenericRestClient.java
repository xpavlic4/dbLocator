package com.focusmr.dblocator.client;

import javax.xml.bind.JAXBContext;
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

            URL url = new URL(uri);
            connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod(r.getMethod());
            connection.setRequestProperty("Content-Type", r.getType());
            InputStream xml = connection.getInputStream();

            JAXBContext jc = JAXBContext.newInstance(clazz);
            return jc.createUnmarshaller().unmarshal(xml);
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
        }
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
}
