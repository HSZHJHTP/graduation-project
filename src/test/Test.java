package test;

import java.util.Enumeration;

import gnu.io.CommPortIdentifier;

public class Test {
	private static final String portChoice = null;

	public void listPortChoices() {
		CommPortIdentifier portId;
		Enumeration en = CommPortIdentifier.getPortIdentifiers();
	// iterate through the ports.
	while (en.hasMoreElements()) {
	 portId = (CommPortIdentifier) en.nextElement();
	if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
		System.out.println(portId.getName());
}
	 portChoice.select(parameters.getPortName());
		        }
}
