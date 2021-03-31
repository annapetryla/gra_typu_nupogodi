package pl;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Jajko extends Circle {

    int dy = 3;
    int dx = 3;
    float posCenterX;
    float posCenterY;
    boolean isVisible = true;
    Point2D centerPoint = new Point2D(posCenterX,posCenterY);

    public Jajko(float centerX,float centerY) {
        super();
        this.posCenterX = centerX;
        this.posCenterY = centerY;
        setCenterX(posCenterX);
        setCenterY(posCenterY);
        setRadius(Main.promien);
        setFill(Color.YELLOW);
        setStroke(Color.LIGHTCORAL);
    }
    public void ruszJajko() {
        setCenterX(posCenterX);
        setCenterY(posCenterY);
        posCenterX = posCenterX + dy;
        posCenterY = posCenterY + dy;
        setCenterX(posCenterX);
        setCenterY(posCenterY);
        setVisible(isVisible);
    }
    public void ruszJajkoReverse() {
        setCenterX(posCenterX);
        setCenterY(posCenterY);
        posCenterX = posCenterX - dy;
        posCenterY = posCenterY + dy;
        setCenterX(posCenterX);
        setCenterY(posCenterY);
        setVisible(isVisible);
    }

    public float getPosCenterX() {

        return posCenterX;
    }

    public float getPosCenterY() {

        return posCenterY;
    }
}
