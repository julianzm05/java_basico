import java.util.Arrays; 
public class PracticaRecurencia{
	private static int[] valorMonedas;
	private static int[] monedas;
	public static void main (String [] args) {
		//El valor de la monedas debe estar ordenado ascendentemente
		valorMonedas=new int[3];
		valorMonedas[0]=1;
		valorMonedas[1]=3;
		valorMonedas[2]=5;
		monedas=new int[3];
		darCambio(16);
		for(int i=0;i<valorMonedas.length;i++){
			System.out.println(String.format("%s Monedas de %s",monedas[i],valorMonedas[i]));
		}
    }
	
	public static void darCambio(int cambio){
		//Resuelve casos base
		
		for(int i=0;i<valorMonedas.length;i++){
			if(valorMonedas[i]==cambio){
				monedas[i]+=1;
				return;
			}
		}
		darCambio(cambio-1);
		monedas[0]+=1;
		updateMonedas();
	}
	public static void updateMonedas (){
		int suma;
		int j;
		for(int i=0;i<monedas.length;i++){
			j=i-1;
			suma=0;
			while(j>-1){
				suma+=valorMonedas[j]*monedas[j];
				j--;
			}
			if(suma==valorMonedas[i]){
				monedas[i]+=1;
				j=i-1;
				while(j>-1){
					monedas[j]=0;
					j--;
				}
			}
		}
	}
	
}