package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        Objects.requireNonNull(a,"Tabellen er null!");
        for (int i = 0; i < a.length; i++){
            if (a[i] != null) {
                if (antall == 0) {
                    hode = new Node<>(a[i], null, null);
                    hale = hode;
                } else {
                    hale.neste = new Node<>(a[i], hale, null);
                    hale = hale.neste;
                }
                antall++;
            }
        }
    }

    public Liste<T> subliste(int fra, int til) {
        Liste<T> liste = new DobbeltLenketListe<>();
        fratilKontroll(antall, fra, til);
        Node denne = finnNode(fra);
        for (int i = fra; i < til; i++){
            liste.leggInn((T) denne.verdi);
            denne = denne.neste;
        }
        return liste;
    }

    public static void fratilKontroll(int antall, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > antall(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    private Node<T> finnNode(int indeks){
        if (indeks < antall/2){
            Node denne = hode;
            for (int i = 0; i < indeks; i++){
                denne = denne.neste;
            }
            return denne;
        }else {
            Node denne = hale;
            for (int i = antall - 1; i > indeks; i--){
                denne = denne.forrige;
            }
            return denne;
        }
    }



    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Verdi er null");
            if (antall == 0) {
                hode = new Node<>(verdi, null, null);
                hale = hode;
            } else {
                hale.neste = new Node<>(verdi, hale, null);
                hale = hale.neste;
            }
            antall++;
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        if (verdi == null){
            throw new NullPointerException("Verdien er null");
        }
        if (indeks < 0 || indeks > antall){
            throw new IndexOutOfBoundsException("Feil indeks");
        }
        if (indeks == 0){
            if (antall == 0){
                hode = new Node<>(verdi, null, null);
                hale = hode;
            } else {
                Node ny = new Node(verdi);
                ny.neste = hode;
                hode.forrige = ny;
                hode = ny;
            }
        } else if (indeks == antall){
            Node ny = new Node(verdi);
            ny.forrige = hale;
            hale.neste = ny;
            hale = ny;
        } else {
            Node ny = new Node(verdi);
            Node p = finnNode(indeks-1);
            ny.neste = p.neste;
            ny.forrige = p;
            p.neste = ny;
            ny.neste.forrige = ny;
        }
        antall++;
        endringer++;
    }

    @Override
    public boolean inneholder(T verdi) {
        if (indeksTil(verdi) == -1){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        Node denne = hode;
        for (int i = 0; i < antall; i++){
            if (denne.verdi.equals(verdi)){
                return i;
            }
            denne = denne.neste;
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        indeksKontroll(indeks, false);
        Objects.requireNonNull(nyverdi, "Verdien er null");
        Node denne = finnNode(indeks);
        T retur = (T) denne.verdi;
        denne.verdi = nyverdi;
        endringer++;
        return retur;
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    /*
    DobbeltLenketliste l = new DobbeltLenketListe();
    l.toString();

     */
    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Node denne = hode;
        while(denne != null){
            sj.add(denne.verdi.toString());
            denne = denne.neste;
        }
        return sj.toString();
    }

    public String omvendtString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Node denne = hale;
        while(denne != null){
            sj.add(denne.verdi.toString());
            denne = denne.forrige;
        }
        return sj.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


