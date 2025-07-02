import java.util.Scanner; 
public class JogoDaVelha {

    public static int[] menu(){
        int[] posicao = new int [2];
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Linha: ");
        posicao[0] = scanner.nextInt();
        while (posicao[0] < 1 || posicao[0] > 3){
            System.out.print("Opcao invalida!\nInforme a linha: ");
            posicao[0] = scanner.nextInt();
        }
        System.out.print("Coluna: ");
        posicao[1] = scanner.nextInt();
        while (posicao[1] < 1 || posicao[1] > 3){
            System.out.print("Opcao invalida!\nInforme a coluna: ");
             posicao[1] = scanner.nextInt();
        }
        return posicao; 
    }        

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); 
        
        char [][] tabuleiro = {
        {' ',' ',' '},
        {' ',' ',' '},
        {' ',' ',' '}
        };

        char [] vitoriaX = {'X', 'X', 'X'};
        char [] vitoriaO = {'O', 'O', 'O'};

        boolean continuar = true;
        int rodada = 1;
        int jogador = 0 ;
        int i;
        int y;
        char []somaDiagonalPrincipal = new char [3];
        char []somaDiagonalSecundaria = new char [3];
        char []somaLinha =  new char [3];
        char []somaColuna =  new char [3];

        while (continuar = true){
            System.out.println("=====Jogo Iniciado!=====");
            System.out.println("========Rodada "+rodada+"========");
            rodada++;
            for (i=0; i<3; i++){
               for (y = 0; y < 3; y++) {
               System.out.print("\t"+tabuleiro[i][y]+"|");
               }
               System.out.println(" ");
            }           

            for(i = 0; i <= 9; i++){
                jogador++;
                if(jogador % 2 == 0){
                    jogador = 2;
                } else {
                    jogador = 1;
                }
                System.out.println("E a vez do jogador "+jogador+"!");

                int posicao[] = menu();

                 while (tabuleiro[(posicao[0]-1)][(posicao[1]-1)] == 'X' || tabuleiro[(posicao[0]-1)][(posicao[1]-1)] == 'O'){
                    System.out.println("Posicao invalida");
                    posicao = menu();
                }

                if(jogador == 1){
                    tabuleiro[(posicao[0]-1)][(posicao[1]-1)] = 'X';
                } else {
                    tabuleiro[(posicao[0]-1)][(posicao[1]-1)] = 'O';
                }

                for (i=0; i<3; i++){
                   for ( y = 0; y < 3; y++) {
                   System.out.print("\t"+tabuleiro[i][y]+"|");
                   }
                   System.out.println(" ");
                } 


            for (i=0; i<3; i++){
                for(y=0; y<3; y++){
                    if (i == y){
                        somaDiagonalPrincipal[i] = tabuleiro[i][y];
                    }
                }
            }
            for (i=0; i<3; i++){
                y = 3 - 1 - i;
                somaDiagonalSecundaria[i] = tabuleiro[i][y];
            }
            for ( i=0; i<3; i++){
                for ( y = 0; y < 3; y++) {
                    somaLinha[i] = tabuleiro[i][y];
                }
            }
            for ( y=0; y<3; y++){
                for ( i = 0; i < 3; i++) {
                    somaColuna[i] = tabuleiro[i][y];
                }
            }

            if (somaDiagonalSecundaria == vitoriaX || somaDiagonalSecundaria == vitoriaO ||
            somaDiagonalPrincipal == vitoriaX  || somaDiagonalPrincipal == vitoriaO){
                System.out.println("Jogador "+jogador+" venceu!");
                break;
                }

                }
            }

  } 


}

    







    