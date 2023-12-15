package ra.model;

import java.util.Scanner;

public class Book implements IBook {
    private String bookID;
    private String bookName;
    private double price;
    private String author;


    public Book() {
    }

    public Book(String bookID, String bookName, double price, String author) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào mã sách ");
        do {
            bookID = scanner.nextLine();
            if(bookID.startsWith("B")){
                if(bookID.length() == 4){
                    break;
                } else {
                    System.out.println("Mã sách phải 4 ký tự");
                }
            } else {
                System.err.println("Mã phải bắt đầu Bằng B");
            }
        } while (true);
        // nhập tiếp nhé và validate dữ liệu theo yêu cầu
         System.out.println("Nhập tên sách : ");
                    do {
                        bookName = scanner.nextLine();
                        if (bookName.length() > 3 && bookName.length() < 100){
                            break;
                        } else {
                            System.err.println("Yêu cầu nhập lại");
                        }
                    } while (true);
        System.out.println("Giá tiền: ");
        do{
            price = Double.parseDouble(scanner.nextLine());
            if (price > 0){
                break;
            } else {
                System.err.println("Yêu cầu nhập đúng giá tiền");
            }
        }while (true);
        System.out.println("Tác giả cuốn sách: ");
        do {
            author = scanner.nextLine();
            if (author.trim().equals("")){
                System.err.println("Yêu cầu nhập lại");
            } else {
                break;
            }
        } while (true);
    }


    @Override
    public void displayData() {
        System.out.println("Mã sách: "+bookID);
        System.out.println("Tên sách: "+bookName);
        System.out.println("Giá thành: "+price);
        System.out.println("Tác giả: "+author);
    }
}
