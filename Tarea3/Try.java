

public class Try {
    enum departamento {
        MATEMATICA(7), HUMANISTA(2), INFORMATICA(5);

        int creditosRamo;

        departamento(int c) {
            this.creditosRamo = c;
        }
    }
    public static void main(String[] args){
        for (departamento d : departamento.values()){
            System.out.println("El departamento "+d+" tiene "+d.creditosRamo+" creditos");
        }

        
    }
}
