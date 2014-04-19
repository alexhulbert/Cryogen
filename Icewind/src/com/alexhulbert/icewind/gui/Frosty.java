package com.alexhulbert.icewind.gui;

import java.awt.image.BufferedImage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.*;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Frosty {

    private boolean enabled = false;
    private int blurAmount = 0;
    private final ImageView background = new ImageView();
    private final StackPane layout = new StackPane();
    private final StackPane root = new StackPane();
    private final Rectangle shadow = new Rectangle();
    private Stage stage;
    private Rectangle smoke;
    private DropShadow beFocused;
    private DropShadow beUnfocused;
    private boolean focusing = true;
    private boolean tmpFocus = false;
    private Scene scene;
    private static final java.awt.Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private BufferedImage desktop;
    private boolean capturing = false;

    public void setBlur(int amount) {
        blurAmount = amount;
        beFocused = new DropShadow(BlurType.THREE_PASS_BOX, Color.BLACK, 15, 0.1, 0, 0);
        beUnfocused = new DropShadow(BlurType.THREE_PASS_BOX, Color.DARKGREY, 15, 0, 0, 0);
        BoxBlur bb = new BoxBlur(amount, amount, 3);
        //beFocused.setInput(bb); background.setEffect(beFocused);
        //beUnfocused.setInput(bb); background.setEffect(beUnfocused);
        //bb.setInput(beFocused);
        background.setEffect(bb);
        shadow.setEffect(beFocused);
    }

    public void setEnabled(boolean enable, boolean real) {
        if (enable) {
            layout.setStyle("-fx-background-color: null");
            behind(
                    (int) stage.getX(),
                    (int) stage.getY(),
                    (int) stage.getWidth(),
                    (int) stage.getHeight()
            );
        } else {
            layout.setStyle("-fx-background-color: white");
            background.setImage(null);
        }
        
        enabled = (!real && enabled) || (real && enable);
    }

    public int getBlur() {
        return blurAmount;
    }

    public Scene getScene() {
        return scene;
    }

    public Frosty(final Stage stage, Pane parent, Node content) {
        enabled = Options.fancyBlur;
        this.stage = stage;

        root.getChildren().setAll(shadow, layout);
        
        java.awt.Rectangle fullScreen = new java.awt.Rectangle(0, 0, screen.width, screen.height);
        java.awt.Robot robot = null;
        try {
            robot = new java.awt.Robot();
        } catch (java.awt.AWTException ex) {
        }
        desktop = robot.createScreenCapture(fullScreen);

        if (enabled) {
            layout.getChildren().setAll(background, content);
            layout.setStyle("-fx-background-color: null");
        } else {
            layout.setStyle("-fx-background-color: white");
        }
        
        parent.getChildren().add(root);

        Scene scene = new Scene(
                parent,
                1000, 600,
                Color.TRANSPARENT
        );

        stage.setScene(scene);
        stage.show();

        //stage.setHeight(600);
        //stage.setWidth(800);
        Platform.setImplicitExit(false);

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) //Platform.exit();
                {
                    //setEnabled(!enabled, true);
                    stage.toBack();
                }
            }
        });
        smoke = makeSmoke(stage);

        behind(
                (int) stage.getX(),
                (int) stage.getY(),
                (int) stage.getWidth(),
                (int) stage.getHeight()
        );
        setBlur(25);

        makeDraggable(stage, layout);

        stage.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                focusing = t1;
                if (enabled) {
                    if (focusing) {
                        capture();
                    } else {
                        setEnabled(false, false);
                        tmpFocus = true;
                    }
                }
            }
        });
    }

    private void capture() {
        final double realX = stage.getX();
        final double realY = stage.getY();
        if (capturing || realX >= screen.width || realY >= screen.height) {
            return;
        }
        capturing = true;
        
        //stage.toBack();
        Timeline pause = new Timeline(new KeyFrame(Duration.millis(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setX(screen.width);
                stage.setY(screen.height);
            }
        }));
        
        pause.getKeyFrames().add(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                java.awt.Rectangle fullScreen = new java.awt.Rectangle(0, 0, screen.width, screen.height);
                java.awt.Robot robot = null;
                try {
                    robot = new java.awt.Robot();
                } catch (java.awt.AWTException ex) {
                }
                desktop = robot.createScreenCapture(fullScreen);
            }
        }));
        
        pause.getKeyFrames().add(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 stage.setX(realX);
                 stage.setY(realY);
                //stage.toFront();
                capturing = false;
            }
        }));
        pause.play();
    }

    private void behind(final int x, final int y, final int w, final int h) {
        if (!enabled || capturing) {
            return;
        }
        if (w == 0 || h == 0) {
            return;
        }
        if (x >= 0 && y >= 0 && (w+x) <= screen.width && (h+y) <= screen.height) {
            background.setImage(SwingFXUtils.toFXImage(desktop.getSubimage(x, y, w, h), null));
        } else {
            BufferedImage unpadded = desktop.getSubimage(0, 0, Math.min(w + x, screen.width) - x, Math.min(h + y, screen.height) - y);
            BufferedImage newImage = new BufferedImage(w, h, unpadded.getType());

            java.awt.Graphics tmpGraphics = newImage.getGraphics();
            tmpGraphics.setColor(java.awt.Color.white);
            tmpGraphics.fillRect(0, 0, w, h);
            tmpGraphics.drawImage(unpadded, -1*Math.min(0, x), -1*Math.min(0, y), null);
            tmpGraphics.dispose();
            background.setImage(SwingFXUtils.toFXImage(newImage, null));
        }
    }

    // create some content to be displayed on top of the frozen glass panel.
    private Label createContent() {
        Label label = new Label("Create a new question for drop shadow effects.\n\nDrag to move\n\nDouble click to close");
        //label.setPadding(new Insets(10));

        label.setStyle("-fx-font-size: 15px; -fx-text-fill: green;");
        label.setMaxWidth(250);
        label.setWrapText(true);

        return label;
    }

    // makes a stage draggable using a given node.
    public void makeDraggable(final Stage stage, final Node byNode) {
        final Delta dragDelta = new Delta();
        byNode.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (Options.graphicsLevel < 3) {
                    layout.setStyle("-fx-background-color: white");
                }
                // record a delta distance for the drag and drop operation.
                dragDelta.x = stage.getX() - mouseEvent.getScreenX();
                dragDelta.y = stage.getY() - mouseEvent.getScreenY();
                byNode.setCursor(Cursor.MOVE);
            }
        });
        final BooleanProperty inDrag = new SimpleBooleanProperty(false);

        byNode.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                byNode.setCursor(Cursor.HAND);
                if (Options.graphicsLevel < 3) {
                    behind(
                            (int) stage.getX(),
                            (int) stage.getY(),
                            (int) stage.getWidth(),
                            (int) stage.getHeight()
                    );
                    layout.getChildren().set(
                            0,
                            background
                    );
                }
                inDrag.set(false);
            }
        });
        byNode.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double nex = mouseEvent.getScreenX() + dragDelta.x;
                double ney = mouseEvent.getScreenY() + dragDelta.y;
                stage.setX(nex);
                stage.setY(ney);
                if (Options.graphicsLevel >= 3) {
                    behind(
                            (int) nex,
                            (int) ney,
                            (int) stage.getWidth(),
                            (int) stage.getHeight()
                    );
                } else {
                    layout.getChildren().set(
                            0,
                            makeSmoke(stage)
                    );
                }

                inDrag.set(true);
            }
        });
        byNode.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    byNode.setCursor(Cursor.HAND);
                }
            }
        });

        byNode.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    byNode.setCursor(Cursor.DEFAULT);
                }
            }
        });
    }

    private javafx.scene.shape.Rectangle makeSmoke(Stage stage) {
        javafx.scene.shape.Rectangle rect = new javafx.scene.shape.Rectangle(
                stage.getWidth(),
                stage.getHeight(),
                Color.WHITESMOKE.deriveColor(
                        0, 1, 1, 0.08
                )   
        );
        return rect;
    }

    /**
     * records relative x and y co-ordinates.
     */
    private class Delta {

        double x, y;
    }
}
