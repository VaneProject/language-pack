import java.util.Locale;
import java.util.Objects;

/**
 * country list
 */
public enum Country {
    /**
     * English
     */
    EN,
    /**
     * Korean
     */
    KO,
    /**
     * Japanese
     */
    JP,
    /**
     * Chinese
     */
    ZH,
    /**
     * German
     */
    DE,
    /**
     * Russian
     */
    RU;

    private final Locale locale = new Locale(name());

    /**
     * @return get language type
     */
    public String getLanguage() {
        return locale.getLanguage();
    }

    static Country getDefaultCountry() {
        String defaultLanguage = Locale.getDefault().getLanguage();
        for (Country country : Country.values()) {
            if (Objects.equals(defaultLanguage, country.locale.getLanguage())) {
                return country;
            }
        }
        throw new RuntimeException("not define langauge: " + defaultLanguage);
    }
}
