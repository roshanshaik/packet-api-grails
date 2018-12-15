
import net.packet.client.PacketApiWrapper
import net.packet.api.PacketApiWithoutSDK

class BootStrap {

    def init = { servletContext ->
		
		log.error "test"
		//def packetApi = new PacketApiWrapper()
		//packetApi.testCreateDevice()
		new PacketApiWithoutSDK()
		
		
    }
    def destroy = {
    }
}
