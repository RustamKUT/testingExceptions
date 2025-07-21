public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) // Исключение передаем номер товара который ненашли
    {
        super("Товар с id = " + id + " не найден"); //  исключение вывод текста
    }
}
