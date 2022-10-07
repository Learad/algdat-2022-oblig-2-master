# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Leart Radoniqi, S367250, s367250@oslomet.no

# Oppgavebeskrivelse

I oppgave 1 lagde jeg Int antall som bare returnerer antallvariablen til listen,
og boolean tom() som sjekker om antallvariabelen = 0.
I konstruktøren legger jeg først inn hodeverdien, derretter itererer jeg igjenom listen
og legger til alle andre verdier.

I oppgave 2a toString-metoden brukte jeg en Stringjoiner, startet i hode og la til verdien i stringjoinerer,
så itererte jeg igjennom hele listen bare ved å bruke denne.neste og legge til resten av verdiene.
I omvendtString gjorde jeg det samme bare ved starte i hale og bruke denne.forrige.

I oppgave 2b startet jeg med å lage en requireNonNull for verdi. dersom listen er tom setter jeg hode = hale = new Node(verdi);.
Ellers bruker jeg bare hale og setter hale.neste = newNode(verdi).
Den nye noden blir da den nye halen.

I oppgave 3a lagde jeg metoden finnNode(int indeks). Dersom indeks < antall/2, starter jeg i hode, og teller oppover til jeg finner
riktig indeks. Om indeks er større enn antall/2 starter jeg i hale og gjør det samme. Derretter lagde jeg metoden public T hent som
bruker finnNode og returnerer verdien til den noden vi finner. I oppdater bruker jeg også finnNode. Når noden er funnet
lagrer jeg verdien i en tempvariabel, oppdaterer verdien i noden og til slutt returnerer jeg tempverdien.

I oppgave 3b brukte jeg finnNode til å finne noden i indeks fra.
Derretter itererte jeg igjennom fram til indeks til og samtidig la inn Nodene i en liste.

I oppgave 4 lagde metoden indeksTil som starter i hode og går igjennom listen. Dersom vi finner verdien returnerer den indeksen.
Hvis jeg har gått igjennom hele listen uten å finne verdien returnerer jeg -1. i inneholder metoden, så bruker vi indekstil.
Dersom jeg får -1 returnerer vi false.

Oppgave 5 sjekker jeg først om indeks = 0. dersom index = 0 sjekker vi så om listen er tom.
Om listen er tom skriver jeg hode = hale = new Node. Dersom den
ikke er tom gjør jeg den nye Noden til den nye hode. Deretter sjekker vi om index = antall. Dersom den blir det så
blir den nye noden den nye halen. Ellers skal den legges inn i midten av listen og da endrer vi bare på pekerne.

I oppgave 6 lagde jeg to fjern-metoder. I den første fjern(int indeks) sjekker vi først om antall = 1. Dersom den er det setter vi hode = hale = null.
Derretter sjekker jeg om indeks = 0. Om den er det forflytter vi hode ved å bruke hode = hode.neste.
Derretter sjekker jeg om indeks = antall - 1. Om den er det, forflytter vi halen ved å bruke hale = hale.forrige.
Til sist sjekker jeg om indeks er midt i mellom hale og hode. Dersom den er det flytter vi pekerne til de nodene vedsidenav,
slik at de peker på hverandre.

I den andre fjernmetoden itererer jeg først igjennom listen til jeg finner riktig verdi. 
Dersom jeg har gått igjennom hele listen uten å finne verdien returnerer jeg false.
Derretter bruker jeg samme prinsipp som i forrige fjern metode.

I oppgave 8a lagde jeg metoden T next(). Først sjekket jeg om iteratorendringer != endringer.
Dersom den var det kaster jeg en exception. Derretter sjekker jeg om hasNext() var false. Hvis den var false kaster jeg en
exception. fjernOK settes til true, jeg lagrer verdien i denne som temp-variabel. så setter jeg denne = denne.neste. Derretter returnerer jeg temp-variabelen.

I oppgave 8b returnerte jeg bare iteratorklassen.

I oppgave 8c gjorde jeg det samme som i standardkonstruktøren, 
men istedenfor å sette denne = hode, brukte jeg finnNode for å finne riktig node istedenfor.

I oppgave 8d gjorde jeg det samme som i oppgave 8b bare ved å bruke den andre konstruktøren som tar inn indeks som parameter. 
