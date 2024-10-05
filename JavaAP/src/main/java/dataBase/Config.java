package dataBase;

/**
 * Конфигурационный файл для хранения констант
 * */

public final class Config {
    private Config() {
    } //чтобы нельзя было создать объект

    public static final String URL_STUDY = "jdbc:postgresql://localhost:5432/study";
    public static final String USER = "postgres";
    public static final String PASSWORD = "IwanttoMurea";
}
