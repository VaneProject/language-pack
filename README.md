# Language-pack
해당 라이브러리는 다양한 언어를 출력할때 해당 기기의 언어에 맞게 표시되게 하고 싶을때 유용하게 사용할 수 있도록 만들어진 라이브러리 입니다.

# Language List
| code | language  |
|:----:|:---------:|
|  en  |  english  |
|  ko  |  korean   |
|  jp  | japanese  |
|  zh  |  chinese  |
|  de  |  german   |
|  ru  |  russian  |

### LanguageList
LanguageList는 다양한 언어를 저장하는 클래스입니다.
편의성을 위해 List&lt;String&gt;를 상속 받고 있지만 remove를 제외한 값이 변경이 되는 함수는 사용할 수 없습니다. <br>

조회를 하게 되면 기본값으로 지정된 언어를 조회하며, 값을 변경할때는 LanguageList에서 지정된 함수를 사용하여 값을 추가할 수 있습니다.

**LanguageList(Country... countries)** <br>
가변 갯수를 입력 받게 되는데 생성자에 입력한 Country의 순서는 값을 넣을때 입력할 언어를 순서대로 입력

**add(String... s)** <br>
추가할때 생성자에 입력한 갯수와 일치해야하며 순서는 생성자에서 입력한 순서대로 입력


예제
```java
LanguageList list = new LanguageList(Country.KO, Country.EN, Country.JP);
list.add("안녕", "Hello", "こんにちは");
list.add("세계", "World", "世界");
System.out.println(list.get(0));
System.out.println(list.get(1));
```

출력 (컴퓨터 언어가 한국으로 설정되어 있을때)
```agsl
안녕
세계
```

### LanguageGroup

**LanguageGroup.builder()** <br>
LanguageGroup은 builder로 생성할 수 있습니다. 
다양한 언어종류를 넣어서 사용할 수 있게 만드는 클래스 입니다.

### String getText()
컴퓨터 언어기준 택스트를 반환합니다. 해당 언어가 존재하지 않거나 지원하지 않는 언어일때 null 값을 반환합니다.

### String getText(Locale locale)
Locale기준 언어 택스트를 반환합니다. 해당 언어가 존재하지 않거나 지원하지 않는 언어일때 null 값을 반환합니다.

### String getText(Country country)
Country기준 택스트를 반환합니다. 해당 언어가 존재하지 않거나 지원하지 않는 언어일때 null 값을 반환합니다.

## 예제

---

사용 예시 (로컬 언어 출력)
```java
LanguageGroup languageGroup = LanguageGroup.builder()
                .ko("안녕")
                .en("Hello")
                .jp("こんにちは")
                .zh("哈啰")
                .build();
System.out.println(languageGroup.getText());
System.out.println(languageGroup);
```
예제 출력 (한국 기준 컴퓨터) 
```agsl
안녕
안녕
```

---

사용 예제 (지정 언어 사용)
```java
LanguageGroup languageGroup = LanguageGroup.builder()
                .ko("안녕")
                .en("Hello")
                .jp("こんにちは")
                .zh("哈啰")
                .build();
System.out.println(languageGroup.getText(Locale.ENGLISH));
System.out.println(languageGroup.getText(Country.EN));
```
출력
```agsl
Hello
Hello
```