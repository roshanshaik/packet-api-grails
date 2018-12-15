/**
 * 
 */
package net.packet.client;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import net.packet.impl.PacketClient;

import net.packet.BillingCycle;
import net.packet.Constants;
import net.packet.MetricInterval;
import net.packet.Packet;
import net.packet.TrafficBucket;
import net.packet.TrafficDirection;
import net.packet.exception.PacketException;
import net.packet.pojo.Device;
import net.packet.pojo.Devices;
import net.packet.pojo.Email;
import net.packet.pojo.Event;
import net.packet.pojo.Events;
import net.packet.pojo.Facilities;
import net.packet.pojo.Facility;
import net.packet.pojo.Invitation;
import net.packet.pojo.IpAddress;
import net.packet.pojo.IpAddresses;
import net.packet.pojo.Membership;
import net.packet.pojo.Metrics;
import net.packet.pojo.Notification;
import net.packet.pojo.Notifications;
import net.packet.pojo.OperatingSystem;
import net.packet.pojo.OperatingSystems;
import net.packet.pojo.Plan;
import net.packet.pojo.Plans;
import net.packet.pojo.Project;
import net.packet.pojo.Projects;
import net.packet.pojo.ReserveIpAddress;
import net.packet.pojo.SshKey;
import net.packet.pojo.SshKeys;
import net.packet.pojo.Transfer;
import net.packet.pojo.User;
import net.packet.pojo.Users;

/**
 * @author rshaik
 *
 */
public class PacketApiWrapper {
	
	
	//private static final Logger log = LoggerFactory.getLogger(PacketIntegrationTest.class);

	  //private String authToken = "REkpnDkh7iBtdvZHoZjv32gaiWwj1g6c";
	  private String authToken = "3LHdqvFK7c7zPf7beWSPMYZdMWJ4j1sh";
	  private String version = "1";
	  private Packet apiClient;

	  
	  public PacketApiWrapper() {
		  
		CloseableHttpClient httpClient = HttpClients.createDefault();
	    this.apiClient = new PacketClient(authToken, version, httpClient);
	  }
	  
	  public void testCreateDevice() throws PacketException {
		  
		  
		    Device device = new Device(
		        "web1.sample.com",
		        new Plan("baremetal_0"),
		        BillingCycle.fromValue("hourly"),
		        new OperatingSystem("debian_8"),
		        new Facility("ewr1"));

		    device.setTags(Arrays.asList("api client create"));

		    Device result = apiClient.createDevice("478a943f-9134-4c45-a664-6a8e7f2ff17c", device);
		    //assertNotNull(result);

		    System.out.println("Device " + result);
		    
		    Boolean result1 = apiClient.deleteDevice("478a943f-9134-4c45-a664-6a8e7f2ff17c");
		    
		    System.out.println("Delete Device " + result1);
		    
		    
	  }
	  
	  
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PacketApiWrapper testPacket = new PacketApiWrapper();
		
		try {
			testPacket.testCreateDevice();
		} catch (PacketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}



