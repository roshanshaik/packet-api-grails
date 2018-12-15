
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse

import groovy.json.JsonSlurper

/**
 * 
 * Wrapper Controller for Packet API
 * 
 * 
 * @author rshaik
 *
 */

class PacketTestController {

	def baseUrl = "https://api.packet.net"
	def authToken = "REkpnDkh7iBtdvZHoZjv32gaiWwj1g6c";
	def projectId = "ca73364c-6023-4935-9137-2132e73c20b4"
	//def authToken = "3LHdqvFK7c7zPf7beWSPMYZdMWJ4j1sh";

	/**
	 * createDevice
	 * 
	 * @return
	 */
	
	def createDevice()  {
		log.info " creating device  "

		RestBuilder rest = new RestBuilder()
		RestResponse restResponse = rest.post(baseUrl+'/projects/' + projectId + '/devices') {

			header 'X-Auth-Token', authToken
			json {
				facility = ["sjc1", "ewr1", "dfw2", "any"]
				plan = "c1.small.x86"
				hostname = "MyTestDevice"
				description = "MyTestDevice"
				operating_system = "centos_7"
			}
		}

		if ( restResponse.statusCode.value() == 200 && restResponse.json ) {
			System.out.println("response " +  restResponse.json);
		}

		log.info " creating device restResponse = " + restResponse
		
		render restResponse.json


	}

	/**
	 * deleteDevice - pass an id as param 
	 * @return
	 */

	def deleteDevice()  {
		RestBuilder rest = new RestBuilder()
		RestResponse restResponse = rest.delete(baseUrl+'/devices/' + params.id) {
			header 'X-Auth-Token', authToken
		}

		if ( restResponse.statusCode.value() == 200 && restResponse.json ) {
			log.info "response " +  restResponse.json
		}

		render restResponse.json

	}
	
	/**
	 * 
	 * getDevice - pass an id as param 
	 * 
	 * @return
	 */
	
	def getDevice()  {
		RestBuilder rest = new RestBuilder()
		RestResponse restResponse = rest.get(baseUrl+'/devices/' + params.id) {
			header 'X-Auth-Token', authToken
		}

		if ( restResponse.statusCode.value() == 200 && restResponse.json ) {
			log.info "response " +  restResponse.json
		}

		render restResponse.json

	}
	
	/**
	 * create an Organization
	 * 
	 * @return
	 */
	
	def createOrg() {
		RestBuilder rest = new RestBuilder()
		RestResponse restResponse = rest.post(baseUrl+'/organizations') {

			header 'X-Auth-Token', authToken
			json {
				name = "string"
				description = "string"
				website = "string"
				twitter = "string"
				logo = "string"
				address = "address"
				billing_address = "Address"
				customdata = "string"
				enforce_2fa_at = "string"
			}
		}

		if ( restResponse.statusCode.value() == 200 && restResponse.json ) {
			System.out.println("response " +  restResponse.json);
		}

		render restResponse.json
	}
}
