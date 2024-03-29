/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qubic;

import java.util.ArrayList; 

/**
 *
 * @author User
 */
public class Cube3 implements Cube{
        //prvi indeks oznacava nivo, drugi redak i treći stupac
        private char[][][] cube = new char[3][3][3];
        
        //broj odigranih poteza <=> broj znakova igraca na tabli
        private int mNumber;

        //provjerava postoji li cetvorka za pobjedu ako da true, ako ne false
        private char winning_line()
        {
            //najprije po levelima provjerimo dobitke u horizontalnom polozaju =24slučajeva
            for(int i=0;i<3;i++){
                //provjera po redcima
                for(int j=0;j<3;j++){
                    if(cube[i][j][0]!=' ' && cube[i][j][0]==cube[i][j][1] && cube[i][j][1]==cube[i][j][2]) return cube[i][j][0];
                }
                //provjera po stupcima
                for(int j=0;j<3;j++){
                    if(cube[i][0][j]!=' ' && cube[i][0][j]==cube[i][1][j] && cube[i][1][j]==cube[i][2][j]) return cube[i][0][j];
                }
                //provjera dvije dijagonale
                if(cube[i][0][0]!=' ' && cube[i][0][0]==cube[i][1][1] && cube[i][1][1]==cube[i][2][2]) return cube[i][0][0];
                if(cube[i][0][2]!=' ' && cube[i][0][2]==cube[i][1][1] && cube[i][1][1]==cube[i][2][0]) return cube[i][0][2];
            }

            //za vertikalne netrebam provjeravat horizontalne jer to vec jesmo =15
            for(int i=0;i<3;i++){
                //provjera po stupcima
                for(int j=0;j<3;j++){
                    if(cube[0][j][i]!=' ' && cube[0][j][i]==cube[1][j][i] && cube[1][j][i]==cube[2][j][i]) return cube[0][j][i];
                }
                //provjera dvije dijagonale
                if(cube[0][0][i]!=' ' && cube[0][0][i]==cube[1][1][i] && cube[1][1][i]==cube[2][2][i]) return cube[0][0][i];
                if(cube[0][2][i]!=' ' && cube[0][2][i]==cube[1][1][i] && cube[1][1][i]==cube[2][0][i]) return cube[0][2][i];
            }
            //fale mi dijagonale po redcima =6
            for(int i=0;i<3;i++){
                if(cube[0][i][0]!=' ' && cube[0][i][0]==cube[1][i][1] && cube[1][i][1]==cube[2][i][2]) return cube[0][i][0];
                if(cube[0][i][2]!=' ' && cube[0][i][2]==cube[1][i][1] && cube[1][i][1]==cube[2][i][0]) return cube[0][i][2];
            }
            //unutrasnje dijagonale =4
            if(cube[0][0][0]!=' ' && cube[0][0][0]==cube[2][2][2] && cube[2][2][2]==cube[1][1][1]) return cube[0][0][0];
            if(cube[0][0][2]!=' ' && cube[0][0][2]==cube[1][1][1] && cube[1][1][1]==cube[2][2][0]) return cube[0][0][2];
            if(cube[0][2][2]!=' ' && cube[0][2][2]==cube[1][1][1] && cube[1][1][1]==cube[2][0][0]) return cube[0][2][2];
            if(cube[0][2][0]!=' ' && cube[0][2][0]==cube[1][1][1] && cube[1][1][1]==cube[2][0][2]) return cube[0][2][0];

            return ' ';
        }
        
        //konstruktor stvara kocku spremnu za igru
        public Cube3()
        {
            clear();
        }
        
        public Cube3(int number, char[][][] old)
        {
            mNumber=number;
            for(int i=0; i<3; i++)
                for(int j=0; j<3; j++)
                    for(int k=0; k<3; k++)
                        cube[i][j][k]= old[i][j][k];
        }
        //cisti kocku
        @Override
        public void clear()
        {
            mNumber=0;
            for(int i=0; i<3; i++)
                for(int j=0; j<3; j++)
                    for(int k=0; k<3; k++)
                        cube[i][j][k]=' ';
        }
        //vraca vrijednost koja se nalazi na poziciji (i,j,k)
        @Override
        public char value(int i, int j, int k)
        {
            return cube[i][j][k];
        }
        
