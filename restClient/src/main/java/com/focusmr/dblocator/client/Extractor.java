package com.focusmr.dblocator.client;

import javax.xml.bind.JAXBException;

/**
 * Parses input stream from webservice.
 */
public interface Extractor {
    Object invoke() throws JAXBException;
}
