import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Locale;
import java.util.Objects;

@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LanguageGroup {
    // https://help.ads.microsoft.com/#apex/18/ko/10004/-1
    // 영어, 한국어, 일본어
    private final String en, ko, jp;
    // 중국어, 독일어, 러시아어
    private final String zh, de, ru;

    private String findText(Country country) {
        return switch (country) {
            case EN -> en;
            case KO -> ko;
            case JP -> jp;
            case ZH -> zh;
            case DE -> de;
            case RU -> ru;
        };
    }

    public String getText() {
        return getText(Locale.getDefault());
    }

    public String getText(@NonNull Locale locale) {
        Country country = getcountry(locale);
        // do not support language
        return (country == null) ? null : findText(country);
    }

    public String getText(@NonNull Country country) {
        return findText(country);
    }

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
