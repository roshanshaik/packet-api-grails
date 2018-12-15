/**
 * 
 */
package net.packet.api


import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse

/**
 * @author rshaik
 *
 */
class PacketApiWithoutSDK {

	public void testCreateDeviceWithoutSDK()  {
		
		log.info " testCreateDeviceWithoutSDK() "
		  
		  RestBuilder rest = new RestBuilder()
	        String url = "http://api.openweathermap.org/data/2.5/weather?q={city},{countryCode}&appid={appid}"
	        Map params = [city: "Fremont", countryCode: "US", appid: "test"]
	        String unitParam = unitParameter(unit)
	        if ( unitParam ) {
	            params.units = unitParam
	            url += "&units={units}"
	        }
			
	        RestResponse restResponse = rest.get(url) { 
	            urlVariables params
	        }

			log.info " testCreateDeviceWithoutSDK() restResponse = " + restResponse
			
	        if ( restResponse.statusCode.value() == 200 && restResponse.json ) {
	        	System.out.println("response " +  OpenweathermapParser.currentWeatherFromJSONElement(restResponse.json) );
	        }
	        
		  
		  
		  
	  }

}
