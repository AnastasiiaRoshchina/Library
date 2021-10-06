/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class App {
    Scanner scanner = new Scanner(System.in);
    Book[] books = new Book[10];
    public App(){
    }
    public void run(){
        String repeat = "y";
        do{
            System.out.println("Выберите задачу: ");
            System.out.println("0: Закончить программу ");
            System.out.println("1: Добавить кнгиу ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task){
                case 0:
                    repeat="q";
                    System.out.println("Программа закончена");
                    break;
                case 1:
                    repeat="q";
                    System.out.println("Добавление книги: ");
                     for (int i = 0; i<books.length; i++){
                    if(books[i]==null){
                     books[i] = addBook();
                     break;
                    }
                }
                    break; 
            }
        }while("q".equals(repeat));
       
    }
    
    private Book addBook(){
    Book book = new Book();
    System.out.print("Введите название книги: ");
    book.setCaption(scanner.nextLine());
    System.out.print("Введите год издания: ");
    book.setPublishedYear(scanner.nextInt());
    scanner.nextLine();
    System.out.print("Сколько авторов у книги? ");
    int countAutors = scanner.nextInt();
    scanner.nextLine();
    
    Author[] authors = new Author[countAutors];
        for (int i = 0; i < authors.length; i++) {
            System.out.println("Добавление автора"+(i+1));
            Author author = new Author();
            System.out.print("Имя автора: ");
            author.setName(scanner.nextLine());
            System.out.print("Фамилия автора: ");
            author.setLastname(scanner.nextLine());
            System.out.print("Год рождения автора: ");
            author.setYear(scanner.nextInt());
            System.out.print("Месяц рождения автора: ");
            author.setMonth(scanner.nextInt());
            System.out.print("День рождения автора: ");
            author.setDay(scanner.nextInt());
            scanner.nextLine();
            
          
            authors[i]=author;
            
        }
    book.setAutor(authors);
    return book;
    }
//           //System.out.println("Hello");
//           Book book1 = new Book();
//           book1.setCaption("Voina i Mir");
//           Author author1 = new Author();
//           author1.setName("Lev");
//           author1.setLastname("Tolstoy");
//           author1.setYear(1828);
//           author1.setDay(9);
//           author1.setMonth(9);
//           Author[] authors = new Author[1];
//           authors[0]=author1;
//           book1.setAutor(authors);
//           book1.setPublishedYear(2005);
//           
//           Book book2 = new Book();
//           book2.setCaption("Otsi i deti");
//           Author author2 = new Author();
//           author2.setName("Ivan");
//           author2.setLastname("Turgenev");
//           author2.setYear(1818);
//           author2.setDay(9);
//           author2.setMonth(11);
//           Author[] authors2 = new Author[1];
//           authors[0]=author2;
//           book2.setAutor(authors2);
//           book2.setPublishedYear(2007);
//           Reader reeder1 = new Reader();
//           reeder1.setFirstname("Ivan");
//           reeder1.setLastname("Ivanov");
//           reeder1.setPhone("4565545345");
//           
//           History history1 = new History();
//           history1.setBook(book1);
//           history1.setReader(reeder1);
//           Calendar c = new GregorianCalendar(); 
//           history1.setGivenDate(c.getTime());
//           System.out.println("history1="+history1.toString());
//           System.out.println("---------------------");
//           history1.setReturnDate(c.getTime());
//           System.out.println("history1="+history1.toString());
//           
//           
//    }
//    
//    
}
