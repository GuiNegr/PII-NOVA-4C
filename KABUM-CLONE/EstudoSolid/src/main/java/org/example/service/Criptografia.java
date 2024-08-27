package org.example.service;

public class Criptografia {

        private static final char[] alfaUpperCase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        private static final char[] alfaLowerCase = {'a','b','c','d','e','f','g','h','i',
                'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
        };

        private static final char[] numeric ={'0','1','2','3','4','5','6','7','8','9'};

        public static String instCod(String cod) {

            String aux = "";
            for (int i = 0; i < cod.length(); i++) {
                char help = cod.charAt(i);
                if (help == 'X') {
                    aux += 'A';
                } else if (help == 'Y') {
                    aux += 'B';
                } else if (help == 'Z') {
                    aux += 'C';
                } else if (help == ' ') {
                    aux += ' ';
                } else if (help == 'a') {
                    aux += 'x';
                } else if (help == 'b') {
                    aux += 'y';
                } else if (help == 'c') {
                    aux += 'z';
                }else if(help == '9'){
                    aux+= '0';
                }else if(help == '8'){
                    aux+= '1';
                } else if (help == '7') {
                    aux += '2';
                } else {
                    for (int j = 0; j < alfaUpperCase.length; j++) {
                        if (help == alfaUpperCase[j]) {
                            int a = j + 3;
                            help = alfaUpperCase[a];
                            break;
                        }
                        if (help == alfaLowerCase[j]) {
                            int a = j + 3;
                            help = alfaLowerCase[a];
                            break;
                        }
                    }
                    for(int a = 0; a < numeric.length;a++){
                        if (help == numeric[a]) {
                            int b = a + 3;
                            help = numeric[b];
                            break;
                        }
                    }
                    aux += help;
                }
            }
            return aux;
        }


        public static String isdecodding(String descod) {
            String aux = "";
            for (int i = 0; i < descod.length(); i++) {
                char help = descod.charAt(i);
                if (help == 'A') {
                    aux += 'X';
                } else if (help == 'B') {
                    aux += 'Y';
                } else if (help == 'C') {
                    aux += 'Z';
                } else if (help == ' ') {
                    aux += ' ';
                } else if (help == 'a') {
                    aux += 'x';
                } else if (help == 'b') {
                    aux += 'y';
                } else if (help == 'c') {
                    aux += 'z';
                } else if(help == '0'){
                    aux+= '9';
                }else if(help == '1'){
                    aux+= '8';
                } else if (help == '2') {
                    aux += '7';
                } else {
                    for (int j = 3; j < alfaUpperCase.length; j++) {
                        if (help == alfaUpperCase[j]) {
                            int a = j - 3;
                            help = alfaUpperCase[a];
                            break;
                        }
                        else if (help == alfaLowerCase[j]) {
                            int a = j - 3;
                            help = alfaLowerCase[a];
                            break;
                        }
                    }
                    for(int a = 0; a < numeric.length;a++){
                        if (help == numeric[a]) {
                            int b = a - 3;
                            help = numeric[b];
                            break;
                        }
                    }
                    aux += help;
                }
            }
            return aux;
        }
    }
