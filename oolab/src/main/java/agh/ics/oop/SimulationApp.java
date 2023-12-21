package agh.ics.oop;

import agh.ics.oop.model.ConsoleMapDisplay;
import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationPresenter presenter = loader.getController();


        // INITIALIZING MAP
//        RectangularMap rMap0 = new RectangularMap(5, 5);
//        String[] rMoves0 = {
//                "b", "f", "b", "f",
//                "l", "r", "b", "f",
//                "f", "f", "b", "l",
//                "r", "l", "b", "f",
//                "f", "f", "b", "f",
//                "f", "r", "b", "f",
//                "l", "f", "b", "r",
//                "f", "l", "b", "f",
//                "l", "f", "b", "r",
//                "f", "r", "b", "f",
//                "r", "f", "b", "r",
//        };
        List<Vector2d> startPos = List.of(
                new Vector2d(2,2),
                new Vector2d(0,0),
                new Vector2d(4,4),
                new Vector2d(3,1)
        );

        GrassField gField0 = new GrassField(15);




        List<String> listOfStr = getParameters().getRaw();





        Simulation sim1 = new Simulation(startPos, OptionsParser.parse(listOfStr.toArray(new String[0])), gField0);

        ConsoleMapDisplay testConsole = new ConsoleMapDisplay();
        gField0.addObserver(testConsole);

        gField0.addObserver(presenter);
        presenter.setMap(gField0);

        List<Simulation> testSimList = new ArrayList<>();
        testSimList.add(sim1);

        SimulationEngine e1 = new SimulationEngine(testSimList);
        configureStage(primaryStage, viewRoot);
        e1.runSync();



    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }
}
