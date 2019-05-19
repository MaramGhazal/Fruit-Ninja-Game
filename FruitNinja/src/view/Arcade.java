package view;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Element;
import model.bomb.Dangerous;
import model.bomb.Fatal;
import model.fruit.Apple;
import model.fruit.SpecialApple;
import model.fruit.SpecialGrape;
import javafx.scene.media.MediaView;

public class Arcade {
	Stage stage;
	Controller controller;

	public Arcade(Stage stage, Controller controller) {
		this.stage = stage;
		this.controller = controller;
	}

	AnchorPane root;
	Scene scene;
	Image background;
	ImageView image;
//	ImageView live1;
//	ImageView loss1;
//	ImageView live2;
//	ImageView loss2;
//	ImageView live3;
//	ImageView loss3;
//	Image heart;
//	Image splash;
	Label score;
	Label best;
	Image ba;
	Image SCORE;
	ImageView SCOREVIEW;
	Image bestSCORE;
	ImageView BESTSCOREView;
	ImageView back;
	Image backGround;
	Image gameOver;
	ImageView BACKGROUND;
	ImageView BACK;
	ImageView GAMEOVER;
	Image fSCORE;
	ImageView fSCOREVIEW;
	Label fscore;

	Integer startTime = 0;
	Integer seconds = 60;
	Integer minutes = 0;
	Integer hours = 0;
	Label timer;

	Timeline timeline;
	Timeline time;

	TranslateTransition transition;
	RotateTransition rotateTransition;
	
	private Media fruitSound;
	private AudioClip sliceFruit;

	private double delay;
	private int timelinetest = 0;
	private int TIME = 0;
	private int bestScore;
	private ArrayList<Element> elements = new ArrayList<Element>();
	private int elementCounter = 0;
	private boolean isSlicedRedApple = false;
	private boolean isSlicedStrawberry = false;
	private boolean isSlicedOrange = false;

