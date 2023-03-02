import java.io.FileOutputStream;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class creationJDOM {
	public static void main(String[] args) {
		try {
			// Root Element
			Element interfaces = new Element("interfaces");
			Document document = new Document(interfaces);

			// Auto Element for lo
			Element autoLo = new Element("auto");
			interfaces.addContent(autoLo);

			// Name Element for lo
			Element nameLo = new Element("name");
			nameLo.setAttribute(new Attribute("value", "lo"));
			autoLo.addContent(nameLo);

			// Iface Element for lo
			Element ifaceLo = new Element("iface");
			ifaceLo.setAttribute(new Attribute("name", "lo"));
			interfaces.addContent(ifaceLo);

			// Inet Element for lo
			Element inetLo = new Element("inet");
			ifaceLo.addContent(inetLo);

			// Loopback Element for lo
			Element loopback = new Element("loopback");
			inetLo.addContent(loopback);

			// Auto Element for eth0 and eth1
			Element autoEth0Eth1 = new Element("auto");
			interfaces.addContent(autoEth0Eth1);

			// Name Element for eth0
			Element nameEth0 = new Element("name");
			nameEth0.setAttribute(new Attribute("value", "eth0"));
			autoEth0Eth1.addContent(nameEth0);

			// Name Element for eth1
			Element nameEth1 = new Element("name");
			nameEth1.setAttribute(new Attribute("value", "eth1"));
			autoEth0Eth1.addContent(nameEth1);

			// Iface Element for eth0
			Element ifaceEth0 = new Element("iface");
			ifaceEth0.setAttribute(new Attribute("name", "eth0"));
			interfaces.addContent(ifaceEth0);

			// Inet Element for eth0
			Element inetEth0 = new Element("inet");
			ifaceEth0.addContent(inetEth0);

			// DHCP Element for eth0
			Element dhcp = new Element("dhcp");
			dhcp.setAttribute(new Attribute("hostname", "host1"));
			inetEth0.addContent(dhcp);

			// Iface Element for eth1
			Element ifaceEth1 = new Element("iface");
			ifaceEth1.setAttribute(new Attribute("name", "eth1"));
			interfaces.addContent(ifaceEth1);

			// Inet Element for eth1
			Element inetEth1 = new Element("inet");
			ifaceEth1.addContent(inetEth1);

			// Static Element for eth1
			Element staticEth1 = new Element("static");
			inetEth1.addContent(staticEth1);

			// Address Element for eth1
			Element addressEth1 = new Element("address");
			addressEth1.setText("147.127.18.49");
			staticEth1.addContent(addressEth1);

			// Netmask Element for eth1
			Element netmaskEth1 = new Element("netmask");
			netmaskEth1.setText("255.255.240.0");
			staticEth1.addContent(netmaskEth1);

			// Gateway Element for eth1
			Element gatewayEth1 = new Element("gateway");
			gatewayEth1.setText("147.127.18.200");
			staticEth1.addContent(gatewayEth1);

			// Output the XML
			XMLOutputter xmlOutputter = new XMLOutputter();
			xmlOutputter.setFormat(Format.getPrettyFormat());
			xmlOutputter.output(document, new FileOutputStream("interfaces.xml"));
			System.out.println(xmlOutputter.outputString(document));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
