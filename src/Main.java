import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String choice;
        String ceaserCrypt; 

        try {
            File file = new File("static/data.txt");
            Scanner scanner = new Scanner(file);
            StringBuilder contents = new StringBuilder();
            while (scanner.hasNextLine()) {
                contents.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        
        do {
            System.out.println("Menu:");
            System.out.println("1. Cripta il contenuto del file");
            System.out.println("2. Decripta il contenuto del file");
            System.out.println("3. Stampa il contenuto del file decriptato");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                System.out.println("---------------------------");
                System.out.println("Cripta");
                System.out.println("1. Algoritmo di Cesare");
                System.out.println("2. Algoritmo XOR");
                System.out.println("0. Esci");
                System.out.print("Scelta: ");
                choice = scanner.nextLine();

                    switch (choice){
                        case "1": 
                        System.out.print("Inserire lo shift per la cifratura di Cesare: ");
                        int shift = scanner.nextInt();
                        String encrypted = cesarCrypt(contents.toString(), shift);
                        FileWriter writerEncrypt = new FileWriter(file);
                        writerEncrypt.write(encrypted);
                        writerEncrypt.close();
                        System.out.println("Contenuto criptato con successo.");
                        break;
                
                    }
                    break;

                case "2":
                System.out.println("---------------------------");
                System.out.println("Decripta");
                System.out.println("1. Algoritmo di Cesare");
                System.out.println("2. Algoritmo XOR");
                System.out.println("0. Esci");
                System.out.print("Scelta: ");
                choice = scanner.nextLine();

                    switch (choice) {
                        case "1":
                        System.out.print("Inserire lo shift per la decifratura di Cesare: ");
                        int decryptShift = scanner.nextInt();
                        String decrypted = cesarDecrypt(contents.toString(), decryptShift);
                        FileWriter writerDecrypt = new FileWriter(file);
                        writerDecrypt.write(decrypted);
                        writerDecrypt.close();
                        System.out.println("Contenuto decriptato con successo.");
                            break;
                    }
                    break;
                
                    case "3":
                    
                    break;
                
                case "0":
                    System.out.println("Programma terminato.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
            
        } while (!choice.equals("0"));
        
        scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato.");
        } catch (IOException e) {
            System.out.println("Errore di I/O.");
        }

        
    }
}