	public void buildScene() {
		stage.setTitle("Arcade");
		stage.setResizable(false);
		root = new AnchorPane();
		scene = new Scene(root, 1200, 671);

		background = new Image("WhatsApp Image 2019-05-08 at 4.23.16 AM.jpeg");
		image = new ImageView(background);
		image.setFitWidth(1200);
		image.setFitHeight(671);

		SCORE = new Image("Score.png");
		SCOREVIEW = new ImageView(SCORE);
		SCOREVIEW.setX(14);
		SCOREVIEW.setY(14);
		SCOREVIEW.setFitHeight(50);
		SCOREVIEW.setFitWidth(156);

		bestSCORE = new Image("BestScore.png");

		bestSCORE = new Image("BestScore.png");
		BESTSCOREView = new ImageView(bestSCORE);
		BESTSCOREView.setFitHeight(23);
		BESTSCOREView.setFitWidth(150);
		BESTSCOREView.setX(14);
		BESTSCOREView.setY(76);

		score = new Label("0");
		score.setFont(new Font("Impact", 45));
		score.setLayoutX(180);
		score.setLayoutY(14);
		score.setTextFill(Color.WHITE);
		best = new Label(String.valueOf(controller.getBestScore()));
		bestScore = controller.getBestScore();
		best.setFont(new Font("Impact", 19));
		best.setLayoutX(166);
		best.setLayoutY(75);
		best.setTextFill(Color.WHITE);

		ba = new Image("back-icon-10.jpg");
		back = new ImageView(ba);
		back.setFitHeight(66);
		back.setFitWidth(66);
		back.setX(1113);
		back.setY(19);
		back.setOnMouseClicked(e -> {
			timeline.stop();
			time.stop();
			alertSound().stop();
			endAlertSound().stop();
			controller.undoBestScore(bestScore);
			MainMenu main = new MainMenu(stage);
			main.buildScene();
			main.mediaPlayer.setMute(false);

		});
		back.setOnMouseEntered(e -> {
			back.setFitHeight(72);
			back.setFitWidth(72);
			back.setX(1110);
			back.setY(16);
		});
		back.setOnMouseExited(e -> {
			back.setFitHeight(66);
			back.setFitWidth(66);
			back.setX(1113);
			back.setY(19);

		});

		root.getChildren().addAll(image, SCOREVIEW, BESTSCOREView, score, best, back);

		backGround = new Image("Slider.png");
		BACKGROUND = new ImageView(backGround);
		BACKGROUND.setVisible(false);
		BACKGROUND.setFitWidth(1240);
		BACKGROUND.setFitHeight(711);
		BACKGROUND.setX(-20);
		BACKGROUND.setY(-20);

		gameOver = new Image("Game Over.png");
		GAMEOVER = new ImageView(gameOver);
		GAMEOVER.setVisible(false);
		GAMEOVER.setFitWidth(288);
		GAMEOVER.setFitHeight(66);
		GAMEOVER.setX(456);
		GAMEOVER.setY(237);

		BACK = new ImageView(ba);
		BACK.setVisible(false);
		BACK.setFitWidth(66);
		BACK.setFitHeight(66);
		BACK.setX(567);
		BACK.setY(392);
		BACK.setOnMouseClicked(e -> {
			endAlertSound().stop();
			MainMenu main = new MainMenu(stage);
			main.buildScene();
			main.mediaPlayer.setMute(false);
		});
		BACK.setOnMouseEntered(e -> {
			BACK.setFitHeight(72);
			BACK.setFitWidth(72);
			BACK.setX(564);
			BACK.setY(389);
		});
		BACK.setOnMouseExited(e -> {
			BACK.setFitHeight(66);
			BACK.setFitWidth(66);
			BACK.setX(567);
			BACK.setY(392);

		});

		Image Timer = new Image("Timer.png");
		ImageView t = new ImageView(Timer);
		t.setFitWidth(85);
		t.setFitHeight(23);
		t.setX(14);
		t.setY(110);
		timer = new Label("60");
		timer.setFont(new Font("Impact", 19));
		timer.setLayoutX(100);
		timer.setLayoutY(110);
		timer.setTextFill(Color.WHITE);
		doTime();

		root.getChildren().addAll(t, timer, BACKGROUND, GAMEOVER, BACK);

		fSCORE = new Image("Score.png");
		fSCOREVIEW = new ImageView(fSCORE);
		fSCOREVIEW.setVisible(false);
		fSCOREVIEW.setX(465);
		fSCOREVIEW.setY(319);
		fSCOREVIEW.setFitHeight(50);
		fSCOREVIEW.setFitWidth(156);

		fscore = new Label();
		fscore.setFont(new Font("Impact", 45));
		fscore.setVisible(false);
		fscore.setLayoutX(633);
		fscore.setLayoutY(319);
		fscore.setTextFill(Color.WHITE);
		root.getChildren().addAll(fSCOREVIEW, fscore);
		
		fruitSound = new Media((new File("src/Slice.mp3")).toURI().toString());
		sliceFruit = new AudioClip(fruitSound.getSource());

		timeline = new Timeline(new KeyFrame(Duration.millis(1000), (event) -> {

			elements = controller.getElements();
			if (elementCounter > 19) {
				elementCounter = 0;
				elements = controller.updateElements();
			}
			if (elements.get(elementCounter) instanceof Apple)
				redApple(root, elementCounter);

			else if (elements.get(elementCounter) instanceof model.fruit.Orange)
				Orange(root, elementCounter);
			else if (elements.get(elementCounter) instanceof model.fruit.Strawberry)
				Strawberry(root, elementCounter);

			else if (elements.get(elementCounter) instanceof SpecialApple)
				greenApple(root, elementCounter);

			else if (elements.get(elementCounter) instanceof SpecialGrape)
				Grapes(root, elementCounter);

			elementCounter++;
			controller.setBestScore();
			best.setText(String.valueOf(controller.getBestScore()));

		}));
		timeline.setCycleCount(-1);
		timeline.play();

		stage.setScene(scene);
	}

