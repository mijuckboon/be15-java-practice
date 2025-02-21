package jinwoong.level02.normal.book.run;

import jinwoong.level02.normal.book.model.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        BookDTO basic = new BookDTO();
        basic.printInformation();
        BookDTO java = new BookDTO("자바의 정석", "도우출판", "남궁성");
        java.printInformation();
        BookDTO gildong = new BookDTO("홍길동전", "활빈당", "허균", 5_000_000, 0.5);
        gildong.printInformation();
    }
}
