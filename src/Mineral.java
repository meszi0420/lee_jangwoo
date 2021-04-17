/**
 * Egy absztrakt osztály, összefogja az összes nyersanyagot, amely kibányászható. Felelőssége
 * egy függvény biztosítani az aszteroidának, amit meghívhat, ha az napközelbe ért.
 */
public abstract class Mineral {

    /**
     * Default constructor
     */
    public Mineral() {}

    /**
     * Napközelbe kerüléskor meghívódó (jelenleg üres) függvény. A leszármazottak
     * újraimplementálhatják, ha szükséges(pl. jég, radioaktív nyersanyagok).
     * @param a az az aszteroida, amelynek ez a nyersanyag a magja.
     */
    public void exposedToSun(Asteroid a) {}
    
    /**
     * A mineral tipusát adja vissza Stringben. 
     * Mivel a mineral abstract ezért ez sosem hívódhat meg.
     * @return a típus neve szövegként
     */
    public String toString() { 
    	return "mineral";
    }
}