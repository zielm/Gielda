<h1> Giełda </h1>

Projekt symulujący działanie giełdy na zajęcia z programowania obiektowego. Został stworzony w środowisku NetBeans IDE w języka Java 8. GUI zostało stworzone przy użyciu biblioteki Swing.

Do stworzenia wykresów użyto bibliotek JFreeChart
http://www.jfree.org/jfreechart/

<h1>Opis działania</h1>

Przy włączeniu programu można wybrać tworzenie nowej symulacji (samodzielne wybranie ilości wszystkich dostępnych obiektów) lub odtworzenie poprzedniej symulacji. 

W zaprogramowanym przeze mnie świecie musi istnieć conajmniej jedna waluta i conajmniej jedna giełda. Istnieje jeden rynek walut i jeden rynek surowców, a zasoby stworzonych walut / surowców są na nich nieskończone.

Wszyscy inwestorzy i fundusze korzystają z dolarów amerykańskich, więc nie mogą zakupić USD na rynku walut. Waluta w jakiej są notowane akcje spółki wynika z waluty giełdy na której się znajdują. Przy kupnie/sprzedaży aktyw (jeśli zachodzi potrzeba) następuje przewalutowanie, to znaczy: wartość aktualna aktywa (w walucie zależacej od giełdy / surowca) zostaje przemnożona przez cenę kupna / sprzedaży zależnie od potrzeb.
Zmiana kursu waluty następuje 2 razy częściej niż dla innych aktywów, więc niewskazane jest łączenie ich na wykresie.
USD nie może być wyświetlane na wykresie ze względu na to, że kursy walut są wyświetlane w dolarach amerykańskich.

Jeśli chodzi o indeksy to są 4 możliwe rodzaje:
 * bIA - posiadające największą liczbę akcji na giełdzie
 * sIA - posiadające najmniejszą liczbę akcji na giełdzie
 * bLW - posiadające najwyższą liczbę wolumenów
 * sLW - posiadające najmniejszą liczbę wolumenów
Wartość indeksu jest określana cześciowo losowo z pomocą wielkości wolumenów/obrotów.
