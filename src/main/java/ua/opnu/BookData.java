package ua.opnu;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public double getRating() {
        if (reviews == 0) return 0.0;
        return total / reviews;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(BookData other) {
        // Книга з вищим рейтингом повинна бути "менше" (йти першою)
        int ratingRes = Double.compare(other.getRating(), this.getRating());

        if (ratingRes != 0) {
            return ratingRes;
        }
        // Якщо рейтинги рівні, сортуємо за назвою
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", rating=" + String.format("%.2f", getRating()) +
                '}';
    }
}