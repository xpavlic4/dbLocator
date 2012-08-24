package at.focusmr.dblocator.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Value object for list of {@link TnsNameXml}.
 */
@XmlRootElement(name = "tnmNames")
public class TnsNamesXml {
    @XmlElement(name = "tnmName")
    List<TnsNameXml> l = new LinkedList<TnsNameXml>();

    public void add(TnsNameXml xml) {
        l.add(xml);
    }

}
