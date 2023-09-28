import java.util.Locale;

public class LanguageTest {
    public static void main(String[] args) {
        LanguageGroup languageGroup = LanguageGroup.builder()
                .ko("안녕")
                .en("Hello")
                .jp("こんにちは")
                .zh("哈啰")
                .build();
        System.out.println(languageGroup.getText(Locale.ENGLISH));
        System.out.println(languageGroup.getText(Country.EN));
        System.out.println(languageGroup);

        LanguageList list = new LanguageList(Country.KO, Country.EN, Country.JP);
        list.add("안녕", "Hello", "こんにちは");
        list.add("세계", "World", "世界");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
