package br.ufrpe.bugzilla.negocio.beans;
import br.ufrpe.bugzilla.negocio.beans.Local;

public abstract class CalculaDistancia {

	public static final int RAIO_TERRA_KM = 6371;
	//fonte: http://en.wikipedia.org/wiki/Earth_radius
	
	//utiliza coordenadas geográficas pra definir a distância em km
	public static double DistanciaGeoEmKm(Local cidade1, Local cidade2) {

		//local de origem
		double latitude1 = cidade1.getLatitude();
		double longitude1 = cidade1.getLongitude();
		//local de destino
		double latitude2 = cidade2.getLatitude();
		double longitude2 = cidade2.getLongitude();
		
		// Conversão de graus pra radianos das latitudes
		double LatPraRad1 = Math.toRadians(latitude1);
		double LatPraRad2 = Math.toRadians(latitude2);

		// Diferença das longitudes
		double deltaLongitudeEmRad = Math.toRadians(longitude2
				- longitude1);

		// Calculo da distância entre os pontos
		return Math.acos(Math.cos(LatPraRad1) * Math.cos(LatPraRad2)
				* Math.cos(deltaLongitudeEmRad) + Math.sin(LatPraRad1)
				* Math.sin(LatPraRad2))
				* RAIO_TERRA_KM;
	}
	
	/*public static void main(String[] args) {
		
		Local l1 = new Local("Rio",-22.5410,-43.1227);
		Local l2 = new Local("Porto Alegre",-30.0159, -51.1348);
		
		int distancia = (int) DistanciaGeoEmKm(l1,l2);
		System.out.println("Distancia do Rio para Porto Alegre: " + String.format("%dkm", distancia));
	}*/
}
