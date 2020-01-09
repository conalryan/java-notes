package com.conalryan.util;

import com.conalryan.xml.XMLDomainObject;
import javax.xml.bind.*;
import java.io.*;

/**
 * A collection of helper methods for marshaling and unmarshaling XML instances.
 */
public class XMLUtils {

    /**
     * Put the provided XML String into the specified XML Domain Object using JAXB without using
     * schema validation.
     *
     * @param xmlFile an XML instance that matched the XML Domain object specified by T
     * @param T           a XML Domain object class which corresponds the XML instance
     * @return XML Domain Object of type T populated with values in the provided String.
     * @throws com.conalryan.util.InvalidXMLException if the provided  xmlInstance cannot be successfully parsed.
     */
    public static  <T extends XMLDomainObject> T unmarshall(File xmlFile, Class T)
            throws InvalidXMLException {
        T returnValue;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(T);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            returnValue = (T) unmarshaller.unmarshal(new FileInputStream(xmlFile));
        } catch (JAXBException e) {
            throw new InvalidXMLException("JAXBException issue: " +e.getMessage(),e);
        } catch (FileNotFoundException e) {
            throw new InvalidXMLException("Could not find: " + xmlFile + e.getMessage(), e);
        }
        return returnValue;
    }


    /**
     * Serializes the domainClass into an XML instance which is returned as a String.
     * @param domainClass the XML model class.
     * @return a String which is a valid XML instance for the domain class provided.
     * @throws com.conalryan.util.InvalidXMLException is the object can't be parsed into XML.
     */
    public static String marshall(XMLDomainObject domainClass) throws InvalidXMLException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JAXBContext context = JAXBContext.newInstance(domainClass.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(domainClass, byteArrayOutputStream);
            return byteArrayOutputStream.toString();
        } catch (JAXBException e) {
            throw new InvalidXMLException(e.getMessage(),e);
        }
    }
}
