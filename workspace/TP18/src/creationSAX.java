import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class creationSAX {
    public static void main(String[] args) {
        try {
            List<String[]> lines = new ArrayList<>();
            lines.add(new String[]{"auto", "lo"});
            lines.add(new String[]{"iface", "lo", "inet", "loopback"});
            lines.add(new String[]{"auto", "eth0", "eth1"});
            lines.add(new String[]{"iface", "eth0", "inet", "dhcp"});
            lines.add(new String[]{"iface", "eth1", "inet", "static", "address", "147.127.18.49"});
            lines.add(new String[]{"netmask", "255.255.240.0"});
            lines.add(new String[]{"gateway", "147.127.18.200"});

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                private Element interfaces = null;
                private Element auto = null;
                private Element iface = null;
                private Element inet = null;
                private Element address = null;
                private Element netmask = null;
                private Element gateway = null;

                @Override
                public void startDocument() throws SAXException {
                    interfaces = new Element("interfaces");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    switch (qName) {
                        case "auto":
                            auto = new Element("auto");
                            interfaces.addContent(auto);
                            break;
                        case "iface":
                            iface = new Element("iface");
                            iface.setAttribute("name", attributes.getValue("value"));
                            interfaces.addContent(iface);
                            break;
                        case "inet":
                            inet = new Element("inet");
                            iface.addContent(inet);
                            break;
                        case "address":
                            address = new Element("address");
                            address.addContent(attributes.getValue("value"));
                            inet.addContent(address);
                            break;
                        case "netmask":
                            netmask = new Element("netmask");
                            netmask.addContent(attributes.getValue("value"));
                            inet.addContent(netmask);
                            break;
                        case "gateway":
                            gateway = new Element("gateway");
                            gateway.addContent(attributes.getValue("value"));
                            inet.addContent(inet.addContent(gateway));
                            break;
                        case "loopback":
                            Element loopback = new Element("loopback");
                            inet.addContent(loopback);
                            break;
                        case "dhcp":
                            Element dhcp = new Element("dhcp");
                            dhcp.setAttribute("hostname", attributes.getValue("hostname"));
                            inet.addContent(dhcp);
                            break;
                    }
                }

                @Override
                public void endDocument() throws SAXException {
                    try {
                        FileWriter writer = new FileWriter("interfaces2.xml");
                        XMLOutputter xmlOutput = new XMLOutputter();
                        xmlOutput.setFormat(Format.getPrettyFormat());
                        xmlOutput.output(interfaces, writer);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            for (String[] line : lines) {
                saxParser.parse(line[0], handler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

