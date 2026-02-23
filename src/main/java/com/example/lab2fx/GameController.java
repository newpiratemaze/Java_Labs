package com.example.lab2fx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.*;

import javafx.scene.input.MouseEvent;
import java.util.Random;

public class GameController {

    @FXML private Pane gamePane;
    @FXML private Circle ball;
    @FXML private Label scoreLabel;


    @FXML private IntegerProperty score = new SimpleIntegerProperty(0);



    @FXML
    public void initialize() {
        // Шарик в центре панели
        //ball.setCenterX(gamePane.getWidth() / 2);
        //ball.setCenterY(gamePane.getHeight() / 2);
        scoreLabel.textProperty().bind(
                javafx.beans.binding.Bindings.concat("Счет: ", score)
        );
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        // Ппроверка попадания
        double dx = event.getX() - ball.getCenterX();
        double dy = event.getY() - ball.getCenterY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance <= ball.getRadius()) {
            // Просто меняем значение - UI обновится САМ
            score.set(score.get() + 1);
            // При попадании Перемещаем шарик
            moveBallToRandomPosition();
        }
    }


    private void moveBallToRandomPosition() {
        Random random = new Random();
        double newX = ball.getRadius() +
                random.nextDouble() * (gamePane.getWidth() - 3 * ball.getRadius());
        double newY = ball.getRadius() +
                random.nextDouble() * (gamePane.getHeight() - 3 * ball.getRadius());

        ball.setCenterX(newX);
        ball.setCenterY(newY);
    }


}
