public class sudoku {

    private static final int TAMANHO_QUADRO = 9;

    public static void main(String[] args) {

        int[][] quadro = {

                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}

        };
        validarQuadro(quadro);

        if (validarQuadro(quadro)){
            System.out.println("Quadro resolvido");
        }
        else{
            System.out.println("Quadro pendente");
        }
        mostraQuadro(quadro);

    }
    private static void mostraQuadro(int[][] quadro) {
        for (int linha = 0; linha < TAMANHO_QUADRO; linha++){
            if (linha % 3 == 0 && linha != 0){
                System.out.println("----------");
            }

            for (int coluna = 0; coluna < TAMANHO_QUADRO; coluna++ ){
                if (coluna % 3 == 0 && coluna != 0){
                    System.out.print("|");
                }
                System.out.print(quadro[linha][coluna]);
            }
            System.out.println();
        }

    }

    private static boolean numeroLinha(int[][] quadro, int numero, int linha){
        for (int i = 0; i < TAMANHO_QUADRO; i++){
            if (quadro[linha][i] == numero){
                return true;
            }
        }
        return false;
    }

    private static boolean numeroColuna(int[][] quadro, int numero, int coluna){
        for (int i = 0; i < TAMANHO_QUADRO; i++){
            if (quadro[coluna][i] == numero){
                return true;
            }
        }
        return false;
    }

    private static boolean numeroQuadrante(int[][] quadro, int numero, int linha, int coluna){
       int LocalQuadranteLinha = linha - linha % 3;
       int LocalQuadranteColuna = coluna - coluna % 3;

       for (int i = LocalQuadranteLinha; i < LocalQuadranteLinha +3; i++){
           for (int j = LocalQuadranteColuna; j < LocalQuadranteColuna +3; j++){
               if (quadro[i][j] == numero){
                   return true;
               }
           }
       }
       return false;
    }

    private static boolean validarLocal (int[][] quadro, int numero, int linha, int coluna){
        return  !numeroLinha(quadro, numero, linha)&&
                !numeroColuna(quadro, numero, coluna)&&
                !numeroQuadrante(quadro, numero, linha, coluna );
    }

    private  static boolean validarQuadro(int[][] quadro){
        for (int linha = 0; linha < TAMANHO_QUADRO; linha++){
            for (int coluna = 0; coluna < TAMANHO_QUADRO; coluna++){
                if (quadro[linha][coluna] == 0){
                    for (int tentarNumero = 1; tentarNumero <= TAMANHO_QUADRO; tentarNumero++){
                        if(validarLocal(quadro, tentarNumero, linha, coluna)){
                            quadro[linha][coluna] = tentarNumero;

                           if (validarQuadro(quadro)){
                               return true;
                           }
                           else {
                               quadro[linha][coluna] = 0;
                           }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }
}