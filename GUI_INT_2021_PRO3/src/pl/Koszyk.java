package pl;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Koszyk extends Pane {

    private float xPos ;
    private float yPos ;
    private float PosRightX = 500;
    private float PosUpY = 250;
    private float PosDownY = 350;
    private float PosLeftX = 250;
    int dx = 5;
    int dy = 5;
    private Direction direction = Direction.RIGHT;

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
    public Koszyk(int xPos,int yPos,int dim1, int dim2) {
        super();
        setPrefSize(dim1,dim2);
        this.xPos = xPos;
        this.yPos = yPos;
        setLayoutX(xPos);
        setLayoutY(yPos);
        setVisible(true);
        //this.setStyle("-fx-background-color: brown");
        Image img = new Image("pl/basketFinal.png");
        Image img2 = new Image("pl/wolf2.gif");
        ImageView imgView = new ImageView(img);
        ImageView imgView2 = new ImageView(img2);
        getChildren().add(imgView);
        getChildren().add(imgView2);
        System.out.println(xPos+" "+yPos);
    }
    public void poruszKoszyk() {
        switch(direction) {
            case LEFT :
                xPos = PosLeftX;
                setLayoutX(PosLeftX);
                break;
            case RIGHT :
                xPos = PosRightX;
                setLayoutX(PosRightX);
                break;
            case UP :
                yPos = PosUpY;
                setLayoutY(PosUpY);
                break;
            case DOWN :
                yPos = PosDownY;
                setLayoutY(PosDownY);
                break;
        }
        if (xPos > Main.dimX) {
            dx = -dx;
        }
        if (xPos < 0) {
            dx = -dx;
        }
        if (yPos > Main.dimY) {
            dy = -dy;
        }
        if (xPos < 0) {
            dy = -dy;
        }
    }
    @Override
    public boolean contains(Point2D point2D) {

        return super.contains(point2D);
    }

    public float getyPos() {
        return yPos;
    }
    public float getxPos() {
        return xPos;
    }

    public Direction getDirection() {

        return direction;
    }

    public void setDirection(Direction direction) {

        this.direction = direction;
    }
}
