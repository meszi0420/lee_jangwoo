
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.math.*;

/**
 * 
 */
public class AsteroidView implements View {

    /**
     * Konstruktor
     * be�ll�tja az x, y �s a �rt�k�t a param�ter�l kapott dolgokra
     */
    public AsteroidView(Asteroid a, int x2, int y2) {
        asteroid = a;
        x = x2;
        y = y2;
    }

    /**
     * 
     */
    private int x;

    /**
     * 
     */
    private int y;

    /**
     *
     */
    private int radius=30;

    /**
     * 
     */
    private Asteroid asteroid;

    /**
     * Elk�ri az asteroid-t�l a travellers list�j�t a getTravellers met�dussal. Visszaadja a param�terk�nt
     * megadott traveller x koordin�t�j�t a k�perny�n, kisz�molva a travellers list�ban elfoglalt hely�b�l,
     * �s az aszteroida k�z�ppontj�b�l
     * @param t 
     * @return
     */
    public int getTravellerX(Traveller t) {
        List<Traveller> travellers
        for(int i = 0; i< travellers.length(); ++i){
            if(travellers[i]==t){
                if(i==0){
                    return ((x-radius+5);
                }else{
                    return ((x-radius+5)+((i+1)*13));        //10 az oldalhossz�s�ga a traveller-t jel�l� n�gyzetnek, 3 pixel hely van k�t n�gyzet k�z�tt
                }
            }
        }
        return 0;
    }

    /**
     * A param�terk�nt megadott traveller y koordin�t�j�t a k�perny�n, kisz�molja az aszteroida k�z�ppontja alapj�n
     * @param t 
     * @return
     */
    public int getTravellerY(Traveller t) {
        return x+radius+10;
    }

    /**
     * Visszaadja az asteroid tagv�ltoz�t
     * @return
     */
    public Asteroid getAsteroid() {
        return asteroid;
    }

    /**
     * V�gign�zi az asteroid szomsz�dait, �s ha valamelyik megegyezik a param�ter�l
     * kapott aszteroid�val, akkor igazzal, egy�bk�nt meg hamissal t�r vissza
     * @param a 
     * @return
     */
    public boolean isThisYourNeighbour(Asteroid a) {
        ArrayList<INeighbour> neighbours = asteroid.getNeighbours();
        for(int i=0; i<neighbours.length(); ++i){
            if(neighbours[i]==a){
                return true;
            }
        }
        return false;
    }

    /**
     * Visszaadja az x tagv�ltoz�t
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Visszaadja az y tagv�ltoz�t
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Ellen�rzi, hogy a param�ter�l kapott koordin�t�k �ltal meghat�rozott pont az aszteroida k�r�n bel�l van-e
     * @param int xClicked
     * @param int yClicked
     * @return igaz, ha bel�l van, egy�bk�nt hamis
     */
    public boolean clicked(int xClicked, int yClicked) {
        if((pow((xClicked-x), 2)*pow((yClicked-y), 2))<pow(radius, 2){
            return true;
        }
        return false;
    }

    /**
     * kirajzolja az aszteroid�t �gy hogy megfeleljen az �llapot�nak
     * @param g
     */
    public void draw(Graphics g) {
        int aShell = asteroid.getShell();
        bool aCloseToSun = asteroid.getCloseToSun();
        if(aShell!=0){
            if(aCloseToSun){
                g.setColor(new Color(255, 201, 14));      //s�rga
                g.fillOval(x, y, radius*2, radius*2);
                g.setColor(new Color(255, 255, 255));       //feh�r
                g.fillOval(x, y, radius*2-4, radius*2-4);
                g.setColor(new Color(0, 0, 0));     //fekete
                g.drawString(aShell, x-(fontMetrics.stringWidth(aShell)/2), y-(fontMetrics.getHeight()/2);

            }else{
                Mineral aCore = asteroid.getCore();
                g.setColor(new Color(0, 0, 0));       //fekete
                g.fillOval(x, y, radius*2, radius*2);
                g.setColor(mineralColor(aCore));
                g.fillOval(x, y, radius*2-4, radius*2-4);
            }
        }

    }

}