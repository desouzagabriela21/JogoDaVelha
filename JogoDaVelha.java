import java.util.Scanner; 
import java.util.Arrays;

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
        char []somaLinha1 =  new char [3];
        char []somaLinha2 =  new char [3];
        char []somaLinha3 =  new char [3];
        char []somaColuna1 =  new char [3];
        char []somaColuna2 =  new char [3];
        char []somaColuna3 =  new char [3];


        while (continuar == true){
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
                    somaLinha1[i] = tabuleiro[0][y];
                    somaLinha2[i] = tabuleiro[1][y];
                    somaLinha3[i] = tabuleiro[2][y];
                }
            }
            for ( y=0; y<3; y++){{
            somaColuna1[y] = tabuleiro[y][0];
            somaColuna2[y] = tabuleiro[y][1];
            somaColuna3[y] = tabuleiro[y][2];         
                }


            }

           if (Arrays.equals(somaColuna1, vitoriaX) || Arrays.equals(somaColuna1, vitoriaO)
           || Arrays.equals(somaColuna2, vitoriaX) || Arrays.equals(somaColuna2, vitoriaO)
          || Arrays.equals(somaColuna3, vitoriaX) || Arrays.equals(somaColuna3, vitoriaO)
            || Arrays.equals(somaLinha1, vitoriaX) || Arrays.equals(somaLinha1, vitoriaO)
            || Arrays.equals(somaLinha2, vitoriaX) || Arrays.equals(somaLinha2, vitoriaO)
            || Arrays.equals(somaLinha3, vitoriaX) || Arrays.equals(somaLinha3, vitoriaO)
            || Arrays.equals(somaDiagonalPrincipal, vitoriaX) || Arrays.equals(somaDiagonalPrincipal, vitoriaO)
            || Arrays.equals(somaDiagonalSecundaria, vitoriaX) || Arrays.equals(somaDiagonalSecundaria, vitoriaO)
            ){
                System.out.println("O jogador "+jogador+" VENCEU!");

            }
            
            
            

            
                
                
               

                }
            }

  } 


}