        //ako je završno stanje vraća vrijednost inače ništa
        @Override
        public Integer result()
        {
            char winner=winning_line();
            if(winner=='X') return 500;
            if(winner=='O') return -500; 
            if(mNumber>=27) return 0;
            return null;
        }
        //ova funkcija generira sve moguće poteze na tabli, sprema ih u vektor
        @Override
        public ArrayList<Move> generate_moves()
        {
            ArrayList<Move> moves = new ArrayList<Move>();
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    for(int k=0;k<3;k++){
                        if(cube[i][j][k]==' '){
                            moves.add( new Move(i,j,k) );
                        }
                    }
                }
            }
            return moves;
        }
        
        //provjerava jeli potez valjan4
        public boolean isValid(Move move)
        {
            if(move.level()<0 || move.level()>2) return false;
            if(move.row()<0 || move.row()>2) return false;
            if(move.column()<0 || move.column()>2) return false;
            if(value(move.level(),move.row(),move.column())!=' ') return false;
            return true;
        }
        
        //odigra potez Move sa znakom char
        @Override
        public boolean play(Move move,char c)
        {
            if(!isValid(move)) return false;
            cube[move.level()][move.row()][move.column()] = c;
            mNumber++;
            return true;
        }
        
        //odigra potez unazad
        @Override
        public void unPlay(Move move)
        {
            if(cube[move.level()][move.row()][move.column()] != ' '){
                cube[move.level()][move.row()][move.column()] = ' ';
                mNumber--;
            }
        }
        //heuristicka funkcija: 
        //prvi char = player, drugi char = opponent
        //svi slucajevi uz uvijete da je samo jedna vrsta oznaka u lineu:
        //ako player ima 2 u redu onda +4 boda
        //ako player ima 1 u redu onda +2 boda
        //ako opponent ima 2 u redu onda -3 boda
        //ako opponent ima 1 u redu onda -1 boda
        @Override
        public int heuristic(char player,char opponent)
        {
            //idem po svim winning lines i brojim koliko se znakova ukupno nalazi nasih i protivnikovih
            int result=0;
            for(int i=0;i<3;i++){
                //provjera po redcima
                for(int j=0;j<3;j++){
                    int broj_pl=0;
                    int broj_op=0;
                    for(int k=0;k<3;k++){
                        if(cube[i][j][k]==player) broj_pl++;
                        if(cube[i][j][k]==opponent) broj_op++;
                    }
                    if(broj_pl>0 && broj_op==0){
                        if(broj_pl==1) result+=2;
                        else if(broj_pl==2) result+=4;
                    }
                    else if(broj_pl==0 && broj_op>0){
                        if(broj_op==1) result-=1;
                        else if(broj_op==2) result-=3;
                    }
                }
                //provjera po stupcima
                for(int j=0;j<3;j++){
                    int broj_pl=0;
                    int broj_op=0;
                    for(int k=0;k<3;k++){
                        if(cube[i][k][j]==player) broj_pl++;
                        if(cube[i][k][j]==opponent) broj_op++;
                    }
                    if(broj_pl>0 && broj_op==0){
                        if(broj_pl==1) result+=2;
                        else if(broj_pl==2) result+=4;
                    }
                    else if(broj_pl==0 && broj_op>0){
                        if(broj_op==1) result-=1;
                        else if(broj_op==2) result-=3;
                    }
                }
                //provjera dvije dijagonale
                int broj_pl=0;
                int broj_op=0;
                for(int k=0;k<3;k++){
                    if(cube[i][k][k]==player) broj_pl++;
                    if(cube[i][k][k]==opponent) broj_op++;
                }
                if(broj_pl>0 && broj_op==0){
                    if(broj_pl==1) result+=2;
                    else if(broj_pl==2) result+=4;
                }
                else if(broj_pl==0 && broj_op>0){
                    if(broj_op==1) result-=1;
                    else if(broj_op==2) result-=3;
                }
                broj_pl=0;
                broj_op=0;
                for(int k=0;k<3;k++){
                    if(cube[i][k][2-k]==player) broj_pl++;
                    if(cube[i][k][2-k]==opponent) broj_op++;
                }
                if(broj_pl>0 && broj_op==0){
                    if(broj_pl==1) result+=2;
                    else if(broj_pl==2) result+=4;
                }
                else if(broj_pl==0 && broj_op>0){
                    if(broj_op==1) result-=1;
                    else if(broj_op==2) result-=3;
                }
            }
            //za vertikalne netrebam provjeravat horizontalne jer to vec jesmo
            for(int i=0;i<3;i++){
                //provjera po stupcima
                for(int j=0;j<3;j++){
                    int broj_pl=0;
                    int broj_op=0;
                    for(int k=0;k<3;k++){
                        if(cube[k][j][i]==player) broj_pl++;
                        if(cube[k][j][i]==opponent) broj_op++;
                    }
                    if(broj_pl>0 && broj_op==0){
                        if(broj_pl==1) result+=2;
                        else if(broj_pl==2) result+=4;
                    }
                    else if(broj_pl==0 && broj_op>0){
                        if(broj_op==1) result-=1;
                        else if(broj_op==2) result-=3;
                    }
                }
                //provjera dvije dijagonale
                int broj_pl=0;
                int broj_op=0;
                for(int k=0;k<3;k++){
                    if(cube[k][k][i]==player) broj_pl++;
                    if(cube[k][k][i]==opponent) broj_op++;
                }
                if(broj_pl>0 && broj_op==0){
                    if(broj_pl==1) result+=2;
                    else if(broj_pl==2) result+=4;
                }
                else if(broj_pl==0 && broj_op>0){
                    if(broj_op==1) result-=1;
                    else if(broj_op==2) result-=3;
                }
                broj_pl=0;
                broj_op=0;
                for(int k=0;k<3;k++){
                    if(cube[k][2-k][i]==player) broj_pl++;
                    if(cube[k][2-k][i]==opponent) broj_op++;
                }
                if(broj_pl>0 && broj_op==0){
                    if(broj_pl==1) result+=2;
                    else if(broj_pl==2) result+=4;
                }
                else if(broj_pl==0 && broj_op>0){
                    if(broj_op==1) result-=1;
                    else if(broj_op==2) result-=3;
                }
            }
            //fale mi dijagonale po redcima
            for(int i=0;i<3;i++){
                int broj_pl=0;
                int broj_op=0;
                for(int k=0;k<3;k++){
                    if(cube[k][i][k]==player) broj_pl++;
                    if(cube[k][i][k]==opponent) broj_op++;
                }
                if(broj_pl>0 && broj_op==0){
                    if(broj_pl==1) result+=2;
                    else if(broj_pl==2) result+=4;
                }
                else if(broj_pl==0 && broj_op>0){
                    if(broj_op==1) result-=1;
                    else if(broj_op==2) result-=3;
                }
                broj_pl=0;
                broj_op=0;
                for(int k=0;k<3;k++){
                    if(cube[k][i][2-k]==player) broj_pl++;
                    if(cube[k][i][2-k]==opponent) broj_op++;
                }
                if(broj_pl>0 && broj_op==0){
                    if(broj_pl==1) result+=2;
                    else if(broj_pl==2) result+=4;
                }
                else if(broj_pl==0 && broj_op>0){
                    if(broj_op==1) result-=1;
                    else if(broj_op==2) result-=3;
                }
            }
            //unutarnje dijagonale
            int broj_pl=0;
            int broj_op=0;
            for(int i=0;i<3;i++){
                if(cube[i][i][i]==player) broj_pl++;
                else if(cube[i][i][i]==opponent) broj_op++;
            }
            if(broj_pl>0 && broj_op==0){
                if(broj_pl==1) result+=2;
                else if(broj_pl==2) result+=4;
            }
            else if(broj_pl==0 && broj_op>0){
                if(broj_op==1) result-=1;
                else if(broj_op==2) result-=3;
            }
            broj_pl=0;
            broj_op=0;
            for(int i=0;i<3;i++){
                if(cube[i][i][2-i]==player) broj_pl++;
                else if(cube[i][i][2-i]==opponent) broj_op++;
            }
            if(broj_pl>0 && broj_op==0){
                if(broj_pl==1) result+=2;
                else if(broj_pl==2) result+=4;
            }
            else if(broj_pl==0 && broj_op>0){
                if(broj_op==1) result-=1;
                else if(broj_op==2) result-=3;
            }
            broj_pl=0;
            broj_op=0;
            for(int i=0;i<3;i++){
                if(cube[2-i][i][i]==player) broj_pl++;
                else if(cube[2-i][i][i]==opponent) broj_op++;
            }
            if(broj_pl>0 && broj_op==0){
                if(broj_pl==1) result+=2;
                else if(broj_pl==2) result+=4;
            }
            else if(broj_pl==0 && broj_op>0){
                if(broj_op==1) result-=1;
                else if(broj_op==2) result-=3;
            }
            broj_pl=0;
            broj_op=0;
            for(int i=0;i<3;i++){
                if(cube[i][2-i][i]==player) broj_pl++;
                else if(cube[i][2-i][i]==opponent) broj_op++;
            }
            if(broj_pl>0 && broj_op==0){
                if(broj_pl==1) result+=2;
                else if(broj_pl==2) result+=4;
            }
            else if(broj_pl==0 && broj_op>0){
                if(broj_op==1) result-=1;
                else if(broj_op==2) result-=3;
            }
            if (player=='O') return -result;
            return result;
        }
        //vraca optimalnu dubinu minmax
        @Override
        public int maxDepth()
        {
            return 27-mNumber;
        }
        
        //iscrtava kocku u terminalu
        @Override
        public void print()
        {
            int i;
            //rub prvog levela
            System.out.println("       ____________");
            //prvi redak prvog levela
            System.out.print("      /");
            for(i=0;i<3;i++){
               System.out.print(" " + cube[0][0][i] + " /");
            }
            System.out.println("|");
            //linija 
            System.out.println("     /___/___/___/ |");
            //drugi redak prvog levela
            System.out.print("    /");
            for(i=0;i<3;i++){
               System.out.print(" " + cube[0][1][i] + " /");
            }
            System.out.println("  |");
            //linija
            System.out.println("   /___/___/___/   |");
            //treci redak prvog levela
            System.out.print("  /");
            for(i=0;i<3;i++){
               System.out.print(" " + cube[0][2][i] + " /");
            }
            System.out.println("    |");
            //linija
            System.out.println(" /___/___/___/     |");

            //ovaj dio bi trebao bit isti za svaki "blok"
            for(int j=1;j<2;j++){
                //razmaknica medu levelima
                System.out.println("|     |______|_____|");
                //prvi redak drugog levela
                System.out.print("|     /");
                System.out.println(" " + cube[j][0][0] + " / " + cube[j][0][1] + 
                "|/ " + cube[j][0][2] + " /" + "|");
                //linija
                System.out.println("|    /___/___|___/ |");
                //drugi redak drugog levela
                System.out.print("|   /");
                System.out.println(" " + cube[j][1][0] + " / " + cube[j][1][1] + 
                " /|" + cube[j][1][2] + " /" + "  |");
                //linija
                System.out.println("|  /___/___/_|_/   |");
                //treci redak drugog levela
                System.out.print("| /");
                System.out.println(" " + cube[j][2][0] + " / " + cube[j][2][1] +
                " / " + cube[j][2][2] + "|/" + "    |");
                //linija
                System.out.println("|/___/___/___|     |");
            }
            //razmaknica medu levelima
            System.out.println("|     |______|_____|");
            //prvi redak cetvrtog levela
            System.out.print("|     /");
            System.out.println(" " + cube[2][0][0] + " / " + cube[2][0][1] + 
            "|/ " + cube[2][0][2] + " /");
            //linija
            System.out.println("|    /___/___|___/ ");
            //drugi redak cetvrtog levela
            System.out.print("|   /");
            System.out.println(" " + cube[2][1][0] + " / " + cube[2][1][1] + 
            " /|" + cube[2][1][2] + " / ");
            //linija
            System.out.println("|  /___/___/_|_/");
            //treci redak cetvrtog levela
            System.out.print("| /");
            System.out.println(" " + cube[2][2][0] + " / " + cube[2][2][1] + " / " +
            cube[2][2][2] + "|/");
            //linija
            System.out.println("|/___/___/___|");
        }
        
        @Override
        public Cube clone(){
            return new Cube3(mNumber,cube);
        }
}
