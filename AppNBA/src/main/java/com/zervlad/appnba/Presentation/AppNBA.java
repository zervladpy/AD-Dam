package com.zervlad.appnba.Presentation;

import com.google.gson.Gson;
import com.zervlad.appnba.Core.Data.Game.GameIAPI;
import com.zervlad.appnba.Core.Data.Game.GameIDAO;
import com.zervlad.appnba.Core.Data.Game.GameIRepository;
import com.zervlad.appnba.Core.Data.Player.PlayerIAPI;
import com.zervlad.appnba.Core.Data.Player.PlayerIDAO;
import com.zervlad.appnba.Core.Data.Player.PlayerIRepository;
import com.zervlad.appnba.Core.Data.Team.TeamIAPI;
import com.zervlad.appnba.Core.Data.Team.TeamIDAO;
import com.zervlad.appnba.Core.Data.Team.TeamIRepository;
import com.zervlad.appnba.Core.Requets.ApiRequest;
import com.zervlad.appnba.Core.Services.DependenciesManagerNBA;
import com.zervlad.appnba.Core.Services.EntityManagerNBA;
import com.zervlad.appnba.Core.Services.GsonManagerNBA;
import jakarta.persistence.EntityManagerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class AppNBA extends Application {

    public static void main(String[] args) throws URISyntaxException, IOException {

        setup();

        launch();
    }

    private static void setup() {
        // --- Dependencies Manager --- //
        DependenciesManagerNBA di = DependenciesManagerNBA.getInstance();

        // --- ApiRequest --- //
        ApiRequest apiRequest = new ApiRequest(); // Using default API key
        di.addDependency(ApiRequest.class, apiRequest); // Adding dependency to the DI container

        // --- GSON --- //
        Gson gson = GsonManagerNBA.getInstance();
        di.addDependency(Gson.class, gson);

        // --- Entity Manager --- //
        EntityManagerFactory entityManagerFactory = EntityManagerNBA.getEntityManagerFactory();

        // --- Team Repository --- //
        TeamIAPI teamAPI = new TeamIAPI(apiRequest, gson);
        TeamIDAO teamDAO = new TeamIDAO(entityManagerFactory);
        di.addDependency(TeamIRepository.class, new TeamIRepository(teamAPI, teamDAO));

        // --- Player Repository --- //

        PlayerIDAO playerDAO = new PlayerIDAO(entityManagerFactory);
        PlayerIAPI playerAPI = new PlayerIAPI(apiRequest, gson);
        di.addDependency(PlayerIRepository.class, new PlayerIRepository(playerAPI, playerDAO));

        // --- Game Repository --- //
        GameIDAO gameDAO = new GameIDAO(entityManagerFactory);
        GameIAPI gameAPI = new GameIAPI(gson, apiRequest);
        di.addDependency(GameIRepository.class, new GameIRepository(gameAPI, gameDAO));

        // --- Load Data --- //
        onStartLoadData();
    }

    private static void onStartLoadData() {
        DependenciesManagerNBA di = DependenciesManagerNBA.getInstance();

        di.getDependency(TeamIRepository.class).getAll();
        di.getDependency(PlayerIRepository.class).getAll();
        // di.getDependency(GameRepository.class).getAll();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppNBA.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}

