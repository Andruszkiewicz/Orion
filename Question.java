
package Orion.Model;

/**
 * klasa Question której obiektami są pytania do quizu wiedzy
 * @author karolinaandruszkiewicz
 */
public class Question{
        /**treść pytania*/
        public String question; 
        /**tablica typu String zawierająca wypisywane odpowiedzi*/
        public String[] answers; 
        /**indeks poprawnej odpowiedzi w tablicy wypisywanych odpowiedzi*/
        public int correctAnswer; 
        /**
         * konstruktor argumentowy pytania
         * @param question
         * @param answers
         * @param correctAnswer 
         */
        Question(String question,String[] answers, int correctAnswer ){
            this.question=question; 
            this.answers=answers; 
            this.correctAnswer=correctAnswer; 
            
        }
        /**
         * konstruktor bezargumentowy pytania
         */
        Question(){
            
        }
    }