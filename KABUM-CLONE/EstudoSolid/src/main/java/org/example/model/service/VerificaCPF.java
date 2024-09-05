package org.example.model.service;

//OQUE ESSA CLASSE FAZ, ESTÁ EXTREMAMENTE DIFICIL DE COMPREENSÃO POR BURRICE MINHA
//MAS POR HORA PODEMOS USAR ELE JÁ QUE FAZ OQUE É PROMETIDO =D
public class VerificaCPF
{

    public static boolean verificaCPF(String CpfOriginal){
        int[] cpfFormatado =  formataroCPForiginal(CpfOriginal);
        int[] CpfDigitoCriado = cpfArraySomaSegundoDigito(primeiroDigito(CpfOriginal));
        if(cpfFormatado[cpfFormatado.length - 1] == CpfDigitoCriado[CpfDigitoCriado.length - 1]
                && cpfFormatado[cpfFormatado.length - 2] == CpfDigitoCriado[CpfDigitoCriado.length - 2]
        ){
            return true;
        }
        return false;
    }

    private static String arrayToString(String cpf){
        int[] cpfArray = formataroCPForiginal(cpf);
        String respString = "";
        for (int a = 0; a < cpfArray.length; a++) {
            respString += String.valueOf(cpfArray[a]);
        }
        return respString;
    }


    private static int[] formataroCPForiginal(String cpf){
        int[] cpfArray = new int[11];
        int pointer = 0;
        for (int i = 0; i < 14 ; i++) {
            try {
                String aux2 = String.valueOf(cpf.charAt(i));

                if(aux2 != "." || aux2 != "-"){
                    int aux = Integer.parseInt(String.valueOf(aux2));
                    if (aux == 0 || aux == 1 || aux == 2 || aux == 3 || aux == 4 || aux == 5
                            || aux == 6 || aux == 7 || aux == 8 || aux == 9
                    ) {
                        cpfArray[pointer] = aux;
                        pointer++;
                    }
                }


            } catch (Exception e) {

            }
        }
        return cpfArray;
    }

    private static int[] primeiroDigito(String cpfOriginal){
        int[]cpf = formatarParaCPFsemDigito(cpfOriginal);
        int cpfArraySoma = cpfArraySomaPrimeiroDigito(cpf);
        int digito = 0;
        if(cpfArraySoma % 11 < 2){
            digito = 0;
        }else {
            int a = cpfArraySoma % 11;
            digito = 11 - a;
        }
        int[] cpfNovo = new int[10];
        for (int i = 0; i < cpf.length; i++) {
            cpfNovo[i] = cpf[i];

        }
        cpfNovo[cpfNovo.length - 1] = digito;

        return cpfNovo;
    }


    private static int[] formatarParaCPFsemDigito(String cpf){
        int[] cpfArray = new int[9];
        int pointer = 0;
        for (int i = 0; i < 12 ; i++) {
            try {
                String aux2 = String.valueOf(cpf.charAt(i));

                if(aux2 != "." || aux2 != "-"){
                    int aux = Integer.parseInt(String.valueOf(aux2));
                    if (aux == 0 || aux == 1 || aux == 2 || aux == 3 || aux == 4 || aux == 5
                            || aux == 6 || aux == 7 || aux == 8 || aux == 9
                    ) {
                        cpfArray[pointer] = aux;
                        pointer++;
                    }
                }

            } catch (Exception e) {

            }
        }
        return cpfArray;
    }

    private static int cpfArraySomaPrimeiroDigito(int[] array){
        int mult = 10;
        int soma = 0;
        int aux = 0;
        for (int i = 0 ; i < array.length ; i++) {
            aux = array[i] * mult;
            soma = aux + soma;
            mult--;
        }
        return soma;
    }

    private static int[] cpfArraySomaSegundoDigito(int[] cpf){
        int mult = 11;
        int soma = 0;
        for (int i = 0 ; i < cpf.length ; i++) {
            soma += cpf[i] * mult;
            mult--;
        }
        int digito = 0;
        int[] cpfNovo = new int[11];
        for (int i = 0; i < cpf.length ; i++) {
            cpfNovo[i] = cpf[i];
        }
        if(soma % 11 < 2 ){
            cpfNovo[cpfNovo.length - 1] = digito;
        }else {
            int a = soma % 11;
            digito = 11 - a;
            cpfNovo[cpfNovo.length - 1] =digito;
        }
        return cpfNovo;
    }
}