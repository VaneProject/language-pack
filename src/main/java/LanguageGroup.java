import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Locale;
import java.util.Objects;

/**
 * https://help.ads.microsoft.com/#apex/18/ko/10004/-1 <br>
 * language pack
 */
@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LanguageGroup {
    /**
     * 영어, 한국어, 일본어
     */
    private final String en, ko, jp;
    /**
     * 중국어, 독일어, 러시아어
     */
    private final String zh, de, ru;

    private String findText(Country country) {
        switch (country) {
            case EN: return en;
            case KO: return ko;
            case JP: return jp;
            case ZH: return zh;
            case DE: return de;
            case RU: return ru;
            default: throw new IncompatibleClassChangeError();
        }
    }

    /**
     * @return get local text
     */
    public String getText() {
        return getText(Locale.getDefault());
    }

    /**
     * @param locale locale
     * @return get locale text
     */
    public String getText(@NonNull Locale locale) {
        Country country = getcountry(locale);
        // do not support language
        return (country == null) ? null : findText(country);
    }

    /**
     * @param country Country
     * @return get country text
     */
    public String getText(@NonNull Country country) {
        return findText(country);
    }

    /**
     * @param locale java.util.Locale
     * @return get country locale
     */
    private Country getcountry(Locale locale) {
        for (Country country : Country.values()) {
            if (Objects.equals(country.getLanguage(), locale.getLanguage())) {
                return country;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.getText();
    }
}
