
package myclasses;

import entity.Reader;
import entity.Book;
import entity.Author;
import entity.History;
import interfaces.Keeping;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import keeper.FileKeeper;

public class App {
    Scanner scanner = new Scanner(System.in);
    List<Book> books = new ArrayList<>();
    List<Reader> readers = new ArrayList<>();
    List<History> histories = new ArrayList<>();
    Keeping keeper = new FileKeeper(); //ctrl + r чтобы изменить везде в программе название переменной 
    //Keeping keeper = new BaseKeeper(); //изменим реализацию кипера
    
    public App() {//constructor
        books = keeper.loadBooks(); //подгружаем книги из файла
        histories = keeper.loadHistories();
        readers = keeper.loadReaders();
    }
    public void run(){
        String repeat = "y";
        do{
            System.out.println("Выберите задачу");
            System.out.println("0: закончить программу");
            System.out.println("1: добавить книгу");
            System.out.println("2: Вывести список книг");
            System.out.println("3: Добавить читателя");
            System.out.println("4: Список читателей");
            System.out.println("5: Выдать книгу");
            System.out.println("6: Список выданных книг");
            System.out.println("7: Вернуть книгу");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch(task){
                case 0: 
                    repeat ="q"; // в конце проверяется, равна ли эта строка "y". если не равна, то программа заканчивается
                    System.out.println("Программа закончена");
                    break;
               
                case 1: 
                    addBook();
                    break;
                case 2:
                    printListBooks(); 
                    break;
                
                case 3:
                    addReader();              
                    break;
                    
                case 4:
                    printListReaders();
                    break;
                    
                case 5:
                    addHistory();
                    break;
                    
                case 6:
                    printGivenBooks();
                    break;
                    
                case 7:
                    returnBook();
                    break;
                
            }
        }while("y".equals(repeat));
    }
    
   
    
    private History addHistory(){
        System.out.println("Выдача книги");
        History history = new History();
        /**
         * 1. вывести нумированный список книг
         * 2. получить от читателя номер книги: bookNumber
         * 3. вывести список читателей
         * 4. получить номер читателя: readerNumber
         * 5. в history инициировать поле book объектом, который  лежит в массиве books[bookNumber-1]
         * 6. в history инициировать поле reader объектом, который лежит в массиве readers[readerNumber-1]
         * 7. полуичть текущую дату и положить ее в поле history.givenDate
         */
        
        System.out.println("Список книг библиотеки:");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i)!=null){
                System.out.printf("%d. %s%n", (i+1), books.get(i).toString()); 
            }
        }
        System.out.print("Номер книги: ");
        int bookNumber = scanner.nextInt(); scanner.nextLine();
        history.setBook(books.get(bookNumber-1));
        
        System.out.println("Список читателей");
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i)!=null){
                System.out.printf("%d. %s%n", (i+1), readers.get(i).toString()); 
            }
        }
        System.out.print("Номер читателя: ");
        int readerNumber = scanner.nextInt(); scanner.nextLine();
        history.setReader(readers.get(readerNumber-1)); 
        
        //задать сегодняшнюю дату
        Calendar c = new GregorianCalendar();
        history.setGivenDate(c.getTime());
        history.getBook().setCoutn(history.getBook().getCoutn() -1);
        keeper.saveBooks(books);
        //задать дату возврата
//        c.add(Calendar.WEEK_OF_YEAR, 2);
//        history.setReturnDate(c.getTime());
        histories.add(history);
        keeper.saveHistories(histories);
        
        return history;
    }
    
    
    private void addBook(){
        Book book = new Book();
        System.out.println("Добавление книги");
        System.out.print("Название книги: ");
        book.setCaption(scanner.nextLine());
        System.out.print("Год публикации: ");
        book.setPublishedYear(scanner.nextInt());
        scanner.nextLine();
        
        System.out.print("Количество экземпляров: ");
        book.setQuantity(scanner.nextInt());
        book.setCoutn(book.getQuantity());
        scanner.nextLine();
/**
 * считает знак новой строки и очистит буфер от знака новой строки, чтобы он не попал в след. сканер и не пропустил след. строку. 
 * нужен только если после считывания цифры считывается строка
*/
        System.out.print("Кол-во авторов: ");
        int authorsNum = scanner.nextInt();
        scanner.nextLine();
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < authorsNum ; i++) {
            System.out.print("Имя автора "+(i+1)+": ");//сложение в скобках
            Author author = new Author();
            author.setName(scanner.nextLine());
            System.out.print("Фамилия автора: ");
            author.setLastname(scanner.nextLine());
            System.out.print("День рождения: ");
            author.setDay(scanner.nextInt());
            System.out.print("Месяц рождения: ");
            author.setMonth(scanner.nextInt());
            System.out.print("Год рождения: ");
            author.setYear(scanner.nextInt());
            scanner.nextLine();
            authors.add(author);
        }
        book.setAuthor(authors);
        books.add(book);//добавление в список
        keeper.saveBooks(books);
        
    }
    
            
    private void addReader(){
        System.out.println("Добавления читателя");
        Reader reader = new Reader();
        System.out.print("Имя читателя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.println("Фамилия читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.println("телефон читателя: ");
        reader.setPhone(scanner.nextLine());
        readers.add(reader);
        keeper.saveReaders(readers);

    }
    
    private void printGivenBooks(){
        System.out.println("Выданные книги:");
        int n = 0;
        for (int i = 0; i < histories.size(); i++) {
            if (histories.get(i)!=null && histories.get(i).getReturnDate() == null){
                System.out.printf("%d. Книгу %s читает %s %s%n",
                (i+1),
                histories.get(i).getBook().getCaption(), 
                histories.get(i).getReader().getFirstname(), 
                histories.get(i).getReader().getLastname());
               n++;
            }
        }
        if (n<1){
            System.out.println("Выданных книг нет");
        }
    }

    private void printListBooks() {
       System.out.println("Список книг:");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i)!=null && books.get(i).getCoutn()>0){//во избежание ошибки nullpointerexception, когда печатаешь массив из 10 ячеек, но только 2 заполнены
               System.out.println((i+1)+ " " + books.get(i).toString()); 
            }
        }
    }

    private void printListReaders() {
        System.out.println("Список читателей");
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i)!=null){
               System.out.println(readers.get(i).toString()); 
            }
        }
    }

    private void returnBook() {
        System.out.println("Возвращение книги");
        printGivenBooks();   
        System.out.print("Выберите возвращаемую книгу: ");
        int historyNumber = scanner.nextInt(); scanner.nextLine();
        Calendar c = new GregorianCalendar();
        histories.get(historyNumber-1).setReturnDate(c.getTime());
        keeper.saveHistories(histories);
    }
}