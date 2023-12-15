package ra.program;

import ra.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> list = new ArrayList<>();

        do {
            System.out.println("==========MENU==========");
            System.out.println("1. Nhập vào sách ");
            System.out.println("2. Update danh sách ");
            System.out.println("3. Xoá sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Hiển thị danh sách sách");
            System.out.println("6. Thoát");
            System.out.println("Chọn menu ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    do {
                        Book book = new Book();
                        book.inputData();
                        list.add(book);
                        System.out.println("Muốn nhập nữa không (1. có) Or (0. Ko)");
                        int check = Integer.parseInt(sc.nextLine());
                        if (check == 0)
                            break;
                    } while (true);
                }
                case 2 -> {
                    System.out.println("Nhập mã sách cần cập nhật: ");
                    String upID = sc.nextLine();
                    int cout = 0;
                    for (Book book : list) {
                        if (book.getBookID().equals(upID)) {
                            System.out.println("Cập nhật lại danh sách sách");
                            System.out.println("Cập nhật mã sách:");
                            do {
                                book.setBookID(sc.nextLine());
                                if (book.getBookID().startsWith("B")) {
                                    if (book.getBookID().length() == 4) {
                                        break;
                                    } else {
                                        System.out.println("Mã sách phải 4 ký tự");
                                    }
                                } else {
                                    System.err.println("Mã phải bắt đầu Bằng B");
                                }
                            } while (true);
                            System.out.println("Cập nhập tên sách:");
                            do {
                                book.setBookName(sc.nextLine());
                                if (book.getBookName().length() > 3 && book.getBookName().length() < 100) {
                                    break;
                                } else {
                                    System.err.println("Yêu cầu nhập lại");
                                }
                            } while (true);

                            System.out.println("cập nhật giá: ");
                            do {
                                book.setPrice(sc.nextDouble());
                                if (book.getPrice() > 0) {
                                    break;
                                } else {
                                    System.err.println("Yêu cầu nhập đúng giá tiền");
                                }
                            } while (true);

                            System.out.println("cập nhật tên tác giả");
                            do {
                                book.setAuthor(sc.nextLine());
                                if (!book.getAuthor().trim().equals("")) {
                                    break;
                                } else {
                                    System.err.println("Yêu cầu nhập lại");
                                }
                            } while (true);
                            list.set(list.indexOf(book), book);
                            break;
                        }
                        cout++;
                    }
                    if (cout == 0) {
                        System.out.println("Không tìm được mã sách");
                    }
                }
                case 3 -> {
                    System.out.println("Nhập mã sách cần xoá");
                    String delete = sc.nextLine();
                    int check = 0;
                    for (Book mss : list) {
                        if (mss.getBookID().equals(delete)) {
                            list.remove(mss);
                            System.out.println("Đã xoá sách");
                            break;
                        }
                        check++;
                    }
                    if (check == 0) {
                        System.out.println("Mã sách không tồn tại");
                    }
                }
                case 4 -> {
                    System.out.println("Nhập mã sách cần tìm");
                    String search = sc.nextLine();
                    for (Book srh : list) {
                        if (srh.getBookID().equals(search)) {
                            srh.displayData();
                            break;
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Danh sách sách: ");
                    for (Book bk : list) {
                        bk.displayData();
                    }
                }
                case 6 -> System.exit(1);
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }
}
