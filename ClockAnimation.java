import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class ClockAnimation extends Application {
	ClockPane clock = new ClockPane();
	Pane pane = new Pane();
  @Override // Override the start method in the Application class
 
  public void start(Stage primaryStage) {
    // Create a clock and a label
    
    
	EventHandler<ActionEvent> eventHandler = e -> {
	clock.setCurrentTime();
    };
    Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play();
	Button button = new Button("stop");
		button.setPrefSize(70, 40);
		//button.setStyle("-fx-background-color:transparent");
		button.setLayoutX(180);
		button.setLayoutY(475);
		button.setOnAction(e->animation.stop());
		
		Button button1 = new Button("start");
		button1.setPrefSize(70, 40);
		//button.setStyle("-fx-background-color:transparent");
		button1.setLayoutX(270);
		button1.setLayoutY(475);
		button1.setOnAction(e->animation.play());
	clock.setPrefSize(500,500);
	pane.getChildren().addAll(clock);
	pane.getChildren().addAll(button);
	pane.getChildren().addAll(button1);
    // Create a scene and place it in the stage
	
    Scene scene = new Scene(pane, 500, 500);
    primaryStage.setTitle("ClockAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
	
	
	
	
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  /*public static void main(String[] args) {
    launch(args);
  }*/
}