	public void redApple(AnchorPane root, int elementNumber) {
		Random X = new Random();
		int randomX = 100 + X.nextInt(1000);
		Random Y = new Random();
		int randomY = 300 + Y.nextInt(300);
		Image redapple = new Image("redApple.png");
		ImageView RedApple = new ImageView(redapple);
		RedApple.setVisible(true);
		Image slicedredapple = new Image("SlicedRedApple.png");
		ImageView SlicedRedApple = new ImageView(slicedredapple);
		SlicedRedApple.setVisible(false);

		RedApple.setFitHeight(65);
		RedApple.setFitWidth(65);
		RedApple.setX(randomX);
		RedApple.setY(721);
		SlicedRedApple.setFitHeight(85);
		SlicedRedApple.setFitWidth(85);
		SlicedRedApple.setX(randomX);
		SlicedRedApple.setY(721);

		RedApple.setOnMouseMoved(e -> {
			sliceFruitSound().play();
			controller.slice(elementNumber);
			score.setText(Integer.toString(controller.score()));
			RedApple.setVisible(false);
			SlicedRedApple.setVisible(true);
			isSlicedRedApple = true;
		});
		Throw(RedApple, randomX, randomY, 2, false);
		Throw(SlicedRedApple, randomX, randomY, 2, true);

		root.getChildren().addAll(RedApple, SlicedRedApple);
	}

	public void greenApple(AnchorPane root, int elementNumber) {
		Random X = new Random();
		int randomX = 100 + X.nextInt(1000);
		Random Y = new Random();
		int randomY = 300 + Y.nextInt(300);
		Image greenapple1 = new Image("greenApple.png");
		ImageView GreenApple1 = new ImageView(greenapple1);
		GreenApple1.setVisible(true);
		Image slicedgreenapple1 = new Image("SlicedGreenApple.png");
		ImageView SlicedGreenApple1 = new ImageView(slicedgreenapple1);
		SlicedGreenApple1.setVisible(false);

		GreenApple1.setFitHeight(65);
		GreenApple1.setFitWidth(65);
		GreenApple1.setX(randomX);
		GreenApple1.setY(721);
		SlicedGreenApple1.setFitHeight(85);
		SlicedGreenApple1.setFitWidth(85);
		SlicedGreenApple1.setX(randomX);
		SlicedGreenApple1.setY(721);

		Throw(GreenApple1, randomX, randomY, 1, false);
		Throw(SlicedGreenApple1, randomX, randomY, 1, true);

		GreenApple1.setOnMouseMoved(e -> {
			sliceFruitSound().play();
			controller.slice(elementNumber);
			score.setText(Integer.toString(controller.score()));
			GreenApple1.setVisible(false);
			SlicedGreenApple1.setVisible(true);
		});
	
		root.getChildren().addAll(GreenApple1, SlicedGreenApple1);
	}

	public void Strawberry(AnchorPane root, int elementNumber) {
		Random X = new Random();
		int randomX = 100 + X.nextInt(1000);
		Random Y = new Random();
		int randomY = 300 + Y.nextInt(300);
		Image strawberry = new Image("Strawberry.png");
		ImageView Strawberry = new ImageView(strawberry);
		Strawberry.setVisible(true);
		Image slicedstrawberry = new Image("SlicedStawberry.png");
		ImageView SlicedStrawberry = new ImageView(slicedstrawberry);
		SlicedStrawberry.setVisible(false);

		Strawberry.setFitHeight(65);
		Strawberry.setFitWidth(65);
		Strawberry.setX(randomX);
		Strawberry.setY(721);
		SlicedStrawberry.setFitHeight(85);
		SlicedStrawberry.setFitWidth(85);
		SlicedStrawberry.setX(randomX);
		SlicedStrawberry.setY(721);
		
		Throw(Strawberry, randomX, randomY, 2, false);
		Throw(SlicedStrawberry, randomX, randomY, 2, true);

		Strawberry.setOnMouseMoved(e -> {
			sliceFruitSound().play();
			controller.slice(elementNumber);
			score.setText(Integer.toString(controller.score()));
			Strawberry.setVisible(false);
			SlicedStrawberry.setVisible(true);
			isSlicedStrawberry = true;
		});

		root.getChildren().addAll(Strawberry, SlicedStrawberry);
	}

	public void Orange(AnchorPane root, int elementNumber) {
		Random X = new Random();
		int randomX = 100 + X.nextInt(1000);
		Random Y = new Random();
		int randomY = 300 + Y.nextInt(300);
		Image orange = new Image("Orange.png");
		ImageView Orange = new ImageView(orange);
		Orange.setVisible(true);
		Image slicedornage = new Image("SlicedOrange.png");
		ImageView SlicedOrange = new ImageView(slicedornage);
		SlicedOrange.setVisible(false);

		Orange.setFitHeight(80);
		Orange.setFitWidth(80);
		Orange.setX(randomX);
		Orange.setY(721);
		SlicedOrange.setFitHeight(85);
		SlicedOrange.setFitWidth(85);
		SlicedOrange.setX(randomX);
		SlicedOrange.setY(721);
		
		Throw(Orange, randomX, randomY, 2, false);
		Throw(SlicedOrange, randomX, randomY, 2, true);

		Orange.setOnMouseMoved(e -> {
			sliceFruitSound().play();
			controller.slice(elementNumber);
			score.setText(Integer.toString(controller.score()));
			Orange.setVisible(false);
			SlicedOrange.setVisible(true);			
			isSlicedOrange = true;
		});

		root.getChildren().addAll(Orange, SlicedOrange);
	}

	public void Grapes(AnchorPane root, int elementNumber) {
		Random X = new Random();
		int randomX = 100 + X.nextInt(1000);
		Random Y = new Random();
		int randomY = 300 + Y.nextInt(300);
		Image grapes = new Image("Grapes.png");
		ImageView Grapes = new ImageView(grapes);
		Grapes.setVisible(true);
		Image slicedgrapes = new Image("SlicedGrapes.png");
		ImageView SlicedGrapes = new ImageView(slicedgrapes);
		SlicedGrapes.setVisible(false);

		Grapes.setFitHeight(65);
		Grapes.setFitWidth(65);
		Grapes.setX(randomX);
		Grapes.setY(721);
		SlicedGrapes.setFitHeight(85);
		SlicedGrapes.setFitWidth(85);
		SlicedGrapes.setX(randomX);
		SlicedGrapes.setY(721);

		Throw(Grapes, randomX, randomY, 1, false);
		Throw(SlicedGrapes, randomX, randomY, 1, true);

		Grapes.setOnMouseMoved(e -> {
			sliceFruitSound().play();
			controller.slice(elementNumber);
			score.setText(Integer.toString(controller.score()));
			Grapes.setVisible(false);
			SlicedGrapes.setVisible(true);
			
		});
		
		root.getChildren().addAll(Grapes, SlicedGrapes);
	}

	
	
	public void Throw(Node node, int X, int y, double speed, Boolean slice) {
		
		if (!slice) {
			Random d = new Random();
			delay = d.nextDouble();
		} else
			delay = delay;
		timelinetest += 0;
		transition = new TranslateTransition();
		transition.setToY(-y);
		transition.setDuration(Duration.seconds(1.5));
		transition.setAutoReverse(true);
		transition.setDelay(Duration.seconds(delay));
		transition.setCycleCount(2);
		transition.setNode(node);
		transition.play();

		rotateTransition = new RotateTransition(Duration.seconds(1));
		rotateTransition.setByAngle(360 * 10);
		rotateTransition.setRate(0.05);
		rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
		rotateTransition.setNode(node);
		rotateTransition.play();

		CubicCurve cubicCurve = new CubicCurve();

	}

    private void doTime() {
        time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        if (time != null) {
            time.stop();
        }
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ;
                seconds--;
                if (seconds == 0) {
                    time.stop();
                    BACKGROUND.setVisible(true);
                    GAMEOVER.setVisible(true);
                    BACK.setVisible(true);
                    fSCOREVIEW.setVisible(true);
                    fscore.setVisible(true);
                    fscore.setText(Integer.toString(controller.score()));
                    time.stop();
                    timeline.stop();
                    alertSound().stop();
                    endAlertSound().play();

                }
                if(seconds == 3) {
                	alertSound().play();
            		
                }
                if (seconds <= 3) {
                    timer.setTextFill(Color.RED);

                }
                timer.setText(seconds.toString());

            }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();

    }
    
	public AudioClip sliceFruitSound() {
		sliceFruit.setVolume(200.0D);
		return sliceFruit;
	}
    
    public AudioClip endAlertSound() {
		Media sound = new Media((new File("src/end.mp3")).toURI().toString());
		AudioClip alert = new AudioClip(sound.getSource());
		alert.setVolume(200.0D);
		return alert;
    }
    
    public AudioClip alertSound() {
		Media sound = new Media((new File("src/3seconds.mp3")).toURI().toString());
		AudioClip alert = new AudioClip(sound.getSource());
		alert.setVolume(200.0D);
		return alert;
    }

}
