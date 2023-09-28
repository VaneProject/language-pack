import lombok.RequiredArgsConstructor;

import java.util.Locale;
import java.util.Objects;

@RequiredArgsConstructor
public enum Country {
    EN, KO, JP,
    ZH, DE, RU;

    private final Locale locale = new Locale(name());

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
