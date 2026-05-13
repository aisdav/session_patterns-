// Создаем абстракный класс для всех баз данных
abstract class DB {
    abstract void connect();
    abstract void disconnect();
}
// Теперь наш mysql зависит от абстрактного класса DB
class MySQLDatabase extends DB {
    public void connect() {
        System.out.println("Подключение к MySQL");
    }

    public void disconnect() {
        System.out.println("Отключение от MySQL");
    }
}
// Добавил postgresql для вариативности
class PostgreSQLDatabase extends DB {
    public void connect() {
        System.out.println("Подключение к PostgreSQL");
    }

    public void disconnect() {
        System.out.println("Отключение от PostgreSQL...");
    }
}
//Теперь наш высокоуровневый код зависит от абстрактций
class DataProcessor {
    // Вот здесь в типах пишем абстрактный класс DB
    private DB database;

    public DataProcessor(DB database) {
        this.database = database;
    }

    public void process() {
        database.connect();
        System.out.println("Обработка данных...");
        database.disconnect();
    }
}
// теперь этот соответствует принцип DIP
