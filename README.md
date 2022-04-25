# gra_typu_nupogodi

===================================

Gra „Nu pogodi!”
Napisz program bedacy gra w stylu “Nu pogodi!”. Gra polega na zbieraniu jajek wypuszczanych
przez zajaca z czterech kurników. Program powinien w jak najwiekszym stopniu przypominac
oryginał.

Uzytkownik steruje wilkiem próbujacym wyłapac wszystkie jajka wypuszczane do rynien
przez zajaca w takim czasie, aby jajka nie uległy zetknieciu z ziemia i rozbiciu. Nalezy zastosowac
animacje obrazów (zgodnie z animacja cwiczona podczas zajec). Gra trwa dopóki nie zostana
rozbite 4 jajka.

Licznosc jaj, predkosc rozgrywki, oraz zarzadzanie rozgrywka jest dowolne, ustalane przez
Panstwa. Nalezy zapewnic pełna funkcjonalnosc gry. Liczona bedzie inwencja twórcza. Moga
Panstwo wykorzystac istniejaca grafike dotyczaca gry.

Nalezy zapewnic w pełni funkcjonalny interfejs graficzny. Konsola polecen (CLI) moze byc jedynie
pomoca informacyjna, ale nie moze zachodzic tam zadna znaczaca interakcja uzytkownika
z programem.

Program po uruchomieniu powinien wyswietlac menu główne składajace sie z opcji:

• New Game - nowa gra

• High Scores - tabela wyników

• Exit – wyjscie

Po uruchomieniu gry, toczy sie ona według wyzej wymienionych zasad. Nalezy zapewnic
mozliwosc przerwania gry w dowolnym momencie poprzez wybrany przez Panstwa złozony skrót
klawiszowy (Ctrl+Shift+Q), który spowoduje powrót do menu głównego.

Nawigacja moze sie odbywac na poprzez klawisze klawiatury i klikanie na przyciski wskazujace kierunek, utworzone
przez Panstwa w oknie gry.

Po zakonczeniu gry, w nowym oknie gracz proszony jest o swoja nazwe pod jaka ma byc
zapisywany w rankingu.

Ranking liczony jest na podstawie czasu, zdobytych punktów. Nalezy zapewnic trwałosc
rankingu po ponownym uruchomieniu aplikacji, czyli nalezy go przechowywac w pliku na dysku.
Postac przechowywanych danych jest sprawa drugorzedna i nie musi byc czytelna dla gracza
(mozna wykorzystac np. interfejs Serializable).

Po wybraniu opcji rankingu z menu głównego, zostaje on wyswietlony uzytkownikowi. Poniewaz
okno rankingu moze byc relatywnie duze, dlatego nalezy zadbac o paski przewijania, w
razie gdyby nie miescił sie on w oknie racjonalnych rozmiarów.

• Nalezy zadbac o wyjatki w programie. Jesli jakis wystapi nalezy wyswietlic jego komunikat
uzytkownikowi.
• Ranking nalezy zrealizowac przy pomocy komponentu ListView.
• Nie wszystkie okna musza byc realizowane poprzez klase Application. Przy mniejszych i
informacyjnych oknach mozna wykorzystac okna dialogowe